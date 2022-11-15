//https://school.programmers.co.kr/learn/courses/30/lessons/132267
//2022-11-15
//콜라문제

package codingtest_practice.level1;

public class EmptyBottleBonus {
    public int solution(int empty, int bonus, int bottle) {
        int answer = 0;

        while (bottle >= empty) {
            answer += getBonus(empty, bonus, bottle);
            bottle = currBottle(empty, bonus, bottle);
        }

        return answer;
    }

    private int getBonus(int empty, int bonus, int bottle) {
        return (bottle / empty) * bonus;
    }

    private int currBottle(int empty, int bonus, int bottle) {
        return getBonus(empty, bonus, bottle) + bottle % empty;
    }
}
