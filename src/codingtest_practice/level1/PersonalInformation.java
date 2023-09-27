//2023-03-28 (새로운 풀이: 2023-09-27)
//https://school.programmers.co.kr/learn/courses/30/lessons/150370
//개인정보 수집 유효기간

package codingtest_practice.level1;

import java.util.*;

public class PersonalInformation {

    // new solution
    private class Client {
        private int validationDays;
        private Date collectedDate;
        private Date expireDate;

        public Client(String date, int validationDays) {
            this.collectedDate = new Date(date);
            this.validationDays = validationDays;
            this.expireDate = collectedDate.afterDays(this.validationDays);
        }

        public boolean isExpired(Date today) {
            return today.compare(this.expireDate) >= 0;
        }
    }

    private class Date {
        private int year;
        private int month;
        private int day;

        public Date(String date) {
            String[] split = date.split("\\.");
            this.year = Integer.parseInt(split[0]);
            this.month = Integer.parseInt(split[1]);
            this.day = Integer.parseInt(split[2]);
        }
        public Date(Date date) {
            this.year = date.year;
            this.month = date.month;
            this.day = date.day;
        }

        public int compare(Date date) {
            if (this.year != date.year) {
                return this.year - date.year;
            }
            if (this.month != date.month) {
                return this.month - date.month;
            }
            return this.day - date.day;
        }

        public Date afterDays(int month) {
            Date date = new Date(this);
            date.month += month;
            date.year += date.month % 12 == 0 ? (date.month / 12) - 1 : date.month / 12;
            date.month %= 12;
            if (date.month == 0) date.month = 12;

            return date;
        }

        public String toString() {
            return this.year + "." + this.month + "." + this.day;
        }
    }

    public int[] newSolution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        Date t = new Date(today);
        List<Integer> answer = new ArrayList<>();

        for (String term : terms) {
            String[] temp = term.split(" ");
            termMap.put(temp[0], Integer.parseInt(temp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            Client client = new Client(temp[0], termMap.get(temp[1]));
            if (client.isExpired(t)) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    // ==============================================================================


    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int todayInteger = dateToInteger(today);
        for (String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]) * 28);
        }

        for (int i = 0; i < privacies.length; i++) {
            int date = dateToInteger(privacies[i].split(" ")[0]);
            int tm = map.get(privacies[i].split(" ")[1]);

            if (date + tm <= todayInteger) answer.add(i + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int dateToInteger(String date) {
        String[] temp = date.split("\\.");
        int[] ymd = new int[3];
        for (int i = 0; i < 3; i++) ymd[i] = Integer.parseInt(temp[i]);

        return (ymd[0] - 2000) * (12 * 28) + ymd[1] * 28 + ymd[2];
    }
}
