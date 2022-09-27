//https://school.programmers.co.kr/learn/courses/30/lessons/12941
//2022-09-27
//최솟값 만들기

package codingtest_practice.level2;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class GeneratingMinimumValue {

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        ArrayList<Integer> Aal = new ArrayList<>();
        ArrayList<Integer> Bal = new ArrayList<>();

        for (int a : A) {
            Aal.add(a);
        }
        for (int b : B) {
            Bal.add(b);
        }
        Aal.sort(Comparator.naturalOrder());
        Bal.sort(Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            answer += (Aal.get(i) * Bal.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 5, 6};
        int[] B = {2, 5, 8, 4};
        int minSumOfMultiples = solution(A, B);
    }
}
