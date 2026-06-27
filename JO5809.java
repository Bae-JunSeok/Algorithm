import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO5809 {
    static int n, m;
    static ArrayList<Integer>[] meeting;
    static ArrayList<Integer>[] peopleConnected;
    static boolean[] canVisit;
    static ArrayList<Integer> knowSecret = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫번째 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        meeting = new ArrayList[m];
        for(int i = 0; i < m; i++){
            meeting[i] = new ArrayList<>();
        }

        peopleConnected = new ArrayList[n];
        for(int i = 0; i < n; i++){
            peopleConnected[i] = new ArrayList<>();
        }
        canVisit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        for(int i = 0; i < number; i++){
            knowSecret.add(Integer.parseInt(st.nextToken()) - 1); // 두번째 입력
        }

        for(int i = 0; i < m; i++){ 
            st = new StringTokenizer(br.readLine()); // 나머지 입력
            int peopleInMeeting = Integer.parseInt(st.nextToken());
            for(int j = 0; j < peopleInMeeting; j++){
                meeting[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < meeting[i].size() - 1; j++){
                for(int k = j + 1; k < meeting[i].size(); k++){
                    addGraph(meeting[i].get(j), meeting[i].get(k));
                }
            }
        }

        for(int i = 0; i < knowSecret.size(); i++){
            bfs(knowSecret.get(i));
        }

        int result = 0;

        for(int i = 0; i < m; i++){
            boolean possible = true;
            for(int j = 0; j < meeting[i].size(); j++){
                if(canVisit[meeting[i].get(j)]){
                    possible = false;
                    break;
                }
            }

            if(possible) result++;
        }
        System.out.println(result);
    }

    static void addGraph(int x, int y){
        peopleConnected[x].add(y);
        peopleConnected[y].add(x);
    }

    static void bfs(int start){
        if(canVisit[start]) return;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        canVisit[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();

            for(int i = 0; i < peopleConnected[now].size(); i++){
                int next = peopleConnected[now].get(i);
                if(canVisit[next]) continue;
                q.add(next);
                canVisit[next] = true;
            }
        }

    }
}
