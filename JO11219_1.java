import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO11219_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int right = 0;
        int left = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            if(b.equals("R")){
                right += c;
            } else {
                left += c;
            }
        }

        int location = Integer.parseInt(br.readLine());

        location += right;
        location -= left;

        System.out.println(location);
    }
}
