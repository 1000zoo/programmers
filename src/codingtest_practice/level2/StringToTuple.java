package codingtest_practice.level2;

import java.util.*;

public class StringToTuple {
    public int[] solution(String s) {
        Map<Integer, Integer[]> forOrder = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (String part : s.split("},")) {
            Integer[] Int = toIntArray(part);
            forOrder.put(Int.length, Int);
        }

        for (int i = 1; i <= forOrder.size(); i++) {
            Integer[] setElement = forOrder.get(i);
            for (int n : setElement) {
                if (!answer.contains(n)){
                    answer.add(n);
                }
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    private Integer[] toIntArray(String s) {
        List<Integer> array = new ArrayList<>();
        int element = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                element *= 10;
                element += (int) (c - '0');
            } else if (c == ',') {
                array.add(element);
                element = 0;
            }
        }
        array.add(element);
        int[] temp = array.stream().mapToInt(i->i).toArray();
        return Arrays.stream(temp).boxed().toArray(Integer[]::new);
    }
}
