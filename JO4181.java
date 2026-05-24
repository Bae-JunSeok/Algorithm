import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO4181 {
    static int n, m, s;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        Permutation(0);

        System.out.println(sb);
    }

    static void Permutation(int depth){
        if(depth == m){
            int sum = 0;
            for(int i = 0; i < m; i++){
                sum += result[i];
            }
            if(sum == s){
                for(int i = 0; i < m; i++){
                    sb.append(result[i] + " ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < n; i++){
            result[depth] = arr[i];
            Permutation(depth + 1);
        }
    }
}
