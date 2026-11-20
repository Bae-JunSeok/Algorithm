import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO26096 {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static int start, end;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            addGraph(x, y);
        }

        System.out.println(bfs(start));
    }

    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        isVisited = new boolean[n];
        isVisited[start] = true;
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curT = node[1];
            if(curX == end) return curT;
            for(int i = 0; i < arr[curX].size(); i++){
                int next = arr[curX].get(i);
                if(isVisited[next]) continue;
                q.add(new int[]{next, curT + 1});
                isVisited[next] = true;
            }
        }

        return -1;
    }
}
