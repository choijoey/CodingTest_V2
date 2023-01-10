package programmers;

public class programmers_43162 {

    static int[][] map;
    static int N;
    static boolean[] v;

    public int solution(int n, int[][] computers) {

        map = computers;
        N = n;
        v = new boolean[N];

        int answer = dfs();
        return answer;
    }

    static int dfs(){
       int cnt = 0;

        for (int i = 0; i < N; i++) {
                if(!v[i]) {
                    v[i] = true;
                    cnt++;
                    dfs2(i);
                }
        }
        return cnt;
    }
    static void dfs2(int num){
        for (int i = 0; i < N; i++) {
            if(v[i]) continue;
            if(map[num][i] != 1) continue;
            v[i] = true;
            dfs2(i);
        }
    }

}
