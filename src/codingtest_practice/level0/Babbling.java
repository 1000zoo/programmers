//2023-05-18
//https://school.programmers.co.kr/learn/courses/30/lessons/120956
//옹알이(1)

package codingtest_practice.level0;

public class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};

        for (String bab : babbling) {
            int length = 0;
            for (String p : possible) {
                if (bab.indexOf(p) != -1) length += p.length();
            }
            if (bab.length() == length) answer++;
        }

        return answer;
    }
}
