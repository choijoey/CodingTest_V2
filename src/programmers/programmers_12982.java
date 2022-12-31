package programmers;

import java.util.Arrays;
import java.util.Collections;

public class programmers_12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        int idx =0;
        while(budget>0){
            if(idx == d.length)
                break;
            if(budget-d[idx] <0)
                break;
            budget-=d[idx++];
            answer++;
        }
        return answer;
    }
}
