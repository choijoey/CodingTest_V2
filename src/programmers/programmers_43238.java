package programmers;

import java.util.Arrays;

public class programmers_43238 {
    public long solution(int n, int[] times) {
        // n은 1 이상 1억 이하
        // 심사하는데 걸리는 시간 1 이상 1억 이하
        // 심사관 1 ~ 100,000

        // 시뮬을 돌린다 => n * 심사관 수 => 타임리밋
        // 최소 시간 ~ 최대 시간 사이의 값이 답
        // n =6 times = [7,10] 일때
        // 최소 7 ~ 최대 60
        // 이분탐색으로 시간을 찾고 맞는지 확인하면
        //  (1억^2) *log(1억^2) * 100,000 (맞는지 확인하는 시간)
        // 단순 비교보다 훨씬 빠르다

        Arrays.sort(times);

        long start = times[0];
        long end = times[times.length-1]*n;
        long answer = end;

        while(start<end){
            long mid = start + (end-start)/2;
            int cnt = 0;
            for(int time: times){
                cnt += mid/time;
            }

            if(cnt < n){
                start = mid+1;
            }
            else {
                end = mid - 1;
                answer = Math.min(mid,answer);
            }
        }


        return answer;
    }
}
