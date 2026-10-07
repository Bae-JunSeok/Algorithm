import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO11219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        String[] command = new String[a];

        for(int i = 0; i < a; i++){
            command[i] = br.readLine();
        }

        int location = Integer.parseInt(br.readLine());

        int count = 0;
        while (count < a) {
            count++;
            for(int i = 0; i < a; i++){
                String[] input = command[i].split(" ");
                int b = Integer.parseInt(input[0]);
                if(b == location){
                    String direction = input[1];
                    int how = Integer.parseInt(input[2]);
                    if(direction.equals("R")){
                        location += how;
                    } else {
                        location -= how;
                    }
                }
            }
        }


        System.out.println(location);
    }
}
