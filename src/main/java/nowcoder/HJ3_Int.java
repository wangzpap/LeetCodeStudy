package nowcoder;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HJ3_Int {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>((a,b)->{
            return a-b;
        });
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        if(!set.isEmpty())
        for(Integer i : set){
            System.out.println(i);
        }

    }
}
