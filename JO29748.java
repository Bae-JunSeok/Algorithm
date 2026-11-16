import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO29748 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(s.equals("UNICON")){
                sb.append("ACCEPTED");
            } else {
                sb.append("WRONG ANSWER");
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}
