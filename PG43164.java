import java.util.ArrayList;
import java.util.Collections;

public class PG43164 {

    static boolean[] isVisited;
    static ArrayList<String> resultList;
    public static void main(String[] args) {
        PG43164 sol = new PG43164();

        System.out.println(sol.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
    }

    public String[] solution(String[][] tickets){
        isVisited = new boolean[tickets.length];
        resultList = new ArrayList<>();

        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", tickets, path, 0);

        Collections.sort(resultList);

        return resultList.get(0).split(" ");
    }

    public void dfs(String current, String[][] tickets, ArrayList<String> path, int count){
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
            if(!isVisited[i] && tickets[i][0].equals(current)){
                isVisited[i] = true;
                path.add(tickets[i][1]);

                dfs(tickets[i][1], tickets, path, count + 1);

                isVisited[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }
}
