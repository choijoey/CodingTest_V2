package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek_1339_2 {
    //브루트 포스로 해결

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] strings = new String[N];
        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }
        for(String s : strings){
            char[] chars = s.toCharArray();
            int size = chars.length;
            int start = 1;

            for(int i=size-1 ;i >=0 ;i--){
                alphabet[chars[i]-'A']+=start;
                start*=10;
            }
        }
        Arrays.sort(alphabet);

        int start = 9;
        int ans =0;

        for(int i=25; i>=0;i--){
            if(alphabet[i]==0) continue;
            ans += alphabet[i]*start;
            start--;
        }
        System.out.println(ans);
    }
}
