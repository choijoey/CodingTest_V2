package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_2331 {

    // A가 9999이고 P가 5일때 연산 결과(30만)가 생각보다 큰 거 같아서 해시로 풀었는데 결과는 별반차이 없는것 같다.
    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        hashMap.put(N,0);

        dfs(N,1);
    }

    public static void dfs(int cur,int cnt){
        int res = cal(cur);
        if(hashMap.containsKey(res)){
            int idx =hashMap.get(res);

            System.out.println(idx);
            return;
        }
        hashMap.put(res,cnt);
        dfs(res,cnt+1);
    }
    public static int cal(int num){
        int res = 0;

        while (num>0){
            int tmp = num%10;
            res += Math.pow(tmp,P);
            num/=10;
        }

        return res;
    }
}
