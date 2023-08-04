import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName Main
 * @description:
 * @author: wangzp
 * @create: 2023-07-23 18:45
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = k*(i+1);
        }
        int result = 0;
        for (int i : arr) {
            result+=i;
        }
        System.out.println(result);

        new HashMap<Integer,Integer>();

    }
}
