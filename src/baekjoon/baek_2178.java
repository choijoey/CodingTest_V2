package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2178 {

    static int N,M;
    static int[][] map;
    static int[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] s =br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                    map[i][j] = (s[j]-'0');
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        queue.offer(new int[]{0,0});
        v[0][0] = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] +dy[i];
                int nx = cur[1] +dx[i];

                if(ny>=N || ny <0 || nx>=M || nx<0)
                    continue;
                if(v[ny][nx] != 0)
                    continue;
                if(map[ny][nx] == 0)
                    continue;
                queue.offer(new int[]{ny,nx});
                v[ny][nx] = v[cur[0]][cur[1]] +1;
            }

        }
        System.out.println(v[N-1][M-1]);
    }
}
