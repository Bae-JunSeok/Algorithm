import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO8958 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
        if(z >= y || z >= x) {
            System.out.println(1);
        } else if(z < y && z < x){
            System.out.println(0);
        }
    }
}
