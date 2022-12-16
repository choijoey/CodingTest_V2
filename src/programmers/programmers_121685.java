package programmers;

import java.util.Stack;

public class programmers_121685 {
    public String[] solution(int[][] queries) {

        int len = queries.length;
        String[] answer = new String[len];

        int num =0;

        for(int i =0; i<len; i++){
            answer[num++] = cal(queries[i][0],queries[i][1]);
        }

        return answer;
    }

    public String cal(int n, int p){

        Stack<Integer> stack = new Stack<>();

        while(n>=1){
            stack.push(p%4);
            n -= 1;
            p/=4;
        }

        while(!stack.isEmpty()){
            int num = stack.pop();

            if(num == 0)
                return "RR";
            else if(num ==3)
                return "rr";
        }
        return "Rr";
    }
}
