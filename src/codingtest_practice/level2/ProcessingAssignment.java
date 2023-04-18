//2023-04-18
//https://school.programmers.co.kr/learn/courses/30/lessons/176962
//과제 진행하기

package codingtest_practice.level2;

import java.util.*;

public class ProcessingAssignment {
    private class Subject {
        public String name;
        public int minutes;
        public int playTimes;

        public Subject(String name, int minutes, int playTimes) {
            this.name = name;
            this.minutes = minutes;
            this.playTimes = playTimes;
        }

        public Subject(String[] plan) {
            this.name = plan[0];
            this.minutes = getMinutes(plan[1]);
            this.playTimes = Integer.parseInt(plan[2]);
        }

        public String toString() {
            return this.name;
        }
    }

    public String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();

        Arrays.sort(plans, (o1, o2) -> getMinutes(o1[1]) - getMinutes(o2[1]));
        Queue<Subject> q = new LinkedList<>();
        Stack<Subject> stack = new Stack<>();

        for (String[] plan : plans) {
            q.add(new Subject(plan));
        }
        Subject curr = q.poll();

        while (!q.isEmpty()) {
            Subject next = q.peek();
            int currEnd = curr.minutes + curr.playTimes;

            if (currEnd > next.minutes) {
                curr.playTimes = currEnd - next.minutes;
                stack.push(curr);
            } else if (currEnd == next.minutes) {
                answerList.add(curr.name);
            } else {
                answerList.add(curr.name);
                while (!stack.isEmpty()) {
                    Subject temp = stack.pop();
                    int tempEnd = currEnd + temp.playTimes;
                    if (tempEnd > next.minutes) {
                        temp.playTimes = tempEnd - next.minutes;
                        stack.push(temp);
                        break;
                    } else if (tempEnd == next.minutes) {
                        answerList.add(temp.name);
                        break;
                    } else {
                        currEnd = tempEnd;
                        answerList.add(temp.name);
                    }
                }
            }
            curr = q.poll();
        }

        answerList.add(curr.name);

        while (!stack.isEmpty()) {
            answerList.add(stack.pop().name);
        }


        return answerList.toArray(new String[0]);
    }

    private int getMinutes(String s) {
        String[] temp = s.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}
