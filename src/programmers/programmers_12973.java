package programmers;

import java.util.Stack;

public class programmers_12973 {
    public static int solution(String s)
    {
        if(s.length() %2 != 0)
            return 0;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <arr.length ; i++) {
            char cur = arr[i];

            if(stack.isEmpty())
                stack.push(cur);
            else{
                if(stack.peek()== cur)
                    stack.pop();
                else
                    stack.push(cur);
            }
        }
        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        solution("baabaa");
    }
}
