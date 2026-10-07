import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PG49191 {
    static ArrayList<Integer>[] win;
    static ArrayList<Integer>[] lose;
    static int[] result;
    static boolean[] winIsVisited;
    static boolean[] loseIsVisited;
    public static void main(String[] args) {
        PG49191 sol = new PG49191();

        System.out.println(sol.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public int solution(int n, int[][] results){
        int answer = 0;
        win = new ArrayList[n + 1];
        lose = new ArrayList[n + 1];
        result = new int[n + 1];
        

        for(int i = 0; i <= n; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }

        for(int i = 0; i < results.length; i++){
            int x = results[i][0];
            int y = results[i][1];
            addGraph(x, y);
        }
        
        for(int i = 0; i <= n; i++){
            bfsLose(i, n);
            bfsWin(i, n);
        }

        for(int i = 1; i <= n; i++){
            if(result[i] == n - 1){
                answer++;
            }
        }

        return answer;
    }

    static void addGraph(int x, int y){
        win[x].add(y);
        lose[y].add(x);
    }

    static void bfsWin(int start, int n){
        Queue<Integer> q = new LinkedList<>();
        winIsVisited = new boolean[n + 1];
        winIsVisited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int i = 0; i < win[node].size(); i++){
                int next = win[node].get(i);
                if(winIsVisited[next]) continue;
                winIsVisited[next] = true;
                q.add(next);

                result[start]++;
            }
        }
    }
    
    static void bfsLose(int start, int n){
        Queue<Integer> q = new LinkedList<>();
        loseIsVisited = new boolean[n + 1];
        loseIsVisited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int i = 0; i < lose[node].size(); i++){
                int next = lose[node].get(i);
                if(loseIsVisited[next]) continue;
                loseIsVisited[next] = true;
                q.add(next);

                result[start]++;
            }
        }
    }
}
