import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1818 {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        isVisited = new boolean[n];

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(0);
        System.out.println(result);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int curComputer = q.poll();
            for(int i = 0; i < arr[curComputer].size(); i++){
                int next = arr[curComputer].get(i);
                if(isVisited[next]) continue;
                q.add(next);
                isVisited[next] = true;
                result++;
            }
        }
    }
}
