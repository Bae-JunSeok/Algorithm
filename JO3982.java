import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO3982 {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static ArrayList<Integer> disconnect = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            addGraph(a, b);
        }

        for(int i = 0; i < n; i++){
            int count = 0;
            isVisited = new boolean[n];
            
            for(int j = 0; j < disconnect.size(); j++){
                isVisited[disconnect.get(j)] = true;
            }

            for(int j = 0; j < n; j++){
                if(!isVisited[j]) {
                    bfs(j);
                    count++;
                }
            }
            if(count > 1) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }

            int t = Integer.parseInt(br.readLine()) - 1;
            disconnect.add(t);
        }

        System.out.println(sb);
    }

    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int i = 0; i < arr[node].size(); i++){
                int next = arr[node].get(i);
                if (isVisited[next]) continue;
                q.add(next);
                isVisited[next] = true;
            }
        }
    }
}
