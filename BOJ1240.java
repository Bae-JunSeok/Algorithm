import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1240 {
    static int n, m;
    static ArrayList<int[]>[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            addGraph(x, y, z);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            isVisited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(bfs(s, e)).append("\n");
        }

        System.out.println(sb);
    }

    static void addGraph(int x, int y, int z){
        arr[x].add(new int[]{y, z});
        arr[y].add(new int[]{x, z});
    }

    static int bfs(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curD = node[1];
            if(curX == end) return curD;
            for(int i = 0; i < arr[curX].size(); i++){
                int[] nextNode = arr[curX].get(i);
                int nextX = nextNode[0];
                int nextD = nextNode[1];
                if(isVisited[nextX]) continue;
                isVisited[nextX] = true;
                q.add(new int[]{nextX, curD + nextD});
            }
        }




        return -1;
    }
}
