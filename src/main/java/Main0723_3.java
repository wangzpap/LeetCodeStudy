import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName Main0723_3
 * @description:
 * @author: wangzp
 * @create: 2023-07-23 20:18
 * @Version 1.0
 **/
public class Main0723_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            int result = Integer.MIN_VALUE;
            result = Math.max(result,getMax(arr));
            int result0 = result;
            for (int p = 0; p < n; p++) {
                int y = arr[p];
                if(y>x){
                    continue;
                }else {
                    if(x-y>result-result0){
                        arr[p] = x;
                        result = Math.max(result,getMax(arr));
                        arr[p] = y;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static int getMax(int[] arr){
        int max1 = arr[0],len = arr.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if(temp < 0) temp = arr[i];
            else temp += arr[i];
            max1 = Math.max(max1,temp);
        }
        return max1;
    }

}
