package othercode;


import java.util.HashSet;
import java.util.LinkedList;

import java.util.Scanner;
import java.util.Set;

public class Main2 {

    static int min_list_size = Integer.MAX_VALUE; // 最优路径的长度
    static int[][] graph;  // 把树表示成邻接矩阵
    static Set<Integer> blockset; // 存储障碍物
    static LinkedList<Integer> result; // 最终路径结果
    static boolean isNull = true;
    static int nodeNum = 0;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        nodeNum = scanner.nextInt(); // 几个点
        graph = new int[nodeNum][nodeNum]; // 7个节点
        int xx = nodeNum = scanner.nextInt(); // 几行
        for(int x = 0;x<xx;x++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        xx = nodeNum = scanner.nextInt(); // 几行
        blockset = new HashSet<>();// 阻碍物set

        for(int x = 0;x<xx;x++){
            int blocknode = scanner.nextInt();
            blockset.add(blocknode);
        }

        DFS(new LinkedList<>(), 0);

        if(isNull){
            System.out.println("NULL");
        }else {
            for(int i = 0; i < result.size(); i++){
                System.out.print(result.get(i));
                if(i<result.size()-1 && result.size()>=2){
                    System.out.print("->");
                }
            }
        }

    }

    // dfs递归函数
    public static void DFS(LinkedList<Integer> list,int node){




        list.add(node);

        if(list.size()>min_list_size)return;


        if(isLeafNode(node)){
            isNull = false;
            if(list.size()<min_list_size){
                result = new LinkedList<>(list);
                min_list_size = list.size();
            }
        }

        for(int i = 0;i<graph.length;i++){
            if(graph[node][i]==1 && !blockset.contains(i)){
                DFS(list,i);
            }
        }
        list.removeLast();
    }
    // 判断是否叶子
    static boolean isLeafNode(int node){
        for(int i =0;i<graph.length;i++){
            if(graph[node][i]==1){
                return false;
            }
        }
        return true;
    }
}
