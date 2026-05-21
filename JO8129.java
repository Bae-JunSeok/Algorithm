import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO8129 {
    static int n, m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        result = new int[m];
        combination(0, 0);
        String s = br.readLine();
        s += " ";
        int r = Integer.MAX_VALUE;
        for(int i = 0; i < arrayList.size(); i++){
            if(s.equals(arrayList.get(i))){
                r = i;
            }
        }
        if(r == Integer.MAX_VALUE){
            System.out.println("None");
        } else {
            System.out.println(r + 1);
        }
    }

    static void combination(int depth, int sequence){
        if(depth == m){
            String s = "";
            for(int i = 0; i < m; i++){
                s += Integer.toString(result[i]);
                s += " ";
                
            }
            arrayList.add(s);
            return ;
        }

        for(int i = sequence; i < n; i++){
            result[depth] = arr[i];
            combination(depth + 1, i + 1);
        }
    }
}
