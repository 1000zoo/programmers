//https://school.programmers.co.kr/learn/courses/30/lessons/17687
//2022-11-07
//N 진수 게임

package codingtest_practice.level2;

public class NDigitGame {

    //solution1
    //m은 참가한 총 인원, t는 미리 구해야할 숫자이므로,
    //게임이 진행되면서 말하게 될 숫자의 최대값은 m * t 보다 훨씬 작다.
    //그 숫자들을 모두 하나의 string 에 넣는 방식.
    //=> 실제로는 t 만큼의 숫자를 구하는데 저 정도로 큰 수까지 필요하진 않아서 비효율적일 것 같다.
    public String solution1(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int turn = p - 1;
        StringBuilder total = new StringBuilder();
        total.append(0);
        for (int i = 0; i < m * t; i++) {
            total.append(translate(i, n));
        }
        String tt = total.toString();

        for (int count = 0; count < t; count++, turn += m) {
            answer.append(tt.charAt(turn));
        }


        return answer.toString();
    }

    private String translate(int num, int n) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(over10(num % n));
            num /= n;
        }
        return sb.reverse().toString();
    }

    private char over10(int n) {
        return n >= 10 ? (char) ('A' + (n - 10)) : (char) ('0' + n);
    }
}
