package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken());

            if(n == 0) stack.pop();
            else stack.push(n);
        }
        int ans =0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        System.out.println(ans);
    }
}
