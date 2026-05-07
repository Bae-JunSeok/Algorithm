import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1697 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if(command == 'i'){
                int a = Integer.parseInt(st.nextToken());
                q.add(a);
            } else if(command == 'c'){
                sb.append(q.size()).append("\n");
            } else if(command == 'o'){
                if(q.size() > 0){
                    sb.append(q.poll()).append("\n");
                } else {
                    sb.append("empty").append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
