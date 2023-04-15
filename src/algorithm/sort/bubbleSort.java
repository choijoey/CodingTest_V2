package algorithm.sort;

import java.util.Arrays;

public class bubbleSort {
    public static int[] bubbleSort(int[] array){
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j]>array[j+1]){
                    //스왑
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {8, 1, 56, 4, 7, 1, 87, 0};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }
}
