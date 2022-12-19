package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1339 {
    static int[] alphabet,key,val;
    static int ans,alphabetCnt;//정답,알파벳 개수
    static boolean[] cur,v; //현재 있는 알파벳
    static String[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());



        //26p10을 하나 10p10을 하나 비슷할거 같은데
        alphabet = new int[26];
        ans =0;
        cur = new boolean[26];
        list = new String[N];
        alphabetCnt =0;

        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }

        for(String s : list){
            char[] chars = s.toCharArray();
            int size =chars.length;
            for (int i = 0; i < size; i++) {
                if(!cur[chars[i]-'A']){
                    alphabetCnt++;
                    cur[chars[i]-'A'] = true;
                }
            }
        }
        key = new int[26];
        val = new int[alphabetCnt];
        v = new boolean[10];
        int j =0;

        for (int i = 0; i <26 ; i++) {
            if(cur[i]) key[i] = j++;
        }


        permu(0);
        System.out.println(ans);
    }
    public static int toInt(String s){
        char[] chars = s.toCharArray();
        int size =chars.length;
        int num =0;

        for (int i = 0; i < size; i++) {
            num = num*10 +val[key[chars[i]-'A']];
        }
//        System.out.println(num);
        return num;
    }
    public static void permu(int cnt){
        if(cnt == alphabetCnt){
            int num = 0;

            for(String s : list){
                num += toInt(s);
            }
            ans =Integer.max(ans,num);
            return;
        }

        for (int i = 0; i < 10; i++) {

            if(v[i]) continue;

            val[cnt] = i;
            v[i] =true;
            permu(cnt+1);

            v[i] = false;
        }
    }
}
