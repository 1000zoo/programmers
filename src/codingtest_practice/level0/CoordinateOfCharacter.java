//2023-06-26
//https://school.programmers.co.kr/learn/courses/30/lessons/120861
//캐릭터의 좌표

package codingtest_practice.level0;

public class CoordinateOfCharacter {
    private int xMax;
    private int yMax;

    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0, 0};
        xMax = board[0] / 2;
        yMax = board[1] / 2;

        for (String key : keyinput) {
            answer = move(answer, key);
        }

        return answer;
    }

    private boolean isWithinBoundary(int[] sq) {
        return -1 * xMax <= sq[0] && sq[0] <= xMax && -1 * yMax <= sq[1] && sq[1] <= yMax;
    }

    private int[] move(int[] pos, String key) {
        int[] dir = keyDecoder(key);
        int x = pos[0] + dir[0];
        int y = pos[1] + dir[1];
        int[] next = new int[]{x, y};

        return isWithinBoundary(next) ? next : pos;
    }

    private int[] keyDecoder(String direction) {
        return direction.equals("up") ? new int[]{0, 1} :
                direction.equals("down") ? new int[]{0, -1} :
                direction.equals("left") ? new int[]{-1, 0} :
                direction.equals("right") ? new int[]{1, 0} : new int[]{0, 0};
    }
}
