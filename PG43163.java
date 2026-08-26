import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PG43163 {
    public static void main(String[] args) {
        PG43163 sol = new PG43163();

        System.out.println(sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static ArrayList<String> Word;
    public int solution(String begin, String target, String[] words){
        arr = new ArrayList[1 + words.length];
        for(int i = 0; i < 1 + words.length; i++){
            arr[i] = new ArrayList<>();
        }
        Word = new ArrayList<>();
        isVisited = new boolean[1 + words.length];

        Word.add(begin);
        for(int i = 0; i < words.length; i++){
            Word.add(words[i]);
        }

        for(int i = 0; i < Word.size() - 1; i++){ // 비교해서 그래프에 넣기
            
            int j = 0;
            for(j = i + 1; j < Word.size(); j++){
                int count = 0;
                for(int k = 0; k < words[0].length(); k++){
                    if(Word.get(i).charAt(k) == Word.get(j).charAt(k)) {
                        count++;
                    }
                }
                    if(count == Word.get(i).length() - 1){
                        addGraph(i, j);
                        addGraph(j, i);
                }
            }
        }

        return bfs(0, target);
    }

    public void addGraph(int x, int y){
        arr[x].add(y);
    }

    public int bfs(int start, String target){
        isVisited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[Word.size()];

        q.add(start);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            if(Word.get(node).equals(target)) return dist[node];
            for(int i = 0; i < arr[node].size(); i++){
                int next = arr[node].get(i);
                if(isVisited[next]) continue;
                q.add(next);
                isVisited[next] = true;
                dist[next] = dist[node] + 1;
            }
        }

        return 0;

    } 
}
