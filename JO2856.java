import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2856 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String[] s = new String[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            s[i] = st.nextToken();
        }

        int result = 0;
        for(int i = 0; i < 5; i++){
            if(s[i].contains(target)){
                result++;
            }
        }

        System.out.println(result);
    }
}
