import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1906 {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static int start, end;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }
        isVisited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            addGraph(x, y);
        }
        System.out.println(bfs(start));
    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curConnection = node[1];
            if(curX == end) return curConnection;
            for(int i = 0; i < arr[curX].size(); i++){
                int nx = arr[curX].get(i);
                if(isVisited[nx]) continue;
                q.add(new int[]{nx, curConnection + 1});
                isVisited[nx] = true;
            }
        }

        return -1;
    }

    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }
}
