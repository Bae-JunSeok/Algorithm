import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] result;
    static ArrayList<int[]> answers = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        result = new int[n];

        for(int i = 0; i <= n; i++){
            arr[i] = i;
        }

        Combination(0, 0, 0);

        answers.sort((a, b) -> {
            int len = Math.min(a.length, b.length);

            for(int i = 0; i < len; i++){
                if(a[i] != b[i]){
                    return b[i] - a[i]; // 큰 숫자가 먼저
                }
            }

            return a.length - b.length;
        });

        for(int[] answer : answers){
            for(int i = 0; i < answer.length; i++){
                if(i > 0){
                    sb.append(" ");
                }
                sb.append(answer[i]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void Combination(int depth, int start, int s){
        if(depth == n){
            if(s == n){
                int count = 0;

                for(int i = 0; i < n; i++){
                    if(result[i] != 0){
                        count++;
                    }
                }

                int[] mid = new int[count];
                int index = 0;

                for(int i = n - 1; i >= 0; i--){
                    if(result[i] != 0){
                        mid[index++] = result[i];
                    }
                }

                answers.add(mid);
            }

            return;
        }

        for(int i = start; i <= n; i++){
            int nextSum = s + arr[i];

            if(nextSum > n){
                break;
            }

            result[depth] = arr[i];
            Combination(depth + 1, i, nextSum);
        }
    }
}