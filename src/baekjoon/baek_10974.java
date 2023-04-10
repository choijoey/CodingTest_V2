package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_10974 {
    static boolean[] v;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        v = new boolean[N];

        permu(0,N);

    }
    static void permu(int start,int N){
        if(start == N){
            for (int i = 0; i < N; i++) {
                System.out.print(list[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(v[i])
                continue;
            list[start] = i+1;
            v[i] = true;

            permu(start+1,N);
            v[i] = false;
        }
    }
}
