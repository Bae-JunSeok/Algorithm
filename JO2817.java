import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2817 {
    static int[] arr;
    static int[] result = new int[6];
    
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());    
        }

        dfs(0, 0);

        System.out.println(sb);
    }


    static void dfs(int start, int depth){
        if(depth == 6){
            for(int i = 0; i < 6; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++){
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
