package WrittenTest;
/**
 * 连续子数组最大和
 * 时间限制： 3000MS内存限制： 589824KB
 *
 * 题目描述：
 *
 * 小红拿到了一个数组，她希望进行最多一次操作：将一个元素修改为x。小红想知道，最终的连续子数组最大和最大是多少？
 *
 * 输入描述
 *
 * 第一行输入一个正整数t，代表询问次数。
 *
 * 对于每次询问，输入两行：
 *
 * 第一行输入两个正整数n和x。代表数组的大小，以及小红可以修改成的元素。
 *
 * 第二行输入n个正整数a_i，代表小红拿到的数组。
 *
 * 1 ≤ t ≤ 100000
 *
 * 1 ≤ n ≤ 200000
 *
 * -10^9 ≤ x ,a_i ≤ 10^9
 *
 * 每组所有询问的n的和不超过200000。
 *
 * 输出描述
 *
 * 输出t行，每行输出一个整数，代表连续子数组的最大和。
 *
 * 样例输入
 *
 * 3
 * 5 10
 * 5 -1 -5 -3 2
 * 2 -3
 * -5 -2
 * 6 10
 * 4 -2 -11 -1 4 -1
 * 样例输出
 *
 * 15
 * -2
 * 15
 * 提示
 *
 * 第一组询问，修改第二个数。第二组询问，不进行任何修改。第三组询问，修改第三个数。
 */
import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName MainRedBook230723_3
 * @description:  小红书0723提前批笔试第三题AC答案
 * @author: wangzp
 * @create: 2023-07-25 10:09
 * @Version 1.0
 **/
public class MainRedBook230723_3 {
    /**
     * https://mp.weixin.qq.com/s/it36BMW4zEP6rOXiLq7ABg
     * 动态规划。
     *
     * 假设修改点为i，不难想到，最后的答案应该是  [0,i-1]中，以i-1结尾的最大和子数组，加上 [i+1,n-1]中，以i+1结尾的最大和子数组，因此我们可以预处理出 正向最大子数组 和 逆向最大子数组，枚举修改点即可。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] dp1 = new int[n];
            dp1[0] = a[0];
            int res = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                dp1[i] = Math.max(dp1[i-1] + a[i], a[i]);
                res = Math.max(res, dp1[i]);
            }

            int[] dp2 = new int[n];
            dp2[n - 1] = a[n - 1];

            for (int i = n - 2; i>= 0 ; i--) {
                dp2[i] = Math.max(dp2[i+1] + a[i], a[i]);
            }

            for (int i = 0 ; i < n ; i++) {
                // i==0
                res = Math.max(res, (i> 0 && dp1[i-1] > 0 ? dp1[i-1] : 0) + (i < n - 1 && dp2[i+1] > 0 ? dp2[i+1]: 0) + x);
            }

            System.out.println(res);
        }
    }
}
