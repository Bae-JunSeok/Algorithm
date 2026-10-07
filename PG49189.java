import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PG49189 {
    static ArrayList<Integer>[] arr;
    static int[] dist;
    static boolean[] isVisited;
    public static void main(String[] args) {
        PG49189 sol = new PG49189();

        System.out.println(sol.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public int solution(int n, int[][] edge){
        int answer = 0;
        arr = new ArrayList[n + 1];
        dist = new int[n + 1];
        isVisited = new boolean[n + 1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge.length; i++){
            addGraph(edge[i][0], edge[i][1]);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        isVisited[1] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curDist = node[1];
            dist[curX] = curDist;
            for(int i = 0; i < arr[curX].size(); i++){
                int next = arr[curX].get(i);
                if(isVisited[next]) continue;
                q.add(new int[]{next, curDist + 1});
                isVisited[next] = true;
            }
        }

        int Max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            if(dist[i] > Max){
                Max = dist[i];
            }
        }

        for(int i = 1; i <= n; i++){
            if(dist[i] == Max){
                answer++;
            }
        }

        return answer;
    }

    public void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }
}
