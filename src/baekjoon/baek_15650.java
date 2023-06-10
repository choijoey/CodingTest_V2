package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15650 {


    static int N,R;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        num = new int[R];

        comb(0,0);

    }
    static void comb(int cnt,int start){
        if(cnt == R){
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < R; i++) {
                sb.append(num[i]+" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {


            num[cnt] = i+1;
            comb(cnt+1,i+1);

        }
    }
}
