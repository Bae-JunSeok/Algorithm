import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO12094 { // bfs로 풀면???
    //static int result, count;
    static int[] arr;
    static boolean[] isVisited;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        isVisited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(0));


    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(start);
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            if(arr[node] == 0) return count;
            int next = node + arr[node];
            if(next < 0 || next >= n) return -1;
            if(isVisited[next]) return -1;
            q.add(next);
            isVisited[next] = true;
            count++;
        }

        return -1;
    }
}
