class 지폐접기 {
    public static void main(String[] args) {
        int[] wallet = {50, 50};
        int[] bill = {100, 241};

        지폐접기 sol = new 지폐접기();
        int answer = sol.solution(wallet, bill);

        System.out.println(answer);
    }

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        boolean canInput = false;
        boolean c = false;
        boolean d = false;
        if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) c = true;
        if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) d = true;
        if(c || d) canInput = true;
        while (!canInput) {
            int Max = Integer.MIN_VALUE;
            int index = 0;
            for(int i = 0; i < 2; i++){
                if(bill[i] > Max) {
                    Max = bill[i];
                    index = i;
                }
            }
            bill[index] = bill[index] / 2;
            answer++;
            boolean a = false;
            boolean b = false;
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) a = true;
            if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) b = true;
            if(a || b) canInput = true;
        }
        return answer;
    }
}