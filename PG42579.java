import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PG42579 {
    public static void main(String[] args) {
        PG42579 sol = new PG42579();

        System.out.println(sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }

    public int[] solution(String[] genres, int[] plays){
        HashMap<String, Integer> hash = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < genres.length; i++){ // 해시에 각 음악 장르의 값을 더함
            hash.put(genres[i], hash.getOrDefault(genres[i], 0) + plays[i]);
        }
        String target = "";
        while (!hash.isEmpty()) {
            int Max = -1;
            for(Map.Entry<String, Integer> entry: hash.entrySet()){
                int value = entry.getValue();
                if(value > Max){
                    Max = value;
                    target = entry.getKey();
                }
            }

            ArrayList<int[]> arr = new ArrayList<>();

            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(target)){
                    arr.add(new int[]{i, plays[i]});
                }
            }

            Collections.sort(arr, (a, b) -> b[1] - a[1]);

            if(arr.size() == 1){
                result.add(arr.get(0)[0]);
            } else {
                for(int i = 0; i < 2; i++){
                    result.add(arr.get(i)[0]);
                }
            }

            hash.remove(target);
        }
        
        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
