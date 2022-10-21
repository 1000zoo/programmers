//https://school.programmers.co.kr/learn/courses/30/lessons/12938
//2022-10-22
//최고의 집합

package codingtest_practice.level3;

public class BestSet {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int originN = n;
        for (int i = 0; i < originN; i++) {
            answer[i] = s / n;
            s -= s / n;
            n--;
        }
        return answer;
    }
}
