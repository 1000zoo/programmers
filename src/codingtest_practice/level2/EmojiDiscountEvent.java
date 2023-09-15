//2023-09-16
//https://school.programmers.co.kr/learn/courses/30/lessons/150368
//이모티콘 할인행사

package codingtest_practice.level2;

import java.util.*;

public class EmojiDiscountEvent {

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] discounts = new int[emoticons.length];

        Arrays.fill(discounts, 10);

        while (discounts != null) {
            int[] price = currPrice(emoticons, discounts);
            int totalUser = 0;
            int totalPrice = 0;

            for (int[] user : users) {
                int per = 0;
                for (int i = 0; i < price.length; i++) {
                    if (discounts[i] >= user[0]) per += price[i];
                }
                if (per >= user[1]) totalUser++;
                else totalPrice += per;
            }

            if (answer[0] < totalUser) {
                answer[0] = totalUser;
                answer[1] = totalPrice;
            } else if (answer[0] == totalUser) {
                answer[1] = Math.max(totalPrice, answer[1]);
            }

            discounts = getNext(discounts);
        }

        return answer;
    }

    private int[] currPrice(int[] emo, int[] dis) {
        int[] price = new int[emo.length];
        for (int i = 0; i < price.length; i++) price[i] = (emo[i] * (100 - dis[i])) / 100;
        return price;
    }

    private int[] getNext(int[] curr) {

        int[] next = new int[curr.length];
        System.arraycopy(curr, 0, next, 0, next.length);

        next[0] += 10;
        for (int i = 0; i < next.length - 1; i++) {
            if (next[i] > 40) {
                next[i] = 10;
                next[i + 1] += 10;
            }
        }

        if (next[next.length - 1] > 40) return null;
        return next;
    }
}
