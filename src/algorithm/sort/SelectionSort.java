package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {


    //현재 위치에 들어갈 데이터를 찾아 선택하는 알고리즘

    // 주어진 리스트에서 최솟값을 찾는다
    // 최솟값을 맨 앞 자리의 값과 교환한다
    // 맨 앞자리를 제외한 나머지 값들 중 최솟값을 찾아 위와 같은 방법으로 반복한다.


    //장점 : 추가적인 메모리 소비가 적다
    //단점 : 시간복잡도가 O(N^2)이다. 안정 정렬이 아니다.

    public static void main(String[] args) {

        int[] array = new int[]{1, 8, 54, 9, 65, 1, 100, 0, 45};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array){

        for (int i = 0; i < array.length -1; i++) {
            int min_index = i;

            //최솟값을 갖고 있는 인덱스 찾기
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[min_index])
                    min_index = j;
            }

            swap(array,min_index,i);
        }


    }
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
