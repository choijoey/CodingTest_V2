package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    // 두 개의 인접한 원소를 비교하여 정렬하는 방식
    // 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 하지 않기 때문에 제자리 정렬(inplace sort)이다

    //장점: 추가적인 메모리 소비가 적다, 구현이 매우 쉽다, 안정 정렬이 가능하다 ( 안정 정렬: 중복된 값을 입력 순서와 동일하게 정렬하는 알고리즘 )
    //단점: 최악의 경우 O(N^2)이라는 시간복잡도

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
