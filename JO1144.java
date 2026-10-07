import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1144 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        String command = st.nextToken();

        for(int i = 0; i < command.length(); i++){
            char c = command.charAt(i);

            if(c == 'L'){
                x -= 1;
            } else if(c == 'R'){
                x += 1;
            } else if(c == 'U'){
                y += 1;
            } else if(c == 'D'){
                y -= 1;
            }
        }

        System.out.println(x + " " + y);
    }
}
