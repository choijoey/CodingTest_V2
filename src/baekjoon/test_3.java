package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_3 {
    static int N,M,C;
    static int[] A,B;
    static int[][] w;

    public static void main(String[] args) throws IOException {
        //N A 학생 수
        //M B 학생 수
        //C 성격 1~C

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());

         w = new int[C][C]; //성격
         A = new int[N+1]; //A 학생
         B = new int[M+1];

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0,0);
        System.out.println(ans);

    }
    static long ans;

    static void dfs(int from,int to, long sum){
        if(from == N){
            ans = Math.max(ans,sum);
            return;
        }
        if(to == M) return;


            for (int j = to+1; j <=M ; j++) {


                dfs(from,j,sum+w[A[from]-1][B[j]-1]);
                dfs(from+1,j,sum);
            }

    }
}
