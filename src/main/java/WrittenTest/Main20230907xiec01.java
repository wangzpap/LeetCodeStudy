package WrittenTest;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: LeetCodeStudy
 * @ClassName Main20230907xiec01
 * @description:
 * @author: wangzp
 * @create: 2023-09-07 19:03
 * @Version 1.0
 **/
public class Main20230907xiec01 {
    static int N;
    static int finalre;
    public static void main(String[] args) {
        Scanner sccc = new Scanner(System.in);
        N = sccc.nextInt();
        finalre = 0;
        int[] arr = new int[N];
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        backtrack(arr,visit,new LinkedList<Integer>());
        System.out.println(finalre);

    }

    static void backtrack(int[] arr,boolean[] visited, LinkedList<Integer> list){
        if(list.size()==N){
            finalre++;
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            int cur = arr[j];
            if(visited[j])continue;
            if(!list.isEmpty() && !isSu(list.getLast()+cur)){
                list.add(cur);
                visited[j] = true;
                backtrack(arr,visited,list);
                visited[j] = false;
                list.removeLast();
            }else if(list.isEmpty()){
                list.add(cur);
                visited[j] = true;
                backtrack(arr,visited,list);
                visited[j] = false;
                list.removeLast();
            }
        }
    }

    public static boolean isSu(int n){
        int i;
        for ( i = 2; i <= n/2; i++) {
            if(n%i==0){
                return false;
            }
        }
        if(i>n/2)return true;
        else return false;
    }

    public void method(){

    }

}
