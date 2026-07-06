import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1060_prim {
    static int n;
    static int[][] graph;
    static boolean[] isVisited;
    static int[] minEdge;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        isVisited = new boolean[n];
        minEdge = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        int result = 0;
        minEdge[0] = 0;

        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for(int j = 0; j < n; j++){
                if(!isVisited[j] && minEdge[j] < min){
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            isVisited[minVertex] = true;
            result += min;

            for(int j = 0; j < n; j++){
                if(!isVisited[j] && graph[minVertex][j] != 0 && graph[minVertex][j] < minEdge[j]){
                    minEdge[j] = graph[minVertex][j];
                }
            }
        }
        System.out.println(result);
    }
}
