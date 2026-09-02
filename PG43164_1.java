import java.util.ArrayList;
import java.util.Collections;

public class PG43164_1 {
    static ArrayList<String> resultList = new ArrayList<>();
    static boolean[] isVisited;
    public static void main(String[] args) {
        PG43164_1 sol = new PG43164_1();

        System.out.println(sol.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
    }

    public String[] solution(String[][] tickets){
        isVisited = new boolean[tickets.length];
        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", tickets, path, 0);

        Collections.sort(resultList);

        String[] result = resultList.get(0).split(" ");



        return result;
    }

    static void dfs(String current, String[][] tickets, ArrayList<String> path, int count){
        if(count == tickets.length){
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < path.size(); i++){
                sb.append(path.get(i));
                if(i != path.size() - 1){
                    sb.append(" ");
                }
            }
            
            resultList.add(sb.toString());
            return ;
        }

        for(int i = 0; i < tickets.length; i++){
            if(!isVisited[i] && current.equals(tickets[i][0])){
                isVisited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, path, count + 1);
                isVisited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
