//2023-06-27
//https://school.programmers.co.kr/learn/courses/30/lessons/92334
//신고 결과 받기

package codingtest_practice.level1;

import java.util.*;

public class ReportedResults {

    private static class User {
        public String name;
        public Set<String> reportedSet;
        public int reportedCount;

        public User(String name) {
            this.name = name;
            this.reportedSet = new HashSet<>();
            this.reportedCount = 0;
        }

        public void reported() {
            this.reportedCount++;
        }

        public boolean addReport(String name) {
            if (this.reportedSet.contains(name)) {
                return false;
            }
            this.reportedSet.add(name);
            return true;
        }

        public boolean isBanned(int k) {
            return this.reportedCount >= k;
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, User> map = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (String id : id_list) {
            map.put(id, new User(id));
        }

        for (String r : report) {
            String from = r.split(" ")[0];
            String to = r.split(" ")[1];
            if (!map.containsKey(from) || !map.containsKey(to)) return null;
            if (map.get(from).addReport(to)) {
                map.get(to).reported();
            }
        }

        for (int i = 0; i < answer.length; i++) {
            String temp = id_list[i];
            User user = map.get(temp);
            int count = 0;

            for (String reported : user.reportedSet) {
                User reportedUser = map.get(reported);
                if (reportedUser.isBanned(k)) count++;
            }
            answer[i] = count;
        }

        return answer;
    }
}
