//https://school.programmers.co.kr/learn/courses/30/lessons/92335
//2022-10-24
//k 진수에서 소수 찾기

package codingtest_practice.level2;

public class PrimeNumberBinaryToDecimal {
    public int solution(int n, int k) {
        int answer = 0;
        String[] numList = toK(n, k).split("0");
        for (String s : numList) {
            if (!s.equals("")) {
                answer = isPrime(Long.parseLong(s)) ? answer += 1 : answer;
            }
        }
        return answer;
    }

    private String toK(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPrime(long n) {
        if (n == 1) return false;
        for (long i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
