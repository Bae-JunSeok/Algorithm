import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO2434 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int r = a * b;
        ArrayList<Integer> result = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> news = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            news.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < 5; i++){
            result.add(news.get(i) - r);
        }
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
