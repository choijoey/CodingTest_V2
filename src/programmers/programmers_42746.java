package programmers;

import java.util.*;

public class programmers_42746 {

    public static String solution(int[] numbers) {

        int size = numbers.length;
        String[] strings = new String[size];

        for (int i = 0; i < size; i++) {
            strings[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strings,(o1,o2)->-((o1+o2).compareTo(o2+o1)));
        if(strings[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strings){
            sb.append(s);
        }
        String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 33, 34, 5, 9}));

    }
}
