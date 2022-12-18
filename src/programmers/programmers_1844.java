package programmers;

import java.util.*;

public class programmers_1844 {
    public int solution(int[][] maps) {

        int row = maps.length;
        int col = maps[0].length;


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        maps[0][0] = 0;

        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        while (!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny>=row ||ny<0 || nx>=col || nx <0)
                    continue;
                if(maps[ny][nx] ==0)
                    continue;
                if(ny==row-1 && nx==col-1){
                    return cur[2]+1;
                }
                if(maps[ny][nx]==0) continue;

                queue.offer(new int[]{ny,nx,cur[2]+1});
                maps[ny][nx]=0;
            }
        }
        return -1;
    }
}
