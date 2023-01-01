package programmers;

import java.util.Arrays;

public class programmers_142086 {
    public int[] solution(String s) {
        int size = s.length();
        int[] answer = new int[size];//정답
        int[] alphabet = new int[26]; //알파벳 위치
        Arrays.fill(alphabet,-1);

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            int idx = (int)(c-'a');

            if(alphabet[idx]  == -1) {
                answer[i] = -1;
                alphabet[idx] = i;
            }
            else{
                answer[i] = alphabet[idx]- i;
                alphabet[idx] = i;
            }
        }

        return answer;
    }
}
