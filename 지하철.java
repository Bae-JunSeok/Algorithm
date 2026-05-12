import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 지하철 {
    static ArrayList<int[]>[] arr;
    static int n, m;
    static int[] dist;
    static int[][] map;
    static ArrayList<Integer> sequence;
    static int[] prev;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                arr[i].add(new int[]{j, map[i][j]});
            }
        }
        Dijkstra(0);
        System.out.println(dist[m - 1]);
        
        ArrayList<Integer> path = getPath(m - 1);
        for(int i = 0; i < path.size(); i++){
            System.out.print((path.get(i) + 1));

            if(i < path.size() - 1){
                System.out.print(" ");
            }
        }
    }

    static void Dijkstra(int start){
        dist = new int[n];
        prev = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        pq.add(new int[]{start, dist[start]});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int cur_x = node[0];
            int cur_dist = node[1];
            for(int i = 0; i < arr[cur_x].size(); i++){
                int[] next = arr[cur_x].get(i);
                int next_x = next[0];
                int next_dist = next[1];
                if(dist[next_x] > cur_dist + next_dist){
                    dist[next_x] = cur_dist + next_dist;
                    prev[next_x] = cur_x;
                    pq.add(new int[]{next_x, dist[next_x]});
                }
            }
        }
    }

    static ArrayList<Integer> getPath(int end){
        ArrayList<Integer> path = new ArrayList<>();

        int cur = end;

        while(cur != -1){
            path.add(cur);
            cur = prev[cur];
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = path.size() - 1; i > -1; i--){
            result.add(path.get(i));
        }

        return result;
    }
    
}
