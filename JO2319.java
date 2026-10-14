import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2319 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aMax = 0;
        int bMax = 0;
        for(int i = 0; i < 7; i++){
            int c = Integer.parseInt(st.nextToken());
            if(c % 2 == 0){ // 짝수일 때
                if(c > aMax) aMax = c;
            } else {
                if(c > bMax) bMax = c;
            }
        }

        System.out.println(aMax + bMax);
    }
}
