import com.sun.net.httpserver.Authenticator;

import java.util.LinkedList;
import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        //int[][] map = new int[2][N];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for (int i1 = 0; i1 < k; i1++) {
                list1.add(n);
            }
        }
        //for (int i = 0; i < list.size(); i++) {
        //    map[0][i] = list.get(i);
        //}
        for (int i = 0; i < n2; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for (int i1 = 0; i1 < k; i1++) {
                list2.add(n);
            }
        }
        //for (int i = 0; i < list.size(); i++) {
        //    map[1][i] = list.get(i);
        //}
        int result = 0;
        Set<String> fal = new HashSet<>();
        Set<String> suc = new HashSet<>();
        for (int i = 0; i < N - 1; i++) {
            Set<Integer> s =  new HashSet<>();

            int a = list1.get(i);
            int b = list1.get(i+1);
            int c = list2.get(i);
            int d = list2.get(i+1);
            if(fal.contains(""+a+b+c+d))continue;
            if(a==b&&c==d&&b==c)continue;
            if(a==b&&b==c&&c!=d){
                result++;continue;
            }
            if(suc.contains(""+a+b+c+d)){
                result++;continue;
            }
            s.add(a);
            s.add(b);
            s.add(c);
            s.add(d);
            if(s.size()==2){
                result++;
                suc.add(""+a+b+c+d);
            }
            else{
                fal.add(""+a+b+c+d);
            }
        }
        System.out.println(result);

    }

}
