package com.github.lishulongVI.algorithm;


/***
 * 给定一个长度为 n+1 的数组 nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
 *
 * 请找出数组中任意一个重复的数，但不能修改输入的数组。
 */
public class RepeatNumber {

    public static int duplicateInArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int start = 1, end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int cnt = getCountRange(nums, start, mid);
            System.out.println(String.format("start=%s,end=%s,mid=%s,cnt=%s", start, end, mid, cnt));
            if (start == end) {
                if (cnt > 1) {
                    // 找到重复的数字
                    return start;
                }
                break;
            }
            if (cnt > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }

    /**
     * 计算整个数组中有多少个数的取值在[from, to] 之间
     *
     * @param nums 数组
     * @param from 左边界
     * @param to   右边界
     * @return 数量
     */
    private static int getCountRange(int[] nums, int from, int to) {
        int cnt = 0;
        for (int e : nums) {
            if (e >= from && e <= to) {
                ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(duplicateInArray(nums));

        System.out.println(3 >> 1);

    }
}
