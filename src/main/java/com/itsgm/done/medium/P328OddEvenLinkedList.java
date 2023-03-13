package com.itsgm.done.medium;

public class P328OddEvenLinkedList {

    public class ListNode {
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

    class Solution {
        public ListNode oddEvenList(ListNode head) {

            if (head == null || head.next == null || head.next.next == null) {
                return head;
            }

            ListNode oddHead = new ListNode(-1, null);
            ListNode evenHead = new ListNode(-1, null);

            ListNode oddCurr = oddHead;
            ListNode evenCurr = evenHead;

            ListNode curr = head;
            int ct = 1;

            while (curr != null) {
                if (ct++ % 2 == 1) {
                    oddCurr.next = curr;
                    oddCurr = curr;
                } else {
                    evenCurr.next = curr;
                    evenCurr = curr;
                }
                curr = curr.next;
            }

            oddCurr.next = null;
            evenCurr.next = null;


            oddCurr.next = evenHead.next;
            return oddHead.next;
        }
    }
}
