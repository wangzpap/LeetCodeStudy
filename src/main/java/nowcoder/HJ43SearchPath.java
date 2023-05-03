package nowcoder;


import java.util.*;


public class HJ43SearchPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = in.nextInt();
            }
        }
        Map<String, String> qianqu = new HashMap<>();

        boolean flag = false;

        Queue queue = new LinkedList<int[]>();
        queue.offer(new int[] {0, 0});

        boolean[] visited = new boolean[N * M];
        visited[0] = true;
        int step = 0;
        while (queue.size() > 0 && flag!=true) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int[] cur = (int[])queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(x==N-1&&y==M-1){
                    flag = true;
                    break;
                }

                int[][] f = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
                for (int[] f1 : f) {
                    int newx = x + f1[0];
                    int newy = y + f1[1];
                    if (newx >= 0 && newy >= 0 && newx < N && newy < M) {
                        if (map[newx][newy] == 0 && (visited[newx * M + newy] == false) ) {
                            queue.offer(new int[] {newx, newy});
                            visited[newx * M + newy] = true;
                            qianqu.put("("+newx+","+newy+")","("+x+","+y+")");
                        }
                    }
                }
            }
            step++;

        }
        printResult(qianqu,"("+(N-1)+","+(M-1)+")");
    }

    static void printResult(Map<String,String> qianqu,String s){
        if(s.equals("(0,0)")){
            System.out.println(s);
            return;
        }
        String s2 = qianqu.get(s);

        printResult(qianqu,s2);
        System.out.println(s);
    }
}
