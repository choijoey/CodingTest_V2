package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1){
                    int cnt = 1; //단지 내 아파트 개수
                    map[i][j] = 0;
                    queue.offer(new int[]{i,j});


                    while (!queue.isEmpty()){
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = cur[0] +dy[k];
                            int nx = cur[1] +dx[k];

                            if(ny<0||ny>=N||nx<0||nx>=N) continue;
                            if(map[ny][nx] == 0) continue;
                            map[ny][nx] = 0;
                            cnt++;
                            queue.offer(new int[]{ny,nx});
                        }
                    }
                    ans.add(cnt);
                }
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for(int i : ans){
            System.out.println(i);
        }
    }
}
