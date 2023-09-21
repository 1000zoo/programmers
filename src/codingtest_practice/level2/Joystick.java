//2023-09-21
//https://school.programmers.co.kr/learn/courses/30/lessons/42860#
//조이스틱

package codingtest_practice.level2;

public class Joystick {

    public int solution(String name) {
        int answer = 0;

        for (char c : name.toCharArray()) {
            answer += minDiff(c);
        }

        return answer + lrMoves(name);
    }

    private int lrMoves(String name) {
        int moves = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            int index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }
            moves = Math.min(moves, i * 2 + name.length() - index);
            moves = Math.min(moves, (name.length() - index) * 2 + i);
        }

        return moves;
    }

    private int modIndex(int length, int index) {
        return (length + index) % length;
    }

    private int minDiff(char to) {
        return Math.min(to - 'A', 26 - (to - 'A'));
    }
}
