package programmers;

import java.util.*;


public class programmers_121686 {


    public static long[] solution(int[][] program) {

        int size = program.length;
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0;i<size;i++){
            list.add(program[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return  o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                else
                    return o1[0]-o2[0];
            }
        });

        long[] point = new long[11]; //점수 배열
        int time = 0;

        for(int i=0;i<size;i++){
            int[] cur = list.get(i);
            if(time >= cur[1]){
                pq.offer(cur);
            }
            else if(pq.isEmpty()){
                pq.offer(cur);
            }
            else{ //시간이 현재 시간을 지났다면
                int[] past =pq.poll();
                if(time < past[1]){
                    time = past[1] + past[2];
                }
                else{
                    point[past[0]] += time - past[1];
                    time += past[2]; //현재시간 실행시간 만큼 경과
                }

                i--;
            }
        }

        while(!pq.isEmpty()){
            int[] past =pq.poll();
            if(time < past[1]){
                time = past[1] + past[2];
            }
            else{
                point[past[0]] += time - past[1];
                time += past[2]; //현재시간 실행시간 만큼 경과
            }
        }
        point[0] = time;

        return point;
    }

    public static void main(String[] args) {
        int[][] a = {{1,1,100}, {1,1,100}, {1,2,100}, {1,100,100}};
        solution(a);
    }
}
