package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15649 {

    static boolean[] v;
    static int N,R;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        v = new boolean[N];
        num = new int[R];

        permu(0);

    }
    static void permu(int cnt){
        if(cnt == R){
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < R; i++) {
                sb.append(num[i]+" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(v[i])
                continue;

            num[cnt] = i+1;
            v[i] = true;
            permu(cnt+1);
            v[i] = false;
        }
    }
}
