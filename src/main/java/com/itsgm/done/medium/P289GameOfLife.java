package com.itsgm.done.medium;



//https://leetcode.com/problems/game-of-life/
public class P289GameOfLife {

    static class Solution {


        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int ct = countLiveNeighbours(board, i, j, board.length - 1, board[i].length - 1);
                    if (board[i][j] == 1 && ct < 2) {
                        board[i][j] = 2;
                    } else if (board[i][j] == 1 && ct > 3) {
                        board[i][j] = 2;
                    } else if (board[i][j] == 0 && ct == 3) {
                        board[i][j] = -1;
                    }
                }

            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = 1;
                    } else if (board[i][j] == 2) {
                        board[i][j] = 0;
                    }
                }
            }
        }

        private int countLiveNeighbours(int[][] board, int i, int j, int imax, int jmax) {
            int res = 0;
            res += (inBoard(i - 1, j - 1, imax, jmax) ? (board[i - 1][j - 1] >= 1 ? 1 : 0) : 0);
            res += (inBoard(i - 1, j, imax, jmax) ? (board[i - 1][j] >= 1 ? 1 : 0) : 0);
            res += (inBoard(i - 1, j + 1, imax, jmax) ? (board[i - 1][j + 1] >= 1 ? 1 : 0) : 0);
            res += (inBoard(i, j - 1, imax, jmax) ? (board[i][j - 1] >= 1 ? 1 : 0) : 0);
            res += (inBoard(i, j + 1, imax, jmax) ? (board[i][j + 1] >= 1 ? 1 : 0) : 0);
            res += (inBoard(i + 1, j - 1, imax, jmax) ? (board[i + 1][j - 1] >= 1 ? 1 : 0) : 0);
            res += (inBoard(i + 1, j, imax, jmax) ? (board[i + 1][j] >= 1 ? 1 : 0) : 0);
            res += (inBoard(i + 1, j + 1, imax, jmax) ? (board[i + 1][j + 1] >= 1 ? 1 : 0) : 0);
            return res;
        }

        private boolean inBoard(int i, int j, int imax, int jmax) {
            boolean res = i >= 0
                    && j >= 0
                    && i <= imax
                    && j <= jmax;

            return res;
        }

    }
}
