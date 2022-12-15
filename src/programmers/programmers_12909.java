package programmers;

import java.util.Stack;

public class programmers_12909 {
    boolean solution(String s) {
        boolean answer = true;

        char[] li = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : li){

            if(c == '('){
                stack.push(c);

            }
            else{
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        if(!stack.isEmpty())
            return false;

        return answer;
    }
}
