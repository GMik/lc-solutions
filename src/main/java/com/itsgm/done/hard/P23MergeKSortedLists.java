package com.itsgm.done.hard;


//https://leetcode.com/problems/merge-k-sorted-lists/
public class P23MergeKSortedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static class Solution {

        public ListNode mergeKLists(ListNode[] lists) {

            int length = lists.length;
            if (length == 1) {
                return lists[0];
            }

            int p = 2;
            int q = 1;

            while (q < length) {
                int start = 0;
                int end = q;
                while (start < length) {
                    if (end < length) {
                        lists[start] = merge(lists[start], lists[end]);
                    }
                    start += p;
                    end += p;
                }
                p *= 2;
                q *= 2;
            }

            return lists[0];
        }


        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode head = new ListNode();
            ListNode curr = head;
            while (head1 != null || head2 != null) {
                if (head1 == null) {
                    curr.next = head2;
                    head2 = null;
                } else if (head2 == null) {
                    curr.next = head1;
                    head1 = null;
                } else if (head1.val <= head2.val) {
                    curr.next = head1;
                    curr = curr.next;
                    head1 = head1.next;
                } else {
                    curr.next = head2;
                    curr = curr.next;
                    head2 = head2.next;
                }
            }
            return head.next;
        }


    }

    public static void main(String[] args) {
        P23MergeKSortedLists.Solution sol = new Solution();
        ListNode h1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode h2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode h = sol.merge(h1, h2);

        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
