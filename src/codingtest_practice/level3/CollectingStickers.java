//2023-08-20
//https://school.programmers.co.kr/learn/courses/30/lessons/12971#
//스티커 모으기

package codingtest_practice.level3;

public class CollectingStickers {
    //https://school.programmers.co.kr/questions/49197 참고
    public int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];
        int answer = 0;

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        for (int i = 0; i < dp1.length; i++) {
            int temp = Math.max(dp1[i], dp2[i]);
            answer = Math.max(answer, temp);
        }

        return answer;
    }
}
