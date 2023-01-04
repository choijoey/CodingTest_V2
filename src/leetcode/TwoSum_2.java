package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_2 {
    // LeetCode의 솔루션을 보고 해쉬를 사용하는 방법으로 문제를 접근해봤다.
    // 배열의 각 요소와 해당 인덱스의 매핑을 유지하는 가장 좋은 방법 => Hash Table
    // 시간복잡도 O(n) - 배열을 한번만 탐색한다.
    // 공간복잡도 O(n) - 해쉬테이블을 만들기 위해 n의 공간을 차지한다.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int size= nums.length;

        for (int i = 0; i < size; i++) {
            int cur = target - nums[i];
            if(map.containsKey(cur)){
                return new int[]{map.get(cur),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
