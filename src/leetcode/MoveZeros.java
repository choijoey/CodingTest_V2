package leetcode;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int idx =0;
        int cnt =0; //0 개수

        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == 0)
                cnt++;
            else
                nums[idx++] = nums[i];
        }
        for (int i = 0; i < cnt; i++) {
            nums[idx++] = 0;
        }

    }
}
