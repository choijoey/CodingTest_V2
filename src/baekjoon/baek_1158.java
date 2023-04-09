package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] list = new int[N];
        boolean[] v = new boolean[N];

        for(int i=0;i<N;i++) {
            list[i] = i+1;
        }

        StringBuilder sb =new StringBuilder();
        sb.append("<");
        int jump=K-1;
        for(int i=0;i<N;i++) {
            if(i==N-1) {
                sb.append(list[jump]);
                break;
            }
            else
                sb.append(list[jump]+", ");

            v[jump]=true;

            for(int j=0;j<K;j++) {
                while(true) {
                    jump = (jump+1)%N;
                    if(!v[jump])
                        break;
                }
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
