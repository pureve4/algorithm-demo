package com.ryb.algorithm;

/**
 * 归并排序
 * O(N*logN)
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,1,5};
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, L, help.length);
    }
}
