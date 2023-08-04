import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class MainXiecheng2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int X =arr[0];
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if(arr[i]==X)continue;
            int a = arr[i];
            int n = 0;

            if(map.containsKey(a)){
                n = map.get(a);
                result += n;
                continue;
            }

            while (a>X){
                a = (int)Math.floor(a*1.0/2);
                n++;
            }
            if(a==X){
                map.put(arr[i],n);
                result+=n;
            }else{
                System.out.println(0);
                return;
            }
        }
        System.out.println(result);
    }
}
