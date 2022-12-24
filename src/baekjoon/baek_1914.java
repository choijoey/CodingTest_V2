package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class baek_1914 {

    //N 원판 개수
    //from 시작 위치 mid 중간 위치 to 목적지

    // 1. 시작 위치(from)에서 N-1개의 원판을 mid로 옮긴다  =>  N-1
    // 2. 시작 위치에 제일 큰 원판을 to 위치로 옮긴다.  => 1
    // 3. mid에서 나머지 N-1 원판을 to 위치로 옮긴다.

    static int cnt;
    static StringBuilder sb;

    static void cal(int N, int from,int mid, int to){
        if(N==0){
            return;
        }

        cal(N-1,from,to,mid);
        sb.append(from+" "+to+ "\n");
        cnt++;
        cal(N-1,mid,from,to);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        if(N>20) {
            BigInteger bigInt = BigInteger.valueOf(2);
            bigInt = bigInt.pow(N).subtract(BigInteger.valueOf(1));

            System.out.println(bigInt);
        }
        else {
            cal(N, 1, 2, 3);
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }
}
