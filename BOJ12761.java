import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761 {
    static int a, b;
    static int n, m;
    static boolean[] isVisited;
    static int[] dir = new int[6];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dir[0] = -a;
        dir[1] = a;
        dir[2] = -b;
        dir[3] = b;
        dir[4] = -1;
        dir[5] = 1;
        isVisited = new boolean[100001];

        System.out.println(bfs(n));
    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curT = node[1];
            if(curX == m) return curT;
            for(int d = 0; d < 6; d++){
                int nx = curX + dir[d];
                if(nx < 0 || nx > 100000) continue;
                if(isVisited[nx]) continue;
                q.add(new int[]{nx, curT + 1});
                isVisited[nx] = true;
            }

            int nx1 = curX * a;
            if(nx1 > 100000 || isVisited[nx1]){

            } else {
                q.add(new int[]{nx1, curT + 1});
                isVisited[nx1] = true;
            }


            int nx2 = curX * b;
            if(nx2 > 100000 || isVisited[nx2]){

            } else {
                q.add(new int[]{nx2, curT + 1});
                isVisited[nx2] = true;
            }
        }



        return -1;
    }
}
