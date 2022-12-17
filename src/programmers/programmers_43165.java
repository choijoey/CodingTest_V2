package programmers;

public class programmers_43165 {
    static int size;
    static boolean[] v;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        dfs(0,numbers,target,0);
        return answer;
    }

    public void dfs(int cnt,int[]numbers, int target,int num){
        if(cnt == size){
            if(num == target){
                answer++;
            }
            return;
        }
        num += numbers[cnt];
        dfs(cnt+1,numbers,target,num);
        num -= (numbers[cnt]*2);
        dfs(cnt+1, numbers, target, num);
        num += numbers[cnt];
    }
}
