package com.leetcode.chanllenge.leetcode236;

public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        int result = 0;
        for (int i = 2; i <= n; ++i) {
            result = (result + k ) % i;
        }
        return result + 1;
    }

    public static void main(String[] args) {

        System.out.println(new FindTheWinnerOfTheCircularGame().findTheWinner(3 ,2));
    }
}
