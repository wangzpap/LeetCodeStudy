import org.junit.Test;

import java.util.HashSet;

/**
 * @program: LeetCodeStudy
 * @ClassName MyTest
 * @description:
 * @author: wangzp
 * @create: 2023-07-12 19:19
 * @Version 1.0
 **/
public class MyTest {

    @Test
    public void test1(){
        int[] a = new int[3];
        System.out.println(a[0]);
        System.out.println(a[1]);
    }

    @Test
    public void test2(){

        System.out.println((int)'a'); // 97
        System.out.println("abcdef".substring(1,3)); // bc

        int[] arr = new int[10];
        System.out.println(arr[2]); // 默认0


    }
    @Test
    public void test3(){
        double p1 = 3.14159;
        String str  = String.format("|%05.2f|",p1);
        System.out.println(str);
        // |03.14|
    }

    private void modify(int[] a) {
        a[0]++;
    }

    @Test
    public void test5(){
        Short s1 = Short.valueOf("20");
        Short s2 = Short.valueOf("20");
        System.out.println(s1==s2);

        Short s3 = Short.valueOf("200");
        Short s4 = Short.valueOf("200");
        System.out.println(s3==s4);

        //true
        //false
    }
    @Test
    public void minOperations() {
        String s = "aacde";
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int j = 1; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], Integer.MIN_VALUE);
                        for (int k = i; k < j; k++) {
                            dp[i][j] = Math.min(dp[i][j], k * (Math.max(0, j - k)) + dp[k + 1][j]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[0][n - 1]);

    }
}
