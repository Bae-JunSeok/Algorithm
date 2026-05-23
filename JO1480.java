import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1480 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> arrList = new ArrayList<>(); // 중복 검사를 위한 arrayList
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        Combination(0, 0);

        System.out.println(sb);
    }

    static void Combination(int depth, int start){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return ;
        }

        for(int i = start; i < n; i++){
            result[depth] = arr[i];
            Combination(depth + 1, i);
        }
    }
}
