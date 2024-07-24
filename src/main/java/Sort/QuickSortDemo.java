package Sort;

import java.util.Arrays;
import java.util.Queue;

/**
 * @Author wangzp
 * @Version V1.0.0
 * @Date 2023/5/31 10:41
 * @Description http://c.biancheng.net/view/929.html
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[] {8,2,1,4,5,6,9,3,10};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void QuickSort(int[] arr, int start, int end) {
        System.out.println(Arrays.toString(arr));
        if(start < end){
            int mid = getMid(arr,start,end);
            QuickSort(arr, start, mid-1);
            QuickSort(arr, mid+1,end);
        }
    }

    private static int getMid(int[] arr, int start, int end) {
        int cur = arr[start]; // 数组的第一个值作为中轴（分界点或关键数据）
        while (start < end){
            // / 比中轴小的记录移到低端
            while (start < end && arr[end]>cur){
                end--;
            }
            arr[start] = arr[end];
            // // 比中轴大的记录移到高端
            while (start < end && arr[start]<cur){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = cur;
        return start; // 返回中轴的位置
    }
}
