package programmers;

public class programmers_121684 {

    static int row,size,max,col;
    static int[] arr;
    static boolean[] v;

    public static int solution(int[][] ability) {

        row = ability.length;
        col = ability[0].length;
        arr = new int[col];
        v = new boolean[row];

        permu(0,ability);
        return max;
    }

    public static void permu(int cnt, int[][] ability){
        if(cnt == size){

            int tmp=0;
            for(int i=0;i < col;i++){
                tmp+=ability[arr[i]][i];
            }
            max = Integer.max(max,tmp);
            return;
        }

        for(int i=0; i < size; i++){
            if(v[i]) continue;

            arr[cnt]  = i;
            v[i] = true;
            permu(cnt+1,ability);
            v[i] = false;

        }
    }

    public static void main(String[] args) {
        int[][] d ={{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        solution(d);
    }
}
