package algorithm.sort;

public class InsertionSort {
    //삽입 정렬(Insertion Sort)는 현재 비교하고자 하는 target과 그 이전의 원소들을 비교하며 자리를 교환하는 정렬 방법이다.
    //제자리 정렬(inplace sort)이며 안정 정렬이다.

    //방법
    // 1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (첫 번째 타겟은 두 번째 원소부터 시작한다.)
    // 2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다.
    // 3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.

    public static void insertion_sort(int[] a){

        for (int i = 1; i < a.length; i++) {

            int target = a[i];

            int j = i-1;

            while(j>= 0 && target < a[j]){
                a[j+1] = a[j]; // 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }


            //위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
            // 타겟 원소는 j번째 원소 뒤에 와야한다.
            // 그러므로 타겟은 j + 1 에 위치하게 된다.

            a[j+1] = target;
        }
    }
}
