package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1 {
    public static void main(String[] args) throws IOException {
        //1 왼 2 오
        // N 100000 이하

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 1){
                arr[i] = 1;
                arr2[i] = -1;
            }
            else{
                arr[i] = -1;
                arr2[i] = 1;
            }

        }

        int[] cache = new int[n];
        int[] cache2 = new int[n];

        int ans = 1;
        cache[0] = arr[0];
        cache2[0] = arr2[0];

        for(int i=1;i<n;i++){
            cache[i] = Integer.max(0,cache[i-1]) +arr[i];
            cache2[i] = Integer.max(0,cache2[i-1]) +arr2[i];
            ans = Math.max(ans, cache[i]);
            ans = Math.max(ans,cache2[i]);
        }


        System.out.println(ans);

    }
}
