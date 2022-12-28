package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baek_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            hashSet.add(s);
        }

        for (int i = 0; i < M; i++) {
            String s= br.readLine();

            if(hashSet.contains(s)){
                ans.add(s);
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(String s : ans){
            System.out.println(s);
        }
    }
}
