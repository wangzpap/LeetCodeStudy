package WrittenTest;

import java.util.*;

/**
 * 已AC
 */
public class MainHuawei2023051703 {

    static int m,n;

    static int initx,inity;
    
    static int[][] h;
    static int[][] o;

    static Set<String> successset = new HashSet<>();
    static Set<String> visitedandv = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        String s1 = scanner.nextLine();
        String[] split2 = s1.split(",");
        initx = Integer.parseInt(split2[0]);
        inity = Integer.parseInt(split2[1]);

        h = new int[m][n];
        o = new int[m][n];
        for (int i = 0; i < m; i++) {
            String next = scanner.next();
            String[] split1 = next.split(",");
            for (int j = 0; j < n; j++) {
                h[i][j] = Integer.parseInt(split1[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            String next = scanner.next();
            String[] split1 = next.split(",");
            for (int j = 0; j < n; j++) {
                o[i][j] = Integer.parseInt(split1[j]);
            }
        }
        DFS(initx,inity,1);
        System.out.println(successset.size());
    }
    static void DFS(int x,int y,int v){
        if(v <= 0)return;
        if(successset.size()>=m*n-1)return;
        if(v == 1){
            if(x != initx || y != inity){
                successset.add(""+x+"-"+y);
            }
        }
        if(visitedandv.contains(""+x+"-"+y+"-"+v)){
            return;
        }
        visitedandv.add(""+x+"-"+y+"-"+v);
        int h1 = h[x][y];
        int[][] f = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] ints : f) {
            int newx = x + ints[0];
            int newy = y + ints[1];
            if(newx>=0&&newx<m&&newy>=0&&newy<n){
                int h2 = h[newx][newy];
                int o2 = o[newx][newy];
                int newv = v + h1 - h2 - o2;

                if(newx==initx && newy==inity && newv==1)continue;

                DFS(newx,newy,newv);
            }
        }
    }
}
