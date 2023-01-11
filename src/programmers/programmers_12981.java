package programmers;

import java.util.HashSet;

public class programmers_12981 {
    public static int[] solution(int n, String[] words) {

        char st,end;
        int person = 0;
        int round = 1;

        end = words[0].charAt(0);
        HashSet<String> hashSet = new HashSet<>();
        boolean flag = true;

        for (String word: words){
            st = word.charAt(0);
            if(st != end) {
                flag =false;
                break; //정답이 아니면
            }
            if(hashSet.contains(word)){
                flag = false;
                break; //이미 누가 말한 단어면
            }
            hashSet.add(word);
            person++;
            if(person == n){
                person%=n;
                round++;
            }
            end = word.charAt(word.length()-1);
        }
        if(flag)
            return new int[]{0,0};
        else
            return new int[]{person+1,round};

    }

    public static void main(String[] args) {
        solution(	3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
}
