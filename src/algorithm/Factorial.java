package algorithm;

public class Factorial {

    //시간 복잡도: O(N)

    static int findFactorialRecursive(int number){
        if(number<=2)
            return number;
        return number*findFactorialRecursive(number-1);
    }

    static int findFactorialIterative(int number){
        if(number<=2)
            return number;
        int ans=1;
        for (int i = 2; i <= number; i++) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findFactorialRecursive(2));
        System.out.println(findFactorialIterative(2));
    }
}
