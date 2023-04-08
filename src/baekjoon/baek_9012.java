package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int cnt = 0; // ( 의 개수
            boolean flag = false;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == '(')
                    cnt++;
                else
                    cnt--;

                if(cnt < 0)
                    break;
            }
            if(cnt == 0) flag = true;

            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
