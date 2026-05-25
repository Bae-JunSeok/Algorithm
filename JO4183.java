import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO4183 {
    static String[][] arr;
    static String[] result;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new String[n][];
        result = new String[n];

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());

            arr[i] = new String[m];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = st.nextToken();
            }
        }

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == n){
            sb.append("(");

            for(int i = 0; i < n; i++){
                if(i > 0){
                    sb.append(",");
                }
                sb.append(result[i]);
            }

            sb.append(")\n");
            return;
        }

        for(int i = 0; i < arr[depth].length; i++){
            result[depth] = arr[depth][i];
            dfs(depth + 1);
        }
    }
}