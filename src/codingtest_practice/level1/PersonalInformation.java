//2023-03-28
//https://school.programmers.co.kr/learn/courses/30/lessons/150370
//개인정보 수집 유효기간

package codingtest_practice.level1;

public class PersonalInformation {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        System.out.println(dateToInteger(today));
        return answer;
    }

    private int dateToInteger(String date) {
        System.out.println(date);
        String[] temp = date.split("\\.");
        int[] ymd = new int[3];
        for (int i = 0; i < 3; i++) ymd[i] = Integer.parseInt(temp[i]);

        return (ymd[0] - 2000) * (12 * 28) + ymd[1] * 28 + ymd[2];
    }
}
