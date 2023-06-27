//2023-06-27
//https://school.programmers.co.kr/learn/courses/30/lessons/67256
//키패드 누르기

package codingtest_practice.level1;

public class PressKeypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int recentL = 10;
        int recentR = 12;

        for (int num : numbers) {
            if (num % 3 == 1) {
                answer.append("L");
                recentL = num;
            } else if (num % 3 == 0 && num != 0) {
                answer.append("R");
                recentR = num;
            } else {
                String temp = whichHand(recentL, recentR, num, hand);
                answer.append(temp);
                if (temp.equals("L")) recentL = num;
                else recentR = num;
            }
        }

        return answer.toString();
    }

    private String whichHand(int recentL, int recentR, int curr, String hand) {
        int dl = getDistance(recentL, curr);
        int dr = getDistance(recentR, curr);
        return dl == dr ? isLeftHanded(hand) ? "L" : "R" :
                dl < dr ? "L" : "R";
    }

    private int getDistance(int recent, int curr) {
        recent = recent == 0 ? 11 : recent;
        curr = curr == 0 ? 11 : curr;
        int c = recent % 3 == 2 ? 0 : 1;
        recent = ((recent - 1) / 3) * 3 + 2;

        return c + Math.abs(recent - curr) / 3;
    }

    private boolean isLeftHanded(String hand) {
        return hand.equals("left");
    }
}
