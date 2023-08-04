package MySort;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @ClassName MyMergeSort
 * @description:
 * @author: wangzp
 * @create: 2023-07-27 20:02
 * @Version 1.0
 **/
public class MyMergeSort {
    public static void main(String[] args) {

        int[] a = new int[]{12,1,42,23,123,5,23,2};


        mergeSout(a,0,a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSout(int[] a,int start,int end) { // [start,end);

        if(start==end-1)return; // 注意此处

        int mid = (start+end)/2; //  start + (end-start)/2
        mergeSout(a,start,mid); // 分
        mergeSout(a,mid,end);   // 分

        merg(a,start,mid,end);  // 合并
    }

    private static void merg(int[] a, int start, int mid, int end) {

        int i1 = start;
        int i2 = mid;

        int[] newa = new int[end]; // 辅助数组
        int i0 = 0;

        while (i1<mid && i2 < end){

            if(a[i1] < a[i2]){
                newa[i0] = a[i1];
                i0++;
                i1++;
            }else {
                newa[i0] = a[i2];
                i0++;
                i2++;
            }
        }

        while (i1<mid){
            newa[i0] = a[i1];
            i0++;
            i1++;
        }
        while (i2<end){
            newa[i0] = a[i2];
            i0++;
            i2++;
        }
        for (int i = start,x=0; i < end; i++,x++) {
            a[i] = newa[x];
        }
    }
}
