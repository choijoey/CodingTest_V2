package programmers;
import java.util.*;

public class programmers_12906 {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();

        int size = arr.length;

        int cur = -1;

        for(int i =0 ; i<size; i++ ){

            if(arr[i] == cur)
                continue;
            stack.push(arr[i]);
            cur =arr[i];
        }
        answer = new int[stack.size()];

        int idx = stack.size()-1;

        while(!stack.isEmpty()){
            answer[idx--] = stack.pop();
        }
        return answer;
    }
}
