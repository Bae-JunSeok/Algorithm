import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1317 {
    static int n, m;
    static ArrayList<Integer>[] arr; //o
    static boolean[] isVisited; // o
    static int count;
    static ArrayList<ArrayList<Integer>> middleResult = new ArrayList<>();
    static ArrayList<Integer> finalResult = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            addGraph(x, y);
        }

        isVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            if (!isVisited[i]) {
                bfs(i);
                count++;
            }
        }

        for(int i = 0; i < middleResult.size(); i++){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j < middleResult.get(i).size(); j++){
                isVisited = new boolean[n];

                int member = middleResult.get(i).get(j);
                int dist = distance(member);
                if(dist < min){
                    index = member;
                    min = dist;
                }
            }
            finalResult.add(index + 1);
        }

        // 결과값 출력
        System.out.println(count);
        Collections.sort(finalResult);
        for(int i = 0; i < finalResult.size(); i++){
            System.out.println(finalResult.get(i));
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(start);
        ArrayList<Integer> middle = new ArrayList<>();
        middle.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            for(int i = 0; i < arr[node].size(); i++){
                int next = arr[node].get(i);
                if(isVisited[next]) continue;
                q.add(next);
                isVisited[next] = true;
                middle.add(next);
            }
        }
        middleResult.add(middle);
    }

    static int distance(int start){
        Queue<int[]> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(new int[]{start, 0});
        int result = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curNode = node[0];
            int curDist = node[1];
            result = Math.max(result, curDist);
            for(int i = 0; i < arr[curNode].size(); i++){
                int next = arr[curNode].get(i);
                if(isVisited[next]) continue;
                q.add(new int[]{next, curDist + 1});
                isVisited[next] = true;
            }
        }

        return result;
    }

    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }

}
