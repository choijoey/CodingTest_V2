package programmers;

import java.util.*;

class programmers_1845 {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {

            if (set.size() == cnt)
                break;

            if (!set.contains(i)) {
                set.add(i);
                answer++;
            }
        }

        return answer;
    }
}