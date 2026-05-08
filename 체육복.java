import java.util.*;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = 1;
        }
        for(int i = 0; i < lost.length; i++){
            arr[lost[i] - 1]--;
        }
        for(int i = 0; i < reserve.length; i++){
            arr[reserve[i] - 1]++;
        }
        if(arr[0] == 0){
            if(arr[1] == 2){
                arr[1]--;
                arr[0]++;
            }
        }
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i] == 0){
                if(arr[i - 1] == 2){
                    arr[i - 1]--;
                    arr[i]++;
                } else if(arr[i + 1] == 2){
                    arr[i + 1]--;
                    arr[i]++;
                }
            }    
        }
        if(arr[arr.length - 1] == 0){
            if(arr[arr.length - 2] == 2){
                arr[arr.length - 2]--;
                arr[arr.length - 1]++;
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 1) answer++;
        }
        return answer;
    }
}