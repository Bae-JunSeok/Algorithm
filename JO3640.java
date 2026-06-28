import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO3640 {
    static boolean[] isVisited = new boolean[100001];
    static int n, k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n));
        
    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curLocation = cur[0];
            int curTime = cur[1];
            if(curLocation == k) return curTime;

            int nextMinus = curLocation - 1;
            if(nextMinus >= 0 && !isVisited[nextMinus]) {
                
                q.add(new int[]{nextMinus, curTime + 1});
                isVisited[nextMinus] = true;
            } 

            int nextPlus = curLocation + 1;
            if(nextPlus <= 100000 && !isVisited[nextPlus]){
                
                q.add(new int[]{nextPlus, curTime + 1});
                isVisited[nextPlus] = true;
            }

            int nextJump = curLocation * 2;
            if(nextJump <= 100000 && !isVisited[nextJump]){
                
                q.add(new int[]{nextJump, curTime + 1});
                isVisited[nextJump] = true;
            }
        }

        return 0;
    }
}
