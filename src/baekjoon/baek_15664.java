package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class baek_15664 {
    static int N,M;
    static int[] input,list,res;
    static HashSet<String> hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        list = new int[M];
        hashSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        comb(0,0);



    }
    static void comb(int cnt, int start){
        if(cnt == M){
            int[] tmp = new int[M];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                sb.append(list[i]+" ");
            }
            String s = sb.toString();

            if(hashSet.add(s)){
                System.out.println(s);
            }

            return;
        }
        for (int i = start; i < N; i++) {
            list[cnt] = input[i];

            comb(cnt+1,i+1);
        }
    }


}
