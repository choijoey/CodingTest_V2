package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_1949 {

    static int[][] map;
    static int N,K;
    static int ans;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,1,-1};
    static boolean[][] v ;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            v = new boolean[N][N];

            int top = -1;
            ans = 0;

            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > top){
                        top = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == top){
                        v[i][j] =true;
                        dfs(i,j,K,1);
                        v[i][j] = false;
                    }
                }
            }
            System.out.println("#"+test_case+" "+ ans);

        }
    }
    static void dfs(int y, int x,int k,int depth){
        ans = Math.max(ans,depth);

        for (int i = 0; i < 4; i++) {
            int ny = y +dy[i];
            int nx = x +dx[i];

            if(ny >= N || ny < 0 || nx >=N || nx<0)
                continue;
            if(v[ny][nx])
                continue;

            if(k == 0){
                if(map[ny][nx] < map[y][x]) {
                    v[ny][nx] = true;
                    dfs(ny,nx,k,depth+1);
                    v[ny][nx] = false;
                }
            }
            else{
                if(map[ny][nx] < map[y][x]) {
                    v[ny][nx] = true;
                    dfs(ny,nx,k,depth+1);
                    v[ny][nx] = false;
                }
                else if (map[ny][nx] -k < map[y][x] ){
                        int tmp = map[ny][nx];

                        map[ny][nx] = map[y][x] -1;
                        v[ny][nx] = true;
                        dfs(ny,nx,0,depth+1);
                        v[ny][nx] = false;
                        map[ny][nx] = tmp;

                }
            }
        }
    }
}
