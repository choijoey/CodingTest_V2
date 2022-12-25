package algorithm;

public class BinarySearch {
    boolean binarySearchIterative(int[] array, int key){
        int length = array.length;
        int low = 0;
        int high = length -1;

        while(low <= high){
            int mid = low+ (high - low)/2;
                //mid를 어렇게 계산하는 이유는 범위가 클 경우 l+r을 할 시에
                //오버플로우가 일어날 수도 있기 때문에 이를 방지하기 위해서이다.
            int curruent = array[mid];
            if(curruent == key)
                return true;
            else if(curruent<key){
                low = mid +1;
            }
            else
                high = mid -1;
        }
        return false;
    }
}
