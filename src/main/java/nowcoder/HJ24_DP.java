package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/6d9d69e3898f45169a441632b325c7b4
 */
public class HJ24_DP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] dpleft = new int[N];
        int[] dpright = new int[N];
        Arrays.fill(dpleft,1);
        Arrays.fill(dpright,1);


        for (int i = 0; i < N; i++) {
            for (int l = 0; l < i; l++) {
                if(arr[l] < arr[i]){
                    dpleft[i] = Math.max(dpleft[i],dpleft[l]+1);
                }
            }
        }
//        System.out.println(Arrays.toString(dpleft));

        for (int i = N-1; i >= 0; i--) {
            for (int r = N-1; r > i; r--) {
                if(arr[r] < arr[i]){
                    dpright[i] = Math.max(dpright[i],dpright[r]+1);
                }
            }
        }
//        System.out.println(Arrays.toString(dpright));

        int resultLength = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {

            if(dpleft[i]+dpright[i]-1>resultLength){
                resultLength = dpleft[i]+dpright[i]-1;
                result = N - resultLength;
            }

        }
        System.out.println(result);



        
    }
}
