package programmers;

import java.util.Collection;
import java.util.HashMap;

public class programmers_42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();

        int len = clothes.length;

        for (String[] s : clothes){
            if(map.containsKey(s[1])){
                int cur = map.get(s[1]);
                map.put(s[1],cur+1);
            }
            else
                map.put(s[1],1);
        }
        for(int i : map.values()){
            answer *= (i+1);
        }

        return answer-1;
    }

}
