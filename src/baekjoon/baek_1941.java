package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1941 {

    static int ans;
    static boolean[][] v;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = new boolean[5][5];
        map = new char[5][5];
        ans =0;

        for(int i=0;i<5;i++){
            map[i] = br.readLine().toCharArray();
        }
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(map[i][j] == 'S'){
                    v[i][j] = true;
                    list.add(new int[]{i,j});
                    dfs(1,1,list);
                    list.remove(0);
                    v[i][j] =false;
                }
            }
        }
        System.out.println(ans);
    }

    static int[] dy = {1,1,0};
    static int[] dx = {0,1,1};

    public static void dfs(int cnt, int dasom ,ArrayList<int[]> list){
        if(cnt == 7){

//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    if(v[i][j])
//                        System.out.print('O');
//                    else
//                        System.out.print('X');
//                }
//                System.out.println();
//            }
//            System.out.println(
//            );
//            System.out.println();
            if(dasom < 4) {
                return;
            }

            ans++;
            return;
        }

        for(int j=0;j<list.size();j++){
            int[] cur = list.get(j);
            int y = cur[0];
            int x = cur[0];

            for (int i = 0; i < 3; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;

                if(ny>=5||ny<0||nx>=5||nx<0){
                    continue;
                }
                if(v[ny][nx]) continue;

                v[ny][nx] = true;
                list.add(new int[]{ny,nx});
                if(map[ny][nx] == 'S')
                    dfs(cnt+1,dasom+1,list);
                else
                    dfs(cnt+1,dasom,list);
                list.remove(cnt-1);
                v[ny][nx] = false;
            }
        }


    }
}
