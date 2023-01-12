package programmers;

import java.util.*;

public class programmers_17680 {

    //["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
    //  Jeju Pangyo Seoul 15
    // NewYork Pangyo Seoul 5
    // NY LA Seoul 5
    // NY LA Jeju 5
    // Pangyo LA Jeju 5
    // Pangyo Seoul Jeju 5
    // P S NY 5
    // LA S MY 5


    public int solution(int cacheSize, String[] cities) {

        HashMap<String,Integer> hashMap = new HashMap<>(cacheSize);

        int start = 0;
        int answer = 0;
        if(cacheSize == 0){
            answer = 5* cities.length;
            return answer;
        }
        for (String s: cities){
            s = s.toLowerCase(); //대소문자 구별 x
            //캐시에 값이 존재
            if(hashMap.containsKey(s)){
                hashMap.put(s,start);
                answer++;
            }
            //캐시에 값이 없음

            //캐시가 다 찼을 때
            else if(hashMap.size() == cacheSize){
                Integer i = cities.length; // 가장 사용되지 않은 인덱스
                String key=""; // 캐시에서 제외될 키값
                for(Map.Entry<String,Integer> entrySet : hashMap.entrySet()){
                    if(i > entrySet.getValue()){
                        i = entrySet.getValue();
                        key = entrySet.getKey();
                    }
                }
                hashMap.remove(key);
                hashMap.put(s,start);
                answer+=5;
            }
            //캐시가 다 안찼을 때
            else{
                hashMap.put(s,start);
                answer+=5;
            }
            start++;
        }

        return answer;
    }
}
