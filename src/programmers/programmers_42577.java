package programmers;

import java.util.*;
public class programmers_42577 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book);
        for(String s : phone_book){
            int size = s.length();
            boolean flag = true;

            StringBuilder sb = new StringBuilder();
            for(int i =0; i<size;i++){
                sb.append(s.charAt(i));
                if(set.contains(sb.toString())){
                    return false;
                }
            }
                set.add(s);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
