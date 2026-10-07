import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO9237 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int age = Integer.parseInt(st.nextToken());

        if(s.equals("M") || s.equals("m")){
            if(age >= 19){
                System.out.println("MAN");
            } else {
                System.out.println("BOY");
            }
        } else if(s.equals("F") || s.equals("f")){
            if(age >= 19){
                System.out.println("WOMAN");
            } else {
                System.out.println("GIRL");
            }
        }
    }
}
