package programmers;

import java.util.Arrays;
import java.util.Collections;

public class programmers_12941 {

    //값이 최소가 되게 하려면
    //1. 브루트 포스?
    //2. 두 배열을 정렬시켜서 최소 * 최대 를 더하면 최소값이 나올듯

    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int size = A.length;

        for (int i = 0; i < size; i++) {
            answer+= A[i]*B[size-1-i];
        }

        return answer;
    }
}
