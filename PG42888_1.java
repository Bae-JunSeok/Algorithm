import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class PG42888_1 {
    public static void main(String[] args) {
        PG42888 sol = new PG42888();

        System.out.println(Arrays.toString(sol.solution(
            new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            }
        )));
    }

    public String[] solution(String[] record) {

        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> commands = new ArrayList<>();
        HashMap<String, String> members = new HashMap<>();

        for(int i = 0; i < record.length; i++){
            String[] input = record[i].split(" ");
            String command = input[0];
            String id = input[1];

            if(command.equals("Enter")){
                String nickname = input[2];

                commands.add(command);
                ids.add(id);
                members.put(id, nickname);

            } else if(command.equals("Leave")){
                commands.add(command);
                ids.add(id);

            } else if(command.equals("Change")){
                String nickname = input[2];
                members.put(id, nickname);
            }
        }

        String[] answer = new String[ids.size()];

        for(int i = 0; i < ids.size(); i++){
            String nickname = members.get(ids.get(i));

            if(commands.get(i).equals("Enter")){
                answer[i] = nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}