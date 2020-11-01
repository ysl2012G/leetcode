package com.leetcode.chanllenge.leetcode200;

public class WinnerOfArrayGame {
    public int getWinner(int[] arr, int k) {
        int move = 0;
        int currentRound = 0;
        int len = arr.length;
        while (currentRound < k) {
            if (currentRound > len) {
                break;
            }

            int curr = move % len;
            int next = (move + 1) % len;
            if (arr[curr] > arr[next]) {
                ++currentRound;
                int tempVal = arr[next];
                arr[next] = arr[curr];
                arr[curr] = tempVal;
            } else {
                currentRound = 1;
            }
            ++move;
        }
        return arr[move % len];
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4, 6, 7};
        System.out.println(new WinnerOfArrayGame().getWinner(arr, 2));
    }
}
