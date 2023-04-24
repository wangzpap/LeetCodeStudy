package othercode.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HJ2_String {
    public static void main(String[] args) {
        int result = 0;
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char c = in.next().toLowerCase().charAt(0);
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for(char ac:chars){
            if(ac == c){
                result++;
            }

        }
        System.out.println(result);
    }
}
