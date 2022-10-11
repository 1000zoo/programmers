//https://school.programmers.co.kr/learn/courses/30/lessons/42842
//2022-10-11
//카펫

package codingtest_practice.level2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int row = 0;
        int col = 0;

        for (int i = 2; i < total / 2; i++) {
            if (total % i == 0) {
                if ((i + total / i - 2) * 2 == brown) {
                    answer[0] = Math.max(i, total / i);
                    answer[1] = Math.min(i, total / i);
                }
            }
        }

        return answer;
    }
}
