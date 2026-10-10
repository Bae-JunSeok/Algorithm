import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1544 {
    static int n;
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer> scores = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int numberOfMember;
    static boolean[] isVisited;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if(x == -2 && y == -2) break;
            addGraph(x, y);
        }

        for(int i = 0; i < n; i++){
            bfs(i);
        }

        for(int i = 0; i < scores.size(); i++){
            if(scores.get(i) < min){
                min = scores.get(i);
            }
        }

        for(int i = 0; i < scores.size(); i++){
            if(scores.get(i) == min){
                numberOfMember++;
                result.add(i + 1);
            }
        }

        System.out.println(min + " " + numberOfMember);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }


    }

    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }

    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        isVisited = new boolean[n];
        isVisited[start] = true;
        int middleMax = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curRelation = node[1];
            for(int i = 0; i < arr[curX].size(); i++){
                int next = arr[curX].get(i);
                if(isVisited[next]) continue;
                q.add(new int[]{next, curRelation + 1});
                isVisited[next] = true;
                if(curRelation + 1 > middleMax){
                    middleMax = curRelation + 1;
                }
            }
        }

        scores.add(middleMax);

    }
}
