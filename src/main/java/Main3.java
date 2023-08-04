import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N  = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            if(arr[i]>=K&&arr[i]%K==0){
                result++;
            }else {
                list.add(arr[i]);
            }

        }

        if(K==1){
            System.out.println(N);
            return;
        }

        int s = list.size();
        boolean[] isU = new boolean[s];
        int isTrue_sum = 0;
        for (int i = 0; i < s-1; i++) {
            if(isU[i])continue;
            for (int j = i+1; j < s; j++) {
                if(isU[j])continue;

                int sum = list.get(i)+list.get(j);
                if(sum<K)continue;
                if(sum%K==0){
                    isU[i] = true;
                    isU[j] = true;
                    result++;
                    isTrue_sum +=2;
                }
            }
        }
        if(isTrue_sum==s){
            System.out.println(result);
        }else {
            System.out.println(0);
        }




    }
}
