package othercode;

import java.util.*;

public class HWziyuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<int[]> list = new LinkedList<int[]>(); // 存储每个节点
        Map<String, Integer> map = new HashMap<String, Integer>();// 存储某个点长出的种类

        int N = scanner.nextInt();
        int num = scanner.nextInt();

        // 处理特殊情况
        if(N>num){
            System.out.println(0);
            return;
        }
        // 输入
        for (int i = 0; i < num; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new int[]{x, y});
            map.put(""+x+"-"+y,1);
        }
        int day = 1;
        while (true){
            // 处理每一个草
            for(int[] dot:list){
                int x = dot[0];
                int y = dot[1];

                int x1 = x-day;
                int x2 = x+day;
                int y1 = y-day;
                int y2 = y+day;

                Map<String,Boolean> isE = new HashMap<String,Boolean>();
                for(int p = x1; p <= x2;p++){
                    if(!isE.containsKey(""+p+"-"+y1))
                    if(map.containsKey(""+p+"-"+y1)){
                        int a = map.get(""+p+"-"+y1)+1;
                        if(a>=N){
                            System.out.println(day);
                            return;
                        }
                        map.put(""+p+"-"+y1,a);
                        isE.put(""+p+"-"+y1,true);
                    }else {
                        map.put(""+p+"-"+y1,1);
                        isE.put(""+p+"-"+y1,true);
                    }
                    if(!isE.containsKey(""+p+"-"+y2))
                    if(map.containsKey(""+p+"-"+y2)){
                        int a = map.get(""+p+"-"+y2)+1;
                        if(a>=N){
                            System.out.println(day);
                            return;
                        }
                        map.put(""+p+"-"+y2,a);
                        isE.put(""+p+"-"+y2,true);

                    }else {
                        map.put(""+p+"-"+y2,1);
                        isE.put(""+p+"-"+y2,true);
                    }
                }

                for(int z = y1; z <= y2;z++){
                    if(!isE.containsKey(""+x1+"-"+z))
                    if(map.containsKey(""+x1+"-"+z)){
                        int a = map.get(""+x1+"-"+z)+1;
                        if(a>=N){
                            System.out.println(day);
                            return;
                        }
                        map.put(""+x1+"-"+z,a);
                        isE.put(""+x1+"-"+z,true);
                    }else {
                        map.put(""+x1+"-"+z,1);
                        isE.put(""+x1+"-"+z,true);
                    }
                    if(!isE.containsKey(""+x2+"-"+z))
                    if(map.containsKey(""+x2+"-"+z)){
                        int a = map.get(""+x2+"-"+z)+1;
                        if(a>=N){
                            System.out.println(day);
                            return;
                        }
                        map.put(""+x2+"-"+z,a);
                        isE.put(""+x2+"-"+z,true);
                    }else {
                        map.put(""+x2+"-"+z,1);
                        isE.put(""+x2+"-"+z,true);
                    }
                }
            }
            day++;
        }
    }
}
