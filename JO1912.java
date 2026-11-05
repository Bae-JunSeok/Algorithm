import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO1912 {   
    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n];
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
            Collections.sort(arr[i]);
        }

        dfs(0);


        for(int i = 0; i < result.size(); i++){
            System.out.print((result.get(i) + 1)+ " ");
        }
    }

    static void dfs(int start){
        Stack<Integer> s = new Stack<>();
        s.push(start);

        isVisited[start] = true;
        result.add(start);

        while (!s.isEmpty()) {
            int node = s.peek();
            boolean found = false;

            for(int i = 0; i < arr[node].size(); i++){
                int next = arr[node].get(i);
                if(isVisited[next]) continue;
                s.push(next);
                isVisited[next] = true;
                result.add(next);
                found = true;
                break;
            }

            if(!found){
                s.pop();
            }
        }
    }

    static void addGraph(int x, int y){
        arr[x].add(y);
        arr[y].add(x);
    }
}
