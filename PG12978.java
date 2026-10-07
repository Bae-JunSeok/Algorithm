import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG12978 {
    static ArrayList<int[]>[] arr;
    static int[] dist;
    public static void main(String[] args) {
        PG12978 sol = new PG12978();
        System.out.println(sol.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
    }

    public int solution(int N, int[][] road, int K){
        int answer = 0;
        arr = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            int z = road[i][2];
            addGraph(x, y, z);
        }

        dist = new int[N + 1];
        Dijkstra(1);

        // for(int i = 1; i <= N; i++){
        //     System.out.println(dist[i]);
        // }

        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }

    static void addGraph(int x, int y, int z){
        arr[x].add(new int[]{y, z});
        arr[y].add(new int[]{x, z});
    }

    static void Dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override 
            public int compare(int[] a, int[] b){
                return Integer.compare(a[1], b[1]);
            }
        });

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, dist[start]});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int curX = node[0];
            int curDist = node[1];
            if(curDist > dist[curX]) continue;
            for(int i = 0; i < arr[curX].size(); i++){
                int[] next = arr[curX].get(i);
                int nextX = next[0];
                int nextDist = next[1];
                if(dist[nextX] > curDist + nextDist){
                    dist[nextX] = curDist + nextDist;
                    pq.add(new int[]{nextX, dist[nextX]});
                }
            }
        }

    }
}
