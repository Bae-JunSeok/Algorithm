import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소수와함께하는여행 {
    // 일단 에라토스테네스의 체로 배열 채워넣고, start에다가 시작 소수 주고, 일의 자리 바꿨을 때, 십의 자리 바꿨을 때, ...
    // 한 다음에 소수인지 아닌지 판별하고, 방문했는지도 판별, 소수이면서 방문을 안했다면은 큐에 넣고, 거기에 순서 + 1을 해준다.
    static int[] isPrime = new int[10000];// 에라토스테네스의 채 + bfs 구현
    static boolean[] isVisited = new boolean[10000];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for(int i = 0; i < isPrime.length; i++){ // 일단 전부 채워넣어
            isPrime[i] = i;
        }
        isPrime[0] = 0;
        isPrime[1] = 0;

        makePrime();
        System.out.println(bfs(start, end));
    }   

    static void makePrime(){
        for(int i = 0; i < isPrime.length; i++){
            if(isPrime[i] == 0) continue; 
            int b = 2;
            int a = i * b;
            while (a < isPrime.length) {
                isPrime[a] = 0;
                b++;
                a = i * b;
            }
        }
    }

    static int bfs(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        isVisited[start] = true;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cur_location = node[0];
            int cur_count = node[1];
            if(cur_location == end) return cur_count;
            char[] arr = String.valueOf(cur_location).toCharArray();

            for(int i = 0; i < 4; i++){
                char original = arr[i];
                
                for(char c = '0'; c <= '9'; c++){
                    if(c == original) continue;

                    arr[i] = c;

                    int next = Integer.parseInt(new String(arr));
                    if(next >= 1000 && isPrime(next) && !isVisited[next]){
                        isVisited[next] = true;
                        q.add(new int[]{next, cur_count + 1});
                    }
                }
                arr[i] = original;
            }
        }

        return 0;
    }

    static boolean isPrime(int a){
        if(isPrime[a] == 0){ // 만약에 0이면 소수가 아니다, 아니면 소수라는 뜻
            return false;
        } else {
            return true;
        }
    }
}
