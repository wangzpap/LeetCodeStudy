package nowcoder;

import java.sql.SQLOutput;
import java.util.*;



public class HJ43SearchPathDFS {

    static int N;
    static int M;
    static LinkedList<String> best_path;
    static LinkedList<String> path;
    static int best_steps;
    static int steps;
    static boolean[] visited;



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {       for (int j = 0; j < M; j++) {
                map[i][j] = in.nextInt();
            }
        }
        visited = new boolean[N * M];


        path = new LinkedList<String>();
        best_steps = Integer.MAX_VALUE;

        traverse(map,0,0);

        for(int i = 0;i < best_path.size();i++){
            System.out.println(best_path.get(i));
        }


    }

    static void traverse(int[][] map, int x,int y){



        if (x < 0 || y < 0 || x >= N || y >= M) {
            return;
        }



        if( map[x][y] == 1 )return;

        if(visited[x*M+y])return;

        visited[x*M+y] = true;
        path.offer("("+x+","+y+")");
        steps++;


        if(x==N-1&&y==M-1){
            if(steps<best_steps){
                best_path = new LinkedList<String>(path);
                best_steps = steps;
            }
            path.removeLast();
            steps--;
            visited[x*M+y] = false;
            return;
        }

        int[][] f = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] f1 : f) {
            int newx = x + f1[0];
            int newy = y + f1[1];
            traverse(map,newx,newy);
        }
        path.removeLast();
        steps--;
        visited[x*M+y] = false;
    }

}
