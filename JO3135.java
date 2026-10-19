import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO3135 {
    static int n;
    static int[] arr;
    static int test_case;
    static long[] sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        sum = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[1] = arr[1];
        for(int i = 2; i <= n; i++){
            sum[i] = sum[i - 1] + (long)arr[i];
        }
        test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int t = 0; t < test_case; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long result = sum[b] - sum[a - 1];
            sb.append(result).append("\n");
        }

        


        System.out.println(sb);

    }
}
