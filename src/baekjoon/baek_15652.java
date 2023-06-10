package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class baek_15652 {


    static int N,R;
    static int[] num;
    static  BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        num = new int[R];

        comb(0,0);

        bw.flush();
        bw.close();
    }
    static void comb(int cnt,int start) throws IOException {
        if(cnt == R){
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < R; i++) {
                sb.append(num[i]+" ");
            }
            sb.append("\n");
            bw.write(sb.toString());

            return;
        }

        for (int i = start; i < N; i++) {

            num[cnt] = i+1;
            comb(cnt+1,i);

        }
    }
}
