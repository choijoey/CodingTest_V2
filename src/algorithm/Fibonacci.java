package algorithm;

import java.util.ArrayList;

public class Fibonacci {

    // 반복문 시간복잡도 O(N)
    // 재귀 시간복잡도 O(2^N)
    static int fibonacciIterative(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);

        for(int i =2;i<=n;i++){
            arr.add(arr.get(i-2)+arr.get(i-1));
        }
        return arr.get(n);
    }

    static int fibonacciIterativeRecursive(int n){
        if(n < 2){
            return n;
        }
        return fibonacciIterativeRecursive(n-1) +fibonacciIterativeRecursive(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciIterativeRecursive(8));
        System.out.println(fibonacciIterative(8));
    }

}
