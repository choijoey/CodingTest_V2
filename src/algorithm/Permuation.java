package algorithm;

public class Permuation {

    static int N,R;
    //nPr
    static int[] input,numbers;
    //input : 입력 수 배열
    //numbers : 선택 수 배열
    static boolean[] isSelected;

    public static void permutation(int cnt){
        //cnt : 직전까지 뽑은 수의 개수

        if(cnt == R){ //가지치기 역할
            System.out.println(numbers.toString());
            return;
        }

        // 입력받은 모든 수를 현재 자리에 넣어보기
        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            numbers[cnt]= input[i];
            isSelected[i] = true;

            permutation(cnt+1);
            isSelected[i] = false; //백트래킹
        }
    }
}
