package programmers;

import java.util.ArrayList;

public class programmers_42586 {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> list = new ArrayList<>();

        int size  = progresses.length;

        int day = 1;
        int done = 0;

        for(int i=0; i< size ;i++ ){

            if(progresses[i] + speeds[i] * day >= 100){
                done++;
                continue;
            }

            if(progresses[i] + speeds[i] * day < 100 && done != 0 ){
                list.add(done);
                done = 0;
            }

            while(progresses[i] + speeds[i] * day < 100){
                day++;
            }
            done++;
        }
        list.add(done);

        int[] answer = new int[list.size()];

        for(int i =0; i< list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
