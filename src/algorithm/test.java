package algorithm;

import java.util.ArrayList;
import java.util.List;

public class test {
    class Tmp{
        int a;
        int b;
        Tmp(int a,int b){
            this.a = a;
            this.b = b;
        };
    }
    public static void main(String[] args) {

    }
    boolean bst(int[] array, int key){
        int length = array.length;
        int low = 0;
        int high = length -1;
        while(low <= high){
            int mid = low+(high -low)/2;
            int cur = array[mid];

            if(cur == key)
                return true;
            else if(cur < key)
                low = mid+1;
            else
                high = mid -1;
        }
        return false;
    }
    static int N,R;
    static int[] input,numbers;
    static boolean[] isSelected;
    void permu(int cnt){
        if(cnt == R){
            String s = new String();
            return;
        }
        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            input[i] = numbers[i];
            permu(cnt+1);
            isSelected[i] = false;

        }
    }

    void comb(int cnt,int start){
        if(cnt == R)
            return;
        for (int i = start; i < N; i++) {
            input[cnt] = numbers[i];
            comb(cnt+1,i+1);
        }
    }

    void subSet(int cnt){
        if(cnt == N)
            return;

        isSelected[cnt] = true;
        subSet(cnt+1);
        isSelected[cnt] = false;
        subSet(cnt+1);
    }

    static int[] parents;

    public static void makeSet(){
        parents = new int[N];

        for(int i=0; i<N;i++){
            parents[i] = i;
        }
    }
    public static int findSet(int a){
        if(a==parents[a])
            return a;
        return parents[a] = findSet(parents[a]);
    }
    public static boolean union(int a, int b){
         a = findSet(a);
         b= findSet(b);

        if(a == b)
            return false;
        parents[b] = a;
        return true;
    }
}
