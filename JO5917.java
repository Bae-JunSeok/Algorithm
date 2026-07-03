import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class JO5917 {
    static Deque<Integer> phase1 = new ArrayDeque<>();
    static Deque<Integer> phase2 = new ArrayDeque<>();
    static Deque<Integer> phase3 = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, t;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        ArrayList<int[]> commmands = new ArrayList<>();
        int c, d;
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            commmands.add(new int[]{c, d});
        }

        for(int i = n; i > 0; i--){
            phase1.push(i); // stack에 넣는 과정
        }

        for(int i = 0; i < t; i++){
            int[] command = commmands.get(i);
            int c1 = command[0];
            int c2 = command[1];
            simulation(c1, c2);
        }

        StringBuilder sb = new StringBuilder();
        while (!phase3.isEmpty()) {
            sb.append(phase3.pop()).append("\n");
        }

        System.out.println(sb);
    }


    static void simulation(int c1, int c2){
        if(c1 == 1){
            for(int i = 0; i < c2; i++){
                phase2.push(phase1.pop());
            }
        } else {
            for(int i = 0; i < c2; i++){
                phase3.push(phase2.pop());
            }
        }
    }
}
