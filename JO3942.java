import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO3942 {
    static int t, a, b;
    static int[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[2][t + 1];

        bfs(0);

        for(int i = t; i >= 1; i--){
            if(map[0][i] > 0 || map[1][i] > 0){
                System.out.println(i);
                break;
            }
        }

    }

    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        map[0][start] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int curX = node[0];
            int water = node[1];

            int next1 = curX + a;
            if(next1 <= t && map[water][next1] == 0){
                q.add(new int[]{next1, water});
                map[water][next1] = 1;
            }

            int next2 = curX + b;
            if(next2 <= t && map[water][next2] == 0){
                q.add(new int[]{next2, water});
                map[water][next2] = 1;
            }

            if(water == 0){
                int next3 = curX / 2;
                q.add(new int[]{next3, 1});
                map[1][next3] = 1;
            }

            // int next1 = node + a;
            // if(next1 <= t && !isVisited[next1]){
            //     q.add(next1);
            //     isVisited[next1] = true;
            // }
            

            // int next2 = node + b;
            // if(next2 <= t && !isVisited[next2]){
            //     q.add(next2);
            //     isVisited[next2] = true;
            // }

            // int next3 = node / 2;
            // if(next3 > 1 && !isVisited[next3]){
            //     q.add(next3);
            //     isVisited[next3] = true;
            // }
        }
    }
}
