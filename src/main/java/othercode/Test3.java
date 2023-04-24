package othercode;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {



        Map<int[], int[]> qianqu = new HashMap<>();
        qianqu.put(new int[]{1,2},new int[]{3,4});
        System.out.println(qianqu.get(new int[]{1, 2}));
    }
}
