//https://school.programmers.co.kr/learn/courses/30/lessons/84512
//2022-12-08
//모음 사전

package codingtest_practice.level2;

public class WordsMadeUpOfVowels {

    //수학적인 접근방식
    public int solution(String word) {
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            int ch = oneHotEncoding(word.charAt(i));
            answer += (weight(5 - i) * ch) + 1;
        }

        return answer;
    }

    private int weight(int digit) {
        int sum = 0;

        for (int i = 0; i < digit; i++) {
            sum += (int) Math.pow(5, i);
        }
        return sum;
    }

    private int oneHotEncoding(char c) {
        if (c == 'A') return 0;
        else if (c == 'E') return 1;
        else if (c == 'I') return 2;
        else if (c == 'O') return 3;
        else if (c == 'U') return 4;
        else return -1;
    }
}
