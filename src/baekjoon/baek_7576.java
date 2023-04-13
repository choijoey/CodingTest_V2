package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        int[][] map = new int[N][M];
        int cnt = 0; //안익은 토마토 개수
        int level = 0; //날짜

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1)
                    queue.offer(new int[]{i,j});
                else if(map[i][j] == 0)
                    cnt++;
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];

                    if(ny < 0 || ny>=N ||  nx< 0 || nx >= M)
                        continue;
                    if(map[ny][nx] == -1|| map[ny][nx] == 1)
                        continue;

                    cnt--;
                    queue.offer(new int[]{ny,nx});
                    map[ny][nx] = 1;
                }
            }
            if(!queue.isEmpty())
                level++;
        }


        if(cnt > 0)
            System.out.println(-1);
        else
            System.out.println(level);
    }
}
