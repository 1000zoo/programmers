//https://school.programmers.co.kr/learn/courses/30/lessons/42888
//2022-10-31
//오픈 채팅방

package codingtest_practice.level2;

import java.util.*;

public class OpenChat {
    //id, name
    Map<String, String> users = new HashMap<>();
    //{id} + {0 or 1}
    List<String> logs = new ArrayList<>();

    public String[] solution(String[] record) {

        List<String> answer = new ArrayList<>();

        for (String re : record) {
            processor(re);
        }

        for (String log : logs) {
            String[] temp = log.split(" ");
            String name = users.get(temp[0]);
            String type = temp[1];
            if (type.equals("1")) {
                name += "님이 들어왔습니다.";
            } else {
                name += "님이 나갔습니다.";
            }
            answer.add(name);
        }
        return answer.toArray(new String[0]);
    }

    private void processor(String record) {
        String[] info = record.split(" ");
        if (info[0].equals("Leave")) {
            logs.add(info[1] + " " + 0);
            return;
        }
        users.put(info[1], info[2]);
        if (info[0].equals("Enter")) {
            logs.add(info[1] + " " + 1);
        }
    }
}
