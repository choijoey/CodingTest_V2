package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16987 {
    //문제 정리

    // 계란 1 = 내구도 7 무게 5
    // 계란 2 = 내구도 3 무게 4
    // 결과: 계란 1 내구도 3  계란 2 내구도 -2

    //1. 가장 왼쪽 계란 든다

    //2. 들고 있는 계란으로 안꺠진 계란 친다.
    // 손에 든 계란이 깨졌거나, 다른 모든 계란이 꺠졌으면 손에 들고있는 계란 내려놓고 3번

    //3. 가장 최근에 든 계란의 한칸 오른쪽 계란을 손에 들고 2번 다시 진행, 마약 손에 든 계란이
    //가장 오른쪽인경우 종료

    static int ans,N;
    static int[] dur,wei;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dur = new int[N]; //내구도
        wei = new int[N]; //무게

        for(int i = 0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            dur[i] = Integer.parseInt(st.nextToken());
            wei[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(ans);

    }
    public static void dfs(int cur,int cnt){ //들고있는 계란, 현재 깬 계란 수
        if(cur == N){
            //손에 든 계란이 가장 오른쪽
            ans = Math.max(ans,cnt);
            return;
        }
        //손에 든 계란이 깨져있으면 3으로 넘어감
        if(dur[cur] <= 0 ) {
            dfs(cur + 1, cnt);
            return;
        }

        boolean flag = false;

        for(int i=0;i<N;i++){
            //현재 들고있는 계란 스킵
            if(i == cur) continue;
            //이미 깨진 계란 스킵
            if(dur[i] <= 0 )continue;

            dur[i] -=wei[cur];
            dur[cur] -=wei[i];

            if(dur[cur] <= 0 && dur[i] <= 0){
                dfs(cur+1,cnt+2);
                flag = true;
            }
            else if(dur[cur] >0 && dur[i] > 0){
                dfs(cur+1,cnt);
                flag = true;
            }
            else {
                dfs(cur + 1, cnt + 1);
                flag = true;
            }
            //백트래킹
            dur[i] +=wei[cur];
            dur[cur] +=wei[i];
        }

        if(!flag)
            dfs(cur+1,cnt);
    }

}
