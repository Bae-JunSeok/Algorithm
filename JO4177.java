import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO4177 {
    static int[] arr;
    static int[] result;
    //static boolean[] isVisited;
    static int n, m;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        //isVisited = new boolean[n];
        result = new int[m];
        sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        Permutation(0);
        System.out.println(sb);
    }

    static void Permutation(int depth){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");

            return ;
        }

        for(int i = 0; i < n; i++){
            //if(isVisited[i]) continue;
            result[depth] = arr[i];
            Permutation(depth + 1);
        }
    }
}
