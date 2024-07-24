package WrittenTest;

import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName Main2023090903JD
 * @description:
 * @author: wangzp
 * @create: 2023-09-09 19:55
 * @Version 1.0
 **/
public class Main2023090903JD {
    static Scanner scanner = new Scanner(System.in);
    static long M = (long) (1e9+7);
    public static void main(String[] args) {
        long result = 0;
        int n = scanner.nextInt();
        int Q=0;
        //int[] arr = new int[n+1];
        for (int j = 1; j <= n; j++) {
            long c = scanner.nextLong();
            Q += j;
            result += Q*c*(n+1-j);
            result = result%M;
        }

        System.out.println(result);
        //for (int i = 0; i < n; i++) {
        //    long r1 = 0;
        //    for (int j = i,no = 1; j < n; j++,no++) {
        //        long rrr  = no*arr[j];
        //
        //        r1 += rrr;
        //        //System.out.println(r1);
        //        result += r1;
        //        result =result%M;
        //    }
        //
        //}
        //System.out.println(result);

    }
    public static void method1(){};
}
