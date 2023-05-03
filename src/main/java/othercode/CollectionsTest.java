package othercode;

import java.sql.SQLOutput;
import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.removeLast();
        linkedList.removeFirst();
        linkedList.size();
        linkedList.add(1);
        linkedList.peek();
        linkedList.offer(1);
        linkedList.getLast();
        linkedList.getFirst();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(1);
        queue.size();

        //Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty.
        queue.remove();
        // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        queue.poll();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.size();
        stack.empty();
        stack.peek(); // 查看栈顶元素
        stack.pop();// 移除栈顶元素

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "helo");
        map.containsKey(1);
        map.isEmpty();
        map.remove(1);
        map.size();
        Set<Integer> se = map.keySet();
        map.keySet().forEach(key -> map.remove(key));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.remove(1);
        set.contains(1);
        set.isEmpty();
        set.size();
        set.clear();


        int[] n = new int[]{1,2,34};
        List list = Arrays.asList();
        System.out.println(list.toString());


//        int[][] aa = new int[][];
//        Arrays.sort(aa, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                return a[1] - b[1];
//            }
//        });

        int[] nums = new int[]{1,2,34};
        System.out.println(Arrays.stream(nums).sum());



        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.size();
        pq.poll();
        pq.peek();






    }
}
