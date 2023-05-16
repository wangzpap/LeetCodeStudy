package WrittenTest;

import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName Main05052
 * @description:
 * @author: wangzp
 * @create: 2023-05-05 20:33
 * @Version 1.0
 **/
public class MainHuawei2023050602 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String s16 = scanner.nextLine();
        s16 = s16.substring(2);
        int i10 = Integer.parseInt(s16, 16);
        String s2 = Integer.toString(i10, 2);
        while(s2.length()<16){ // 不足16位 则前面补0
            s2 = "0"+s2;
        }
        System.out.println(s2);



    }

}
