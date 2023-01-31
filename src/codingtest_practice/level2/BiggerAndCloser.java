//2023-01-31
//https://school.programmers.co.kr/learn/courses/30/lessons/154539
//뒤에 있는 큰 수 찾기

package codingtest_practice.level2;

import java.util.*;

public class BiggerAndCloser {

    //시간초과한 답변
    //=> Time Complexity: O(N^2) 이라서
    public int[] timeout(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length - 1; i++) {
            int temp = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (temp < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
            if (answer[i] == 0) answer[i] = -1;
        }
        answer[numbers.length - 1] = -1;
        return answer;
    }
    public int[] slower(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Set<Integer> indexes = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            List<Integer> forRemove = new ArrayList<>();
            for (int temp : indexes) {
                if (numbers[temp] < numbers[i]) {
                    forRemove.add(temp);
                    answer[temp] = numbers[i];
                }
            }
            for (int remove : forRemove) {
                indexes.remove(remove);
            }
            indexes.add(i);
        }

        return answer;
    }

    //https://school.programmers.co.kr/questions/43169
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o[1])
        );

        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];

            while (!queue.isEmpty()) {
                if (queue.peek()[1] >= temp) break;
                answer[queue.poll()[0]] = temp;
            }
            queue.add(new int[] {i, temp});
        }

        return answer;
    }
}
