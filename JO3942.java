import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO3942 {
    static int t, a, b;
    static int[] map;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[t + 1];
        isVisited = new boolean[t + 1];

        bfs(0);

        int result = 0;

        for(int i = 1; i <= t; i++){
            System.out.println(isVisited[i]);
            if(isVisited[i]){
                result = i;
            }
        }

        System.out.println(result);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            int next1 = node + a;
            if(next1 <= t && !isVisited[next1]){
                q.add(next1);
                isVisited[next1] = true;
            }
            

            int next2 = node + b;
            if(next2 <= t && !isVisited[next2]){
                q.add(next2);
                isVisited[next2] = true;
            }

            int next3 = node / 2;
            if(next3 > 1 && !isVisited[next3]){
                q.add(next3);
                isVisited[next3] = true;
            }
        }
    }
}
