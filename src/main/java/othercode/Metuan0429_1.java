package othercode;

import java.util.Scanner;


public class Metuan0429_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // n门课程
        int m = scanner.nextInt();  // m学院
        int q = scanner.nextInt();
        int[]  s = new int[n+1];  // 每个课程的开设学院
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
        }
        int[][] f = new int[4+1][n+1]; // 每个年级是否可以选择某课程
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = scanner.nextInt();
            }
        }
        int[][] g = new int[m+1][n+1];// 每个学院是否可以选择某课程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < q; i++) {

            int  a = scanner.nextInt(); // 学院
            int  b = scanner.nextInt(); // 年级
            int  c = scanner.nextInt(); // 待选课程

            int ff = f[b][c];
            int gg = g[a][c];
            if(ff == 1 && gg == 1){
                System.out.println("Help yourself");
            }
            else if(ff == 0 && gg == 0){
                int ss  = s[c];
                if(ss == a){
                    System.out.println("Ask for help");
                }else{
                    System.out.println("Impossible");
                }
            }else if(ff == 1 && gg == 0){
                int ss  = s[c];
                if(ss == a){
                    System.out.println("Ask for help");
                }else{
                    System.out.println("Impossible");
                }
            }else if(ff == 0 && gg == 1){
                int ss  = s[c];
                if(ss == a){
                    System.out.println("Ask for help");
                }else{
                    System.out.println("Impossible");
                }
            }
        }
    }
}
