import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1889 {
    static int n;
    static int result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);

        System.out.println(result);
    }

    static void dfs(int cnt){
        if(cnt == n){
            result++;
            return;
        }

        for(int i = 0; i < n; i++){
            arr[cnt] = i;

            if(check(cnt)){
                dfs(cnt + 1);
            }
        }
    }

    static boolean check(int row){
        for(int i = 0; i < row; i++){

            // 같은 열
            if(arr[i] == arr[row]){
                return false;
            }

            // 같은 대각선
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])){
                return false;
            }
        }

        return true;
    }
}