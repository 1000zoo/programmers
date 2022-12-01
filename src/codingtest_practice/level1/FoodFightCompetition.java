//https://school.programmers.co.kr/learn/courses/30/lessons/134240
//2022-12-01
//푸드파이트대회

package codingtest_practice.level1;

public class FoodFightCompetition {

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            String temp = "" + i;
            temp = temp.repeat(food[i] / 2);
            sb.append(temp);
        }
        String answer = sb.toString();
        sb.append(0);
        sb.reverse();
        answer += sb.toString();

        return answer;
    }
}
