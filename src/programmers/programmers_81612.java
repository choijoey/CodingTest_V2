package programmers;

public class programmers_81612 {
    class Solution {
        public long solution(int price, int money, int count) {
            long answer = -1;
            answer = -(long)(money-(long)(count)*(count+1)/2*price);
            if(answer<0)
                return 0;

            return answer;
        }
    }
}
