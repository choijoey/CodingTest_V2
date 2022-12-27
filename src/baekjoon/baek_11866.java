package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] list = new boolean[N];
        int[] ans = new int[N];

        int idx = 0; // 시작 인덱스
        int stIdx = 0; //정답인덱스

        for(int i =0; i < N;i++){
            int cnt = 0;
            while(cnt <K){
                idx = (idx + 1) % N;
                if(!list[idx])
                    cnt++;
            }
            list[idx] = true;
            ans[stIdx++] = idx;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 0; i < N; i++) {
            if(ans[i] == 0)
                sb.append(N);
            else
                sb.append(ans[i]);

            if(i != N-1)
                sb.append(", ");
        }
        sb.append('>');
        System.out.println(sb.toString());
    }
}
