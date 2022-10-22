//https://school.programmers.co.kr/learn/courses/30/lessons/12921
//2022-10-22
//소수 찾기

package codingtest_practice.level1;

import java.util.*;

public class CountPrimeNumber {


    //solution1
    //HashSet 에 소수가 아닌 수 저장
    //효율성 테스트에서 시간초과
    public int solution1(int n) {
        int answer = n - 1;
        Set<Integer> notPrime = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (!notPrime.contains(i)) {
                int p = 2;
                while (p * i <= n) {
                    notPrime.add(p * i);
                    p++;
                }
            }
        }
        return answer - notPrime.size();
    }

    //solution2
    //자연수의 제곱근보다 작은 수 들로만 소수 검사
    //효율성 테스트 통과
    public int solution2(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) answer++;
        }
        return answer;
    }

    private boolean isPrime(int n) {
        int sq = (int) Math.sqrt(n);
        for (int i = 2; i <= sq; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
