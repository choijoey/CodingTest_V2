package programmers;

public class programmers_121683 {
    public String solution(String input_string) {

        char[] input = input_string.toCharArray();

        boolean[] v = new boolean[26]; //이미 나온 알파벳인지 확인
        boolean[] ans = new boolean[26]; //정답

        char past = input[0]; // 첫번째 원소
        v[past-'a'] = true;

        int size = input.length;

        for (int i = 1; i < size; i++) {
            char cur = input[i];

            if(past != cur && v[cur-'a']){
                ans[cur-'a'] = true;
            }
            past = cur;
            v[cur-'a'] = true;
        }

        StringBuilder sb  = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if(ans[i]){
                sb.append((char)(i+'a'));
            }
        }

        String answer = "";
        if(sb.length() == 0)
            answer = "N";
        else
            answer = sb.toString();

        return answer;
    }
}
