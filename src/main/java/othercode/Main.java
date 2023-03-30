package othercode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        int R,C;
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt(); // 几行
        C = scanner.nextInt(); // 几列
        int[][] rooms = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rooms[i][j] = scanner.nextInt();
            }
        }

        solution.solve(R,C,rooms);
    }

    class Solution{
        int R,C;
        int maxRoomArea = 0;
        int colorNum = 0;
        int roomArea = 0; // 用于临时记录个房间的大小
        int[][] colors,rooms; // rooms 原始房间地图  colors用于记录颜色（）


        public void solve(int R,int C,int[][] rooms){
            this.R = R;
            this.C = C;
            this.maxRoomArea = 0; // 最大房间的大小
            this.colorNum = 0; // 颜色序号，0为未上色（没有搜过），
            this.roomArea = 0;
            this.colors = new int[R][C]; // 默认初始化所有点为0
            this.rooms = rooms;

            for(int i = 0;i < R;i++){
                for(int j = 0;j < C;j++){
                    if(colors[i][j]==0){ // 找到一个新节点
                        colorNum++; //
                        roomArea = 0;
                        DFS(i,j);
                        maxRoomArea = Math.max(maxRoomArea,roomArea);

                    }
                }
            }

            System.out.println(colorNum);
            System.out.println(maxRoomArea);


        }

        public void DFS(int i,int j) {
            if(colors[i][j] != 0)return; // 旧点，返回
            colors[i][j] = colorNum; // 上色
            roomArea++;
            if(((rooms[i][j]) & 1) ==0) DFS(i,j-1); // 向左找
            if(((rooms[i][j]) & 2) ==0) DFS(i -1 ,j); // 向上找
            if(((rooms[i][j]) & 4) ==0) DFS(i,j+1);
            if(((rooms[i][j]) & 8) ==0) DFS(i + 1,j);
        }
    }
}
