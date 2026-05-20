import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO4178 {
    static int[] result;
    static int[] arr;
    static boolean[] isVisited;
    static int n, m;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        isVisited = new boolean[n];
        result = new int[m];
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
            if(isVisited[i]) continue;
            isVisited[i] = true;
            result[depth] = arr[i];
            Permutation(depth + 1);
            isVisited[i] = false;
            result[depth] = 0;
        }
    }
}
