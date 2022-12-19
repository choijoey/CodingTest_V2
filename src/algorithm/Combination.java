package algorithm;

import java.util.Arrays;

public class Combination {
    static int N,R;
    static int[] input, numbers;

    public static void combination(int cnt,int start){
        if(cnt == R){
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 일반적으로 visited[]을 사용하여 idx로 접근하자!
        // 선택한 다음 수부터 선택하니까 중복체크 X

        for (int i = start; i <N ; i++) {
            numbers[cnt] = input[i];
            combination(cnt+1,i+1);
            //start+1이 아니라 i+1 임을 주의!!!!
        }
    }
}
