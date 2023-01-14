package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test_2 {

    static int N,M;
    static int[][] map;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        //dfs?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         map = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; //구역 개수
        //탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    cnt++;
                    bfs(new int[]{i,j});
                }
            }
        }

        System.out.println(cnt);

    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static void bfs(int[] tmp){

        queue.offer(tmp);

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = (y+dy[i]+N)%N;
                int nx = (x+dx[i]+M)%M;

                //범위 체크는 나머지 연산때문에 생략
                if(map[ny][nx] == 1) continue; //막혀있거나 이미 지나간 길이면

                map[ny][nx] = 1;
                queue.offer(new int[]{ny,nx});

            }
        }
    }
}
