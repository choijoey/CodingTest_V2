package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_42587 {

    public static int solution(int[] priorities, int location) {
        int[] prior = new int[10];

        Queue<int[]> queue = new LinkedList<>();
        int size = priorities.length;

        for(int i =0; i<size;i++){
            prior[priorities[i]]++; //우선순위 개수 파악
            queue.offer(new int[]{priorities[i],i});
        }

        int curLocation = -1; //현재 작업
        int cnt = 0;
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            boolean flag = true; // 현재 뽑은 작업보다 중요도가 높은 작업이 있는지 파악
            for (int i = 9; i >=tmp[0]+1; i--) {
                if(prior[i] >0){
                    flag =false;
                    break;
                }
            }
            if(flag){
                curLocation = tmp[1];
                cnt++;
                prior[tmp[0]]--;
            }
            else {
                queue.offer(tmp);
            }
            if(curLocation == location)
                break;
        }



        int answer = cnt;
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1,1,9,1,1,1},0);
    }
}
