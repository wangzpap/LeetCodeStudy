package othercode;

import java.util.Scanner;

public class MainHuadongshifanP1049 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int i = scanner.nextInt();
        int j = scanner.nextInt();


//        int ix = (x >> i) & 1; // 获取x值的第i位的值
//        int jx = (x >> j) & 1; // 获取x值的第j位的值
//
//        if(ix != jx){
//            x = (1 << i)^x;  // 对第i位取反
//            x = (1 << j)^x;  // 对第j位取反
//        }
//        System.out.println(x);


        String strx = Integer.toBinaryString(x);
        if(i == j){
            System.out.println(x);
            return;
        }
        int maxij = Math.max(i,j);
        StringBuilder sb = new StringBuilder(strx);
        while(sb.length() <= maxij){
            sb.insert(0,'0');
        }
        strx = sb.toString();
//        System.out.println(strx);

        char[] chars = strx.toCharArray();
        int len = chars.length;
        char ic  = chars[len-1-i];
        chars[len-1-i] = chars[len-1-j];
        chars[len-1-j] = ic;
        strx = new String(chars);

        System.out.println(Integer.valueOf(strx,2));


    }
}
