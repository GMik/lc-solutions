package com.itsgm.inprogress.medium;

import java.util.Arrays;

public class P869ReorderedPowerOf2 {
    public static void main(String[] args) {


        System.out.println(23 << 1);
    }

    class Solution {


        public boolean reorderedPowerOf2(int n) {


            String sorted = sort(n);

            for(int i=0; i<32; i++){
//                String check = String.valueOf(i << 1);
//                if(sorted.equals(sort(check)))
//
//                    if(sorted.equals(String.valueOf(sort(i << 1))))
//                        return true;
            }
            return false;
        }

        public String sort(int n){
            char[] arr = String.valueOf(n).toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
