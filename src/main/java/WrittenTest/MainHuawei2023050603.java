package WrittenTest;

import java.util.*;

/**
 * @program: LeetCodeStudy
 * @ClassName Main05053
 * @description: http://101.43.147.120/p/P1251，AC
 * @author: wangzp
 * @create: 2023-05-06 14:44
 * @Version 1.0x
 **/
public class MainHuawei2023050603 {

    static int N;
    static int K;

    static Set<String> guaiwuset = new HashSet<>(); // 用于存储地图中的静态障碍

    static int row1,col1; // 公主（宝藏）
    static int row2,col2; // 王子（冒险家）

    static Queue<int[]> queue; //BFS的队列中存储每个点及到达该点的时间，每个点为（x，y，t）

    static int[][][] graph;// 三维的链接矩阵矩阵存储动态地图

    public static void main(String[] args) {
        // 1.处理输入
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        graph = new int[3][N][N]; // 0 1 2 共三个时间点的地图
        for (int i = 0; i < K; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            guaiwuset.add(""+x+"-"+y);
        }
        row1 = scanner.nextInt();
        col1 = scanner.nextInt();
        row2 = scanner.nextInt();
        col2 = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String str = scanner.next();
                graph[0][i][j] = Integer.valueOf(Character.toString(str.charAt(0)));
                graph[1][i][j] = Integer.valueOf(Character.toString(str.charAt(1)));
                graph[2][i][j] = Integer.valueOf(Character.toString(str.charAt(2)));
            }
        }
        // 2.解答开始
        queue = new LinkedList<>(); // BFS的队列
        boolean[][][] visitedSum = new boolean[N][N][3]; // 记录某个时间点的某个位置是否`走过`

        queue.add(new int[]{row2,col2,0});  // 将初始节点放入队列
        visitedSum[row2][col2][0] = true;   // 将初始节点的0时刻标记为`走过`

        int time = 0;// 记录时间
        while (!queue.isEmpty()){
            int q_size = queue.size();

            for (int i = 0; i < q_size; i++) {
                int[] cur = queue.poll();
                int curx = cur[0];
                int cury = cur[1];
                int curtime = cur[2];
                //System.out.println("x="+curx+" y="+cury+" curtime="+curtime);

                if(curx == row1 && cury == col1){ // 找到最终目标，直接返回答案
                    System.out.println(curtime);
                    return;
                }
                int[][] fangxiang = new int[][]{{0,-1},{0,1},{-1,0},{1,0},{0,0}}; // 上下左右及原地不动5种选择
                for(int[] f:fangxiang){
                    int newx = curx + f[0];
                    int newy = cury + f[1];
                    int newtime = curtime+1;
                    // 判断越界
                    if(newx<0||newx>=N||newy>=N||newy<0)continue;
                    // 判断静态障碍
                    if(guaiwuset.contains(""+newx+"-"+newy)){ // 有怪兽（陷阱）
                        continue;
                    }
                    // 判断动态障碍
                    if(graph[newtime%3][newx][newy]==1){ // 下个节点有障碍
                        continue;
                    }
                    // 判断是否走过
                    if(visitedSum[newx][newy][newtime%3] == true){
                        continue;
                    }
                    queue.offer(new int[]{newx,newy,newtime});
                    visitedSum[newx][newy][newtime%3] = true;
                }
            }
        }
        System.out.println("-1");
    }
}
