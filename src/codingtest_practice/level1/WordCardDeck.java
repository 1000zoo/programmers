//2023-02-16
//https://school.programmers.co.kr/learn/courses/30/lessons/159994
//카드 뭉치

package codingtest_practice.level1;

public class WordCardDeck {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0, index2 = 0;

        for (String word : goal) {
            String word1 = index1 < cards1.length ? cards1[index1] : "";
            String word2 = index2 < cards2.length ? cards2[index2] : "";

            if (word1.equals(word)) {
                index1++;
            } else if (word2.equals(word)) {
                index2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
