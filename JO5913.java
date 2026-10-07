import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO5913 {
    static ArrayList<Integer>[] arr;
    static int n, m;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            addGraph(a, b);
        }

        bfs(1);
        System.out.println(result);
    }

    static void bfs(int start){
        boolean[] isVisited = new boolean[n + 1];
        isVisited[start] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curRelation = node[1];
            if(curRelation == 1 || curRelation == 2) result++;
            for(int i = 0; i < arr[curX].size(); i++){
                int next = arr[curX].get(i);
                if(isVisited[next]) continue;
                isVisited[next] = true;
                q.add(new int[]{next, curRelation + 1});
            }
        }
    }



    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }
}
