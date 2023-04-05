package programmers;

import java.util.Arrays;

public class programmers_42885 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;

        int l = 0;
        int r = people.length-1;

        while(l<r){


            if(people[l]+people[r] <= limit){
                answer++;
                l++;
                r--;
            }
            else {
                answer ++;
                r--;
            }

        }
        if(l == r)
            answer ++;
        return answer;

    }
}
