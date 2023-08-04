package WrittenTest;

import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName Main2023053102
 * @description:
 * @author: wangzp
 * @create: 2023-05-31 19:51
 * @Version 1.0
 **/

public class Main2023053102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); // 矩形区域的行数
        int n = scanner.nextInt(); // 矩形区域的列数

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 1; k <= i / 2; k++) {
                        min = Math.min(min, dp[k][j] + dp[i - k][j]);
                    }
                    for (int k = 1; k <= j / 2; k++) {
                        min = Math.min(min, dp[i][k] + dp[i][j - k]);
                    }
                    dp[i][j] = min;
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
