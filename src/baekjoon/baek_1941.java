package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class baek_1941 {
    static char[][] map;
    static int[] numbers;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new char[5][5];
        numbers = new int[7];
        ans = 0;

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        //25C7
        combination(0,0);
        System.out.println(ans);
    }

    static public void combination(int cnt, int start){
        if(cnt == 7){
            int[][] point = new int[7][2];
            int[][] v = new int[5][5];
            int sCnt = 0;

            for (int i = 0; i < 7; i++) {
                point[i][0] = numbers[i] /5;
                point[i][1] = numbers[i] % 5;
                v[point[i][0]][point[i][1]] = 1;
                if(map[point[i][0]][point[i][1]] == 'S')
                    sCnt++;
            }


            if(bfs(v,point[0]) && sCnt>=4)ans++;

            return;
        }

        for (int i = start; i < 25; i++) {
            numbers[cnt] = i;
            combination(cnt+1,i+1);
        }

    }
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static boolean bfs(int[][] v,int[] start){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        v[start[0]][start[1]] = 2;
        int cnt =1;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] +dy[i];
                int nx = cur[1] + dx[i];
                if(ny<0||ny>=5||nx<0||nx>=5) continue;
                if(v[ny][nx] != 1) continue;

                queue.offer(new int[] { ny,nx});
                v[ny][nx] = 2;
                cnt++;

            }
        }
        if(cnt == 7) return true;
        return false;
    }
    }