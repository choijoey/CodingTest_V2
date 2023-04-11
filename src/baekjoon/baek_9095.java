package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_9095 {


    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(br.readLine());
            ans =0;
            for (int j = 1; j <= num; j++) {
                int[] list = new int[j];
                permu(0,num,list);

            }

            System.out.println(ans);
        }


    }

    static void permu(int start,int end,int[] list){
        if(start == list.length){

            int sum = 0;

            for (int i = 0; i < list.length; i++) {
                sum += list[i];
            }
            if(sum == end)
                ans++;
            return;
        }

        for (int i = 1; i <=3 ; i++) {

                list[start] = i;

                permu(start+1,end,list);

        }
    }


}
