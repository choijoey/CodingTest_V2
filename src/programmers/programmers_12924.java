package programmers;

public class programmers_12924 {
    public int solution(int n) {
        int answer = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {

            for (int j = i; j < n; j++) {
                sum += j;
                if(sum == n)
                    answer++;
                else if (sum > n) {
                    break;
                }
            }
            sum = 0;
        }
        return answer;
    }
}
