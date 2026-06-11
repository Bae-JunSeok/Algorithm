import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1127 {
    static int n;
    static boolean[] isSelected;
    static int[] sour; // 신맛
    static int[] acerbity; // 쓴맛
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isSelected = new boolean[n];
        sour = new int[n];
        acerbity = new int[n];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 신맛
            int a = Integer.parseInt(st.nextToken()); // 쓴맛
            sour[i] = s;
            acerbity[i] = a;
        }

        dfs(0);
        System.out.println(min);
    }

    static void dfs(int depth){
        if(depth == n){
            int count = 0;
            for(int i = 0; i < n; i++){
                if(isSelected[i]) count++;
            }
            if(count == 0) return ;
            int resultSour = 1;
            int resultAcerbity = 0;
            for(int i = 0; i < n; i++){
                if(isSelected[i]){
                    resultSour *= sour[i];
                    resultAcerbity += acerbity[i];
                }
            }
            int totalResult = Math.abs(resultSour - resultAcerbity);
            if(totalResult < min) min = totalResult;
            return ;
        }

        isSelected[depth] = true;
        dfs(depth + 1);

        isSelected[depth] = false;
        dfs(depth + 1);
    }
}
