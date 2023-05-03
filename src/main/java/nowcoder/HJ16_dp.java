package nowcoder;

import java.util.*;
public class HJ16_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int money = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            money /= 10;
            int[][] prices = new int[m+1][3];
            int[][] weights = new int[m+1][3];
            for (int i = 1; i <= m; i++) {
                int a = sc.nextInt();//price
                int b = sc.nextInt();//weight
                int c = sc.nextInt();
                a /= 10;//price
                b =  b*a ;//weight
                if (c == 0) {
                    // 主件
                    prices[i][0] = a;
                    weights[i][0] = b;
                } else if (prices[c][1] == 0) {
                    // 附件1
                    prices[c][1] = a;
                    weights[c][1] = b;
                } else {
                    // 附件2
                    prices[c][2] = a;
                    weights[c][2] = b;
                }
                sc.nextLine();
            }
            int[][] dp = new int[m+1][money+1];
            for (int i = 1; i <= m; i++) {  // 遍历物品
                for(int j = 1; j <= money; j++) {// 遍历金钱
                    int ap = prices[i][0];
                    int aw = weights[i][0];

                    int bp = prices[i][1];
                    int bw = weights[i][1];
                    int cp = prices[i][2];
                    int cw = weights[i][2];

                    dp[i][j] = j - ap >= 0 ? Math.max(dp[i-1][j], dp[i-1][j-ap] + aw) : dp[i-1][j];
                    dp[i][j] = j-ap-bp >= 0 ? Math.max(dp[i][j], dp[i-1][j-ap-bp] + aw + bw):dp[i][j];
                    dp[i][j] = j-ap-cp >= 0 ? Math.max(dp[i][j], dp[i-1][j-ap-cp] + aw + cw):dp[i][j];
                    dp[i][j] = j-ap-bp-cp >= 0 ? Math.max(dp[i][j], dp[i-1][j-ap-bp-cp] + aw +bw + cw):dp[i][j];
                }
            }

            System.out.println(dp[m][money] * 10);
        }
    }
}


