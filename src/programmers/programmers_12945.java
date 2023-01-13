package programmers;

public class programmers_12945 {
    public int solution(int n) {
        int num1 = 0; //F0
        int num2 = 1; //F1
        int tmp = -1;

        for(int i = 2  ; i <= n; i++){
            num1 = (num1 +num2)%1234567;
            tmp = num2;
            num2 = num1;
            num1 = tmp;
        }


        return num2;
    }
}
