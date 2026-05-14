import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class JO1642 {
    static char[][] map;
    static int[][] dist;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r, c;
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        dist = new int[r][c];
        for(int i = 0; i < r; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j < c; j++){
                map[i][j] = s[j].charAt(0);
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int count = 0;
                if(map[i][j] == 'X'){
                    for(int dir = 0; dir < 4; dir++){
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                            count++;
                            continue;
                        }
                        if(map[nx][ny] == '.') count++;
                    }
                    dist[i][j] = count;
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] == 'X' && dist[i][j] >= 3){
                    map[i][j] = '.';
                }
            }
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int top = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] == 'X'){
                    if(i > top){
                        top = i;
                    } 
                    if(i < bottom){
                        bottom = i;
                    }
                    if(j > right){
                        right = j;
                    }
                    if(j < left){
                        left = j;
                    }
                }
            }
        }

        for(int i = bottom; i <= top; i++){
            for(int j = left; j <= right; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
