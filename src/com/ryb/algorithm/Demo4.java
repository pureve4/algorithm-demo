package com.ryb.algorithm;

/**
 * 归并排序拓展题
 * LCR 170. 交易逆序对的总数
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 */
public class Demo4 {
    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        Demo4 demo4 = new Demo4();
        System.out.println(demo4.reversePairs(arr));
    }
    public int reversePairs(int[] record) {
        if(record == null || record.length < 2) {
            return 0;
        }
        return process(record, 0, record.length - 1);
    }

    private int process(int[] record, int l, int r) {
        if(l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(record, l, mid) + process(record, mid + 1, r) + merge(record, l, mid, r);
    }

    private int merge(int[] record, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            if(record[p1] <= record[p2]) {
                help[i++] = record[p1++];
            }else {
                help[i++] = record[p2++];
                //这步是关键
                res += mid - p1 + 1;
            }
        }
        while (p1 <= mid) {
            help[i++] = record[p1++];
        }
        while (p2 <= r) {
            help[i++] = record[p2++];
        }
        System.arraycopy(help, 0, record, l, help.length);
        return res;
    }
}
