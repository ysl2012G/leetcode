package com.leetcode.algorithm.math;

public class Integer2Roman$12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int divide = 1000;
        int pos = 3;
        while (divide != 0) {
            int res = num / divide;
            num = num % divide;
            switch (res) {
            case 0:
                break;
            case 1:
            case 2:
            case 3:
                for (int i = 0; i < res; i++) {
                    sb.append(roman[2*pos]);
                }
                break;
            case 4:
                sb.append(roman[2*pos]);
                sb.append(roman[2*pos + 1]);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                sb.append(roman[2*pos + 1]);
                for (int i = 0; i < res - 5; i++) {
                    sb.append(roman[2*pos]);
                }
                break;
            case 9:
                sb.append(roman[2*pos]);
                sb.append(roman[2*pos + 2]);
                break;
            default:
                break;
            }

            num = num % divide;
            divide /= 10;
            pos --;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Integer2Roman$12().intToRoman(1994));
    }
}
