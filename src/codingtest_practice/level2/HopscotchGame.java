//https://school.programmers.co.kr/learn/courses/30/lessons/12913
//2022-11-13
//땅따먹기

package codingtest_practice.level2;

public class HopscotchGame {
    public int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int temp = land[i][j];
                for (int k = 0; k < land[i].length; k++) {
                    if (j != k) {
                        land[i][j] = Math.max(
                                land[i - 1][k] + temp, land[i][j]
                        );
                    }
                }
            }
        }
        int answer = -1;
        for (int score : land[land.length - 1]) {
            answer = Math.max(answer, score);
        }
        return answer;
    }
}
