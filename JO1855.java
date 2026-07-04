import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JO1855 {
    static int n, p, c;
    static ArrayList<int[]>[] arr;
    static int[][] dist;
    static int[] peopleLocation;
    static int Max = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new ArrayList[p];
        for(int i = 0; i < p; i++){
            arr[i] = new ArrayList<>();
        }

        dist = new int[n][p];
        peopleLocation = new int[n];

        for(int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            addGraph(x, y, z);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            peopleLocation[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        for(int i = 0; i < n; i++){
            Dijkstra(peopleLocation[i], i);
        }

        int min = 1000000000;

        for(int i = 0; i < p; i++){
            int sum = 0;
            boolean possible = true;

            for(int j = 0; j < n; j++){
                if(dist[j][i] == Max){
                    possible = false;
                    break;
                }
                sum += dist[j][i];
            }

            if(possible && sum < min){
                min = sum;
            }
        }

        System.out.println(min);
    }

    static void addGraph(int x, int y, int z){  // 그래프에 값 넣기
        arr[x].add(new int[]{y, z});
        arr[y].add(new int[]{x, z});
    }

    static void Dijkstra(int start, int people){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });

        Arrays.fill(dist[people], Max);
        dist[people][start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int curLocation = node[0];
            int curDist = node[1];

            if (curDist > dist[people][curLocation]) continue;

            for(int i = 0; i < arr[curLocation].size(); i++){
                int[] next = arr[curLocation].get(i);
                int nextLocation = next[0];
                int nextDist = next[1];
                if(dist[people][nextLocation] > curDist + nextDist){
                    dist[people][nextLocation] = curDist + nextDist;
                    pq.add(new int[]{nextLocation, dist[people][nextLocation]});
                }
            }
        }
    }
}
