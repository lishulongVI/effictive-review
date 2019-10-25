package com.github.lishulongVI.algorithm;


import java.util.Arrays;
import java.util.Collections;

public class RepeatElementExit {

    private static boolean exitRepeatElement(int[] integers) {
        if (integers == null) {
            return false;
        }
        // 判断是否是存在重复数，将1~n中的数，进行归位,索引 0~n-1
        // 1，2，3，4
        // 0，1，2，3
        for (int k = 0; k < integers.length; k++) {
            int a = integers[k];
            int b = integers[a - 1];
            System.out.println(Arrays.toString(integers));
            // 对应的数值数值不一样，且下标不一样进行交换
            if (a != b && k != a - 1) {
                int c = integers[k];
                integers[k] = integers[a - 1];
                integers[a - 1] = c;
            } else if (a == b && k != a - 1) {
                System.out.println(String.format("重复的数字：%d", a));
                return true;
            }


        }
        return false;
    }


    public static void main(String[] args) {

        int[] ints = new int[]{9, 1, 2, 3, 4, 9, 6, 7, 8, 8};
//        int[] ints = new int[]{9, 1, 2, 3, 4, 5, 6, 7, 8};
//        int[] ints = new int[]{1, 2, 3,4,3};
//        int[] ints = new int[]{1};
//        int[] ints = new int[]{};
//        int[] ints = null;

        boolean b = exitRepeatElement(ints);
        System.out.println(b);

    }
}
