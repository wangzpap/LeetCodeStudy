package othercode;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @ClassName TopK
 * @description:
 * @author: wangzp
 * @create: 2023-07-27 21:45
 * @Version 1.0
 **/
public class TopK {
    public static void main(String[] args) {
        int[] a = new int[]{1,4,2,5,3,9,8,7,6};
        int K = 7;
        quickSortK(a,0,a.length-1,K);
        System.out.println(Arrays.toString(a));
        System.out.println(a[K]);
    }

    static void quickSortK(int[] a,int start,int end,int K){
        if(start<end){
            int mid = getMid(a,start,end,K);

            if(K==mid)return;

            if(K<=mid){
                quickSortK(a,start,mid-1,K);
            }else{
                quickSortK(a,mid+1,end,K);
            }
        }

    }

    private static int getMid(int[] a, int start, int end,int K) {
        int x = a[start];

        while (start < end){

            while (start < end && a[end]>=x){
                end--;
            }
            a[start] = a[end];
            while (start < end && a[start]<=x){
                start++;
            }
            a[end] = a[start];

        }
        a[start] = x;
        return start;
    }
}
