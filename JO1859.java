import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1859 {
    static int n;
    static int[][] map;
    static boolean[] isVisited;
    static ArrayList<Integer>[] arr;
    static int count;
    static ArrayList<Integer> midResult;
    static ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        isVisited = new boolean[n];
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    addGraph(i, j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                count++;
                midResult = new ArrayList<>();
                bfs(i);
                Collections.sort(midResult);
                finalResult.add(midResult);
            }
        }

        
        for(int i = 0; i < finalResult.size(); i++){
            ArrayList<Integer> a = finalResult.get(i);

            if(a.size() < 2){
                System.out.println(0);
                return;
            }

            for(int j = 0; j < a.size(); j++){
                for(int k = j + 1; k < a.size(); k++){
                    int b = a.get(j);
                    int c = a.get(k);

                    if(map[b][c] == 1 || map[c][b] == 1){
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(count);
        for(int i = 0; i < finalResult.size(); i++){
            ArrayList<Integer> a = finalResult.get(i);
            for(int j = 0; j < a.size(); j++){
                System.out.print((a.get(j) + 1) + " ");
            }
            System.out.println();
        }

        
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        midResult.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int i = 0; i < arr[node].size(); i++){
                int next = arr[node].get(i);
                if(isVisited[next]) continue;
                q.add(next);
                isVisited[next] = true;
                midResult.add(next);
            }
        }
    }


    static void addGraph(int x, int y){
        arr[x].add(y);
    }
}
