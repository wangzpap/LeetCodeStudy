import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName Main0723_2
 * @description:
 * @author: wangzp
 * @create: 2023-07-23 20:00
 * @Version 1.0
 **/
public class Main0723_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            for (int cur = l; cur < r; cur++) {
                arr[cur] = 1;
            }
        }
        int result = 0;
        int finalresult = 0;
        for(int i = 0; i< k;i++){
            result+=arr[i];
        }
        finalresult = result;
        for (int i = k; i < n; i++) {
            result+=arr[i];
            result-=arr[i-k];
            finalresult = Math.max(finalresult,result);
        }
        System.out.println(finalresult);


    }

}
