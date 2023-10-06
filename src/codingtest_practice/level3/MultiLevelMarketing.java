//2023-10-07
//https://school.programmers.co.kr/learn/courses/30/lessons/77486
//다단계 칫솔 판매

package codingtest_practice.level3;

import java.util.*;

public class MultiLevelMarketing {
    private Map<String, Seller> sellerMap;

    private class Seller {
        private String name;
        private Seller parent;
        private int profit;

        public Seller(String name, Seller parent) {
            this.name = name;
            this.parent = parent;
            this.profit = 0;
        }

        public void addProfit(int amount) {
            int fee = amount / 10;
            this.profit += (amount - fee);
            if (this.parent != null && fee > 0) {
                this.parent.addProfit(fee);
            }
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        sellerMap = new HashMap<>();
        sellerMap.put("center", new Seller("center", null));

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            String refer = referral[i].equals("-") ? "center" : referral[i];
            sellerMap.put(name, new Seller(name, sellerMap.get(refer)));
        }

        for (int i = 0; i < seller.length; i++) {
            Seller currentSeller = sellerMap.get(seller[i]);
            currentSeller.addProfit(amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellerMap.get(enroll[i]).profit;
        }

        return answer;
    }
}
