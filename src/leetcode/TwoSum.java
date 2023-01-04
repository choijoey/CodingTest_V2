package leetcode;

// 배열에서 두 수를 골라 합이 target과 같은지 찾는 문제
// 해결 방법이 바로 떠오르지 않아 브루트 포스 방식으로 접근했다.
// 순열로 문제를 해결했기 때문에 O(N^2) 의 시간복잡도를 가진다

public class TwoSum {

        static int[] num;
        static int[] cur;
        static int[] ans;

        public int[] twoSum(int[] nums, int target) {
            num = nums;
            cur = new int[2];

            dfs(0,0,target);
            return cur;
        }

        public boolean dfs(int cnt, int start,int target){
            if(cnt == 2){
                int sum = num[cur[0]] + num[cur[1]];
                if(sum == target){
                    return true;
                }
                return false;
            }
            int size= num.length;

            for(int i=start; i<size;i++ ){
                cur[cnt] = i;
                if(dfs(cnt+1,i+1,target))
                    return true;
            }
            return false;
        }
}
