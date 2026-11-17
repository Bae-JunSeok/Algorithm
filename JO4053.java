import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO4053 {
    static int n, m;
    static ArrayList<int[]>[] arr;
    static boolean[] isVisited;
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            addGraph(x, y, z);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()) - 1;
            sb.append(bfs(v, k)).append("\n");
            
        }

        System.out.println(sb);
    }

    static void addGraph(int x, int y, int z){
        arr[x].add(new int[]{y, z});
        arr[y].add(new int[]{x, z});
    }


    static int bfs(int start, int k){
        Queue<Integer> q = new LinkedList<>();
        isVisited = new boolean[n];
        q.add(start);
        isVisited[start] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < arr[cur].size(); i++){
                int[] next = arr[cur].get(i);
                int nextX = next[0];
                int nextDist = next[1];
                if(isVisited[nextX]) continue;
                if(nextDist < k) continue;

                isVisited[nextX] = true;
                q.add(nextX);
                count++;
            }
        }

        return count;
    }
}
