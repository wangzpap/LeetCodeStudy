import java.util.*;
import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName MainXiecheng
 * @description:
 * @author: wangzp
 * @create: 2023-05-25 19:03
 * @Version 1.0
 **/
public class MainXiecheng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();


        int result = 0;

        for(int i = 1; i < str.length();i++){
            String s1 = str.substring(0,i);
            //System.out.println(s1);
            String s2 = str.substring(i);
            //System.out.println(s1 + " " +s2);

            int sum = Integer.parseInt(s1.substring(s1.length() - 1))+Integer.parseInt(s2.substring(s2.length() - 1));
            if(sum%2==0){
                result++;
            }
        }
        System.out.println(result);



    }

}
