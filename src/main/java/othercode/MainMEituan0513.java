package othercode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName MainMEituan0513
 * @description:
 * @author: wangzp
 * @create: 2023-05-13 10:23
 * @Version 1.0
 **/
public class MainMEituan0513 {

    static int T;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] p = new int[n+1];
            for (int j = 1; j <= n; j++) {
                p[j] = scanner.nextInt();
            }
            int[] result = fenshu(n,p);
            for(int r = 1;r <=n;r++){
                System.out.print(result[r]);
                if(r!=n){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static int[] fenshu(int n,int[] p){
        int[] result =  new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if(i==j)continue;

                if(p[i]==p[j]){
                    result[i]++;
                }else {
                    result[j]++;
                }
            }
        }


        return result;
    }

}
