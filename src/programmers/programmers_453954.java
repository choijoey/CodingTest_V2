package programmers;

public class programmers_453954 {
    public int solution(int n) {
        if(n %2  != 0)
            return 0;

        int[] dp = new int[5001];

        dp[0]=1;
        dp[2]=3;

        for (int i = 4; i <n ; i+=2) {
            dp[i] = dp[i-2]*3;
            for (int j = i-4; j >=0 ; j-=2) {
                dp[i] +=dp[j]*2;
                dp[i]%=1000000007;
            }
        }
        return dp[n];
    }
}
