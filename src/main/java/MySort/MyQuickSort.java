package MySort;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @ClassName MyQuickSort
 * @description:
 * @author: wangzp
 * @create: 2023-07-26 19:26
 * @Version 1.0
 **/
public class MyQuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,5,2,54,34,12,9,1};
        int start = 0,end = arr.length-1;
        quickSort(arr,start,end);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr,int start,int end) {
        if(start<end){
            int mid = getMid(arr,start,end);
            quickSort(arr,start,mid-1);
            quickSort(arr,mid+1,end);
        }
    }

    private static int getMid(int[] arr, int start, int end) {

        int m = arr[start];
        while (start < end){

            while (start < end && arr[end]>=m){ // 注意此处是>=
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start]<=m){ // 注意此处是<=
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = m;
        return start;

    }

}
