package com.ryb.algorithm;

/**
 * 获取最大值（递归版本）
 * 学习时间复杂度，有公式！
 */
public class Demo1 {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int[] arr, int L, int R) {
        if(L == R) {
            return arr[L];
        }

        //加了以下for循环，时间复杂度会变
        for (int i = L; i <= R; i++) {
            System.out.println(arr[i]);
        }

        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr,mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
