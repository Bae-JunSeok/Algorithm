import java.util.ArrayList;

public class PG42888 {
    public static void main(String[] args) {
        PG42888 sol = new PG42888();

        System.out.println(sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
    }

    public String[] solution(String[] record){
        
        ArrayList<String> result = new ArrayList<>();
        //ArrayList<String> members = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> commands = new ArrayList<>();
        ArrayList<String> nicknames = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            String[] input = record[i].split(" ");
            String command = input[0];
            String id = input[1];
            if(command.equals("Enter")){ // Enter일 때
                String nickname = input[2];
                commands.add(command);
                ids.add(id);
                nicknames.add(nickname);
                if(ids.contains(id)){
                    for(int j = 0; j < ids.size(); j++){
                        if(id.equals(ids.get(j))){
                            nicknames.set(j, nickname);
                        }
                    }
                }
            } else if(command.equals("Leave")){ // Leave일 때
                commands.add(command);
                ids.add(id);
                for(int j = 0; j < ids.size(); j++){
                    if(id.equals(ids.get(j))){
                        nicknames.add(nicknames.get(j));
                        break;
                    }
                }
            } else if(command.equals("Change")){ // Change일 때
                String nickname = input[2];
                for(int j = 0; j < ids.size(); j++){
                    if(id.equals(ids.get(j))){
                        nicknames.set(j, nickname);
                    }
                }
            }
        }
        String[] answer = new String[ids.size()];
        for(int i = 0; i < ids.size(); i++){
            String r = "";
            if(commands.get(i).equals("Enter")){
                r += nicknames.get(i) + "님이 들어왔습니다.";
            } else {
                r += nicknames.get(i) + "님이 나갔습니다.";
            }

            answer[i] = r;
        }

        return answer;
    }
}
