package othercode;

import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName MainMeituan0513_1
 * @description:
 * @author: wangzp
 * @create: 2023-05-13 10:52
 * @Version 1.0
 **/
public class MainMeituan0513_1 {

    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            String s = scanner.next();
            String c = scanner.next();
            String result = jieda(s, c);
            System.out.println(result);
        }

    }

    public static String jieda(String s, String c) {
        if (c.charAt(0) == '0') {
            return s + c;
        }
        if (c.charAt(0) == '9') {
            return c + s;
        }
        int length = s.length();
        String news = "";
        for (int i = 0; i < length; i++) {
            int x = (int) c.charAt(0);
            int y = (int) s.charAt(i);
            if (x >= y) {
                news = s.substring(0, i) + c + s.substring(i);
                return news;

            }

        }
        news = s.substring(0, length) + c + s.substring(length);
        return news;
    }
}