package programmers;

import java.util.*;
import java.util.TreeMap;

public class programmers_42579 {



        static class Album implements Comparable<Album>{
            int num;
            int plays;

            public Album(int num, int plays) {
                this.num = num;
                this.plays = plays;
            }

            @Override
            public int compareTo(Album o) {
                if(this.plays == o.plays)
                    return this.num - o.num;
                else
                    return -(this.plays - o.plays);
            }
        }
        static class Albums{
            int a;
            ArrayList<Album> albums = new ArrayList<>();

        }
        public static int[] solution(String[] genres, int[] plays) {
            ArrayList<Integer> answer = new ArrayList<>();

            Map<String,Integer> map = new HashMap<>();

            int size = genres.length;
            int genreCnt=0;
            for(int i=0; i<size ;i++){
                String s = genres[i];
                if(!map.containsKey(s)){
                    map.put(s,genreCnt++);
                }
            }

            int[][] genrePlay = new int[genreCnt][2];
            Albums[] a = new Albums[genreCnt];
            for(int i=0; i<genreCnt;i++){
                a[i] =new Albums();
            }
            for(int i  =0;i<size;i++ ){
                int idx = map.get(genres[i]);
                genrePlay[idx][1] += plays[i];
                genrePlay[idx][0] = idx;
                a[idx].albums.add(new Album(i,plays[i]));
            }
            Arrays.sort(genrePlay, (o1, o2) ->(-(o1[1]-o2[1])));

            for(int i=0; i<genreCnt;i++){
                Collections.sort(a[i].albums);
            }
            for(int i=0; i<genreCnt;i++){
                int idx = genrePlay[i][0];

                if(a[idx].albums.size() == 1){
                    answer.add(a[idx].albums.get(0).num);
                }
                else{
                    answer.add(a[idx].albums.get(0).num);
                    answer.add(a[idx].albums.get(1).num);
                }
            }

            int[] ret = new int[answer.size()];
            for (int i=0; i < ret.length; i++)
            {
                ret[i] = answer.get(i).intValue();
            }
            return ret;
        }

        public static void main(String[] args) {
            solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        }


}
