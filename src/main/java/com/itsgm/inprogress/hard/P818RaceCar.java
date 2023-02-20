package com.itsgm.inprogress.hard;

public class P818RaceCar {

    public static void main(String[] args) {



        Solution solution = new Solution();
        System.out.println(solution.racecar(330));
    }

    static class Solution {

        private int[] accelerate(int[] previousState) {
            return new int[]{
                    previousState[0] + previousState[1],
                    previousState[1] * 2
            };
        }

        private int[] reverse(int[] previousState) {
            return new int[]{
                    previousState[0],
                    previousState[1] > 0 ? -1 : 1
            };
        }


        public int racecar(int target) {

            if (target <= 1) {
                return 1;
            }

            int[][] previousStates = new int[2][2];
            previousStates[0][0] = 0;
            previousStates[0][1] = -1;
            previousStates[1][0] = 1;
            previousStates[1][1] = 2;

            int power = 2;
            int powerOfTwo = 2;
            while (true) {

                powerOfTwo *= 2;
                int[][] states = new int[powerOfTwo][2];

                for (int i = 0; i < powerOfTwo; i++) {

                    //0 -> position, 1 -> speed
                    int[] previousState = previousStates[i / 2];

                    if (i % 2 == 0) {

                        int[] afterReverse = reverse(previousState);
                        if (afterReverse[0] == target) {
                            return power;
                        }
                        states[i] = afterReverse; //11101 -> 16+8+4+1

                    } else {
                        int[] afterAcceleration = accelerate(previousState);
                        if (afterAcceleration[0] == target) {
                            return power;
                        }
                        states[i] = afterAcceleration;
                    }
                }

                previousStates = states;
                power++;
            }


        }
    }
}
