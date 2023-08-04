package WrittenTest;

import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName MainNingDe2307313
 * @description:
 * @author: wangzp
 * @create: 2023-07-31 19:10
 * @Version 1.0
 **/
public class MainNingDe2307313 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();  // 输入节点数
        int[][] s = new int[num][num]; // 创建二维数组 表示x 到y的距离
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j)
                    s[i][j] = 0; // 自己到自己为0
                else s[i][j] = Integer.MAX_VALUE / 2;// 没有通路，赋予最大值
            }
        }
        for (int i = 0; i < (num - 1); i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            s[x][y] = 1;
            s[y][x] = 1;
        }

        for (int i = 0; i < num; i++) {
            int r = 0;
            for (int j = 0; j < num; j++) {
                if(i == j)continue;
                for (int m = 0; m < num; m++) {
                    s[i][j] = Math.min(s[i][j],s[i][m]+s[m][j]);
                }
                r += s[i][j];
            }
            System.out.print(r+" ");
        }
    }
}
