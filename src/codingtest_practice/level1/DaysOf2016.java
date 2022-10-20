//https://school.programmers.co.kr/learn/courses/30/lessons/12901
//2022-10-20
//2016년의 요일 맞추기

package codingtest_practice.level1;

public class DaysOf2016 {
    public String solution(int a, int b) {
        String[] week = new String[] {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for (int i = 0; i < a - 1; i++) {
            totalDays += days[i];
        }
        totalDays += b - 1;

        return week[totalDays % week.length];
    }
}
