package com.github.lishulongVI.algorithm;

public class 整数倒排 {


    /***
     * 反转整数
     * @param number
     * @return
     */
    public static int reverseNumber(int number) {
        if (number < 10) {
            return number;
        }
        int y = number % 10;
        int z = number / 10;
        int result = 0;
        result = result * 10 + y;
        while (z > 0) {
            y = z % 10;
            z /= 10;
            result = result * 10 + y;
        }
        return result;

    }

    /***
     * 怎么判断这个数值是否会溢出呢
     * @param number
     * @return
     */
    public static int reverseNumberTuning(Integer number) {
        if (number < 10) {
            return number;
        }
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println(maxValue);
        System.out.println(minValue);
        int result = 0;
        int y = 0;
        while (number > 0) {
            y = number % 10;
            number /= 10;
            result = result * 10 + y;
        }
        return result;
    }

    /***
     * 怎么判断这个数值是否会溢出呢
     * @param number
     * @return
     */
    public static int reverseNumberTuningV2(Integer number) {
        if (Math.abs(number) < 10) {
            return number;
        }
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        long result = 0;
        int y = 0;
        while (number > 0) {
            y = number % 10;
            number /= 10;
            result = result * 10 + y;
            if (minValue > result || maxValue < result)
                return 0;
        }
        System.out.println(result);
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverseNumberTuningV2(new Integer("1234567899")));
//        System.out.println(reverseNumberTuning(1234567890));

    }
}
