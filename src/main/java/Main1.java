import java.util.HashMap;

/**
 * @program: LeetCodeStudy
 * @ClassName Main1
 * @description:
 * @author: wangzp
 * @create: 2023-07-28 16:55
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,5};
        int target = 4;

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int len = a.length;
        boolean flag = false;

        for (int i = 0; i < len; i++) {
            int x = a[i];

            if(x > target)break;

            if(!map1.containsKey(x)){
                map1.put(x,i);
                map2.put(x,i);
            }else {
                map2.put(x,i);
                if(x == target){
                    flag = true;
                }
            }
        }
        if(map1.containsKey(target)){
            System.out.println(map1.get(target));
            System.out.println(map2.get(target));
        }else {
            System.out.println("-1");
            System.out.println("-1");
        }
    }
}
