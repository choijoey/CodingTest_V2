package algorithm;

public class SubSet {

    static int total_cnt,N;
    static int[] input;
    static boolean[] isSelected;
    public static void subset(int cnt){
        if(cnt == N){
            total_cnt++;
            for (int i = 0; i < N; i++) {
                System.out.println((isSelected[i]? input[i] : "X")+" ");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);

        isSelected[cnt]=false;
        subset(cnt+1);
    }
}
