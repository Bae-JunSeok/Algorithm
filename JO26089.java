import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO26089 {
    static ArrayList<Integer>[] arr;
    static int n, m;
    static int[] dist;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];

        arr = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            addGraph(x, y);
        }

        for(int i = 1; i <= n; i++){
            bfs(i);
        }

        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++){
            if(dist[i] < min){
                min = dist[i];
            }
        }

        for(int i = 1; i <= n; i++){
            if(dist[i] == min){
                System.out.println(i);
                break;
            }
        }

    }

    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }

    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        isVisited = new boolean[n + 1];
        isVisited[start] = true;
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curRelation = node[1];
            dist[start] += curRelation;
            for(int i = 0; i < arr[curX].size(); i++){
                int next = arr[curX].get(i);
                if(isVisited[next]) continue;
                q.add(new int[]{next, curRelation + 1});
                isVisited[next] = true;
            }
        }
    }
}
