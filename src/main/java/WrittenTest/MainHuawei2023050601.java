package WrittenTest;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @program:
 * @ClassName MainHuawei2023050601
 * @description: http://101.43.147.120/p/P1249,AC
 * @author: wangzp
 * @create: 2023-05-05 19:29
 * @Version 1.0
 **/
public class MainHuawei2023050601 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String finals2 = "";
        String s2  = "";
        scanner.nextLine();
        String ss2 = scanner.nextLine();
        String[] s1 = ss2.split(" ");
        for(String sss:s1){
            sss = sss.substring(2);
            int s16 = Integer.parseInt(sss,16);
            s2 =  Integer.toString(s16,2);
            while(s2.length()<16){
                s2 = "0"+s2;
            }
            finals2 +=s2;
        }
        s2 = finals2;
        //System.out.println(s2);


        s2 = s2.substring(0,N);
        //System.out.println(s2);
        char[] s2char = s2.toCharArray();
        int num0sum = 0;
        for (char c : s2char) {
            if(c=='0')num0sum++;
        }
        //System.out.println(num0sum);
        if(num0sum==0){
            System.out.println("0");
            return;
        }

        boolean youflag = false;
        boolean zuoflag = false;
        int fangan_sum = 0;
        int youstep = 0;
        boolean[] kaikou_you = new boolean[N];
        int zuostep = 0;
        boolean[] kaikou_zuo = new boolean[N];
        for(int i = 1;  i < s2char.length;i++){
            // 右移i
            if(youflag)break;
            int test0 = 0;
            kaikou_you = new boolean[N];
            for(int j = 0;j < s2char.length && j+i< s2char.length;j++){
                if(s2char[j]=='1'&&s2char[j+i]=='0'){
                    test0++;
                    kaikou_you[j]=true;
                }
            }
            if(test0>=num0sum){
                //System.out.println(i);// 找到右 方案
                youstep = i;
                youflag = true;
                fangan_sum++;
            }
        }
        for(int i = 1;  i < s2char.length;i++){
            // zuo移i
            if(zuoflag)break;
            int test0 = 0;
            kaikou_zuo = new boolean[N];
            for(int j = s2char.length-1;j>=0&&j-i>=0;j--){
                if(s2char[j]=='1'&&s2char[j-i]=='0'){
                    test0++;
                    kaikou_zuo[j]=true;
                }
            }
            if(test0>=num0sum){
                //System.out.println(i);// 找到右 方案
                zuostep = i;
                zuoflag = true;
                fangan_sum++;
            }
        }
        if(zuoflag==false&&youflag==false){
            System.out.println("0");
            return;
        }
        if(fangan_sum==0){
            System.out.println("0");
            return;
        }
        System.out.println(fangan_sum);
        if(youflag){
            System.out.println("+"+youstep);
            for(int y = 0;y < N;y++){
                if(kaikou_you[y]==true) System.out.print("1");
                else {
                    System.out.print("0");
                }
            }
        }
        System.out.println();
        if(zuoflag){
            System.out.println("-"+zuostep);
            for(int y = 0;y < N;y++){
                if(kaikou_zuo[y]==true) System.out.print("1");
                else {
                    System.out.print("0");
                }
            }
        }

        System.out.println();




    }


}
