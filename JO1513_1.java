import java.io.BufferedReader;
import java.io.InputStreamReader;


public class JO1513_1 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int result = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[2 * n - 1];


        dfs(0, 0, 0);
        sb.append("total " + result + " cases");
        System.out.println(sb);
    }


    static void dfs(int win, int lose, int cnt){
        if(win == n){
            for(int i = 0; i < cnt; i++){
                if(arr[i] == 1){
                    sb.append("o");
                } else {
                    sb.append("x");
                }
            }
            result++;
            sb.append("\n");
            return ;
        }

        if(lose == n){
            return ;
        }

        arr[cnt] = 1;
        dfs(win + 1, lose, cnt + 1);

        arr[cnt] = 0;
        dfs(win, lose + 1, cnt + 1);
    }
}
