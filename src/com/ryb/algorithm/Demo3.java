package com.ryb.algorithm;

/**
 * 小和问题
 * 数组元素左侧比当前元素小的元素之和
 */
public class Demo3 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,1,1,1,4};
        System.out.println(smallSum(arr));
    }

    public static int smallSum(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    //arr[l-r] 既要排好序，也要求小和
    private static int process(int[] arr, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid)
                + process(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1)  : 0;
            //下面这个小于是关键！！！！！！[1,1,1,3, 1,1,1,4]   要用小于，小于等于就不行了,要左边数组先移动
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
        return res;
    }
}
