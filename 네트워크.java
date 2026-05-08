import java.util.*;

class 네트워크 {
    static boolean[] isVisited;
    static ArrayList<Integer>[] arr;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        arr = new ArrayList[n];
        isVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1) arr[i].add(j);
            }
        }
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int i = 0; i < arr[node].size(); i++){
                int next = arr[node].get(i);
                if(isVisited[next]) continue;
                q.add(next);
                isVisited[next] = true;
            }
        }
        
    }
}