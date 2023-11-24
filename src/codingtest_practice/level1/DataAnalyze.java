//2023-11-25
//https://school.programmers.co.kr/learn/courses/30/lessons/250121
//데이터 분석

package codingtest_practice.level1;

import java.util.*;
import java.util.stream.*;

public class DataAnalyze {

    private static class Data {
        public int code;
        public int date;
        public int maximum;
        public int remain;

        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }

    public int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
        List<Data> list = getList(data);
        list = filter(list, ext, valExt);
        list = sort(list, sortBy);
        return listToArray(list);
    }

    private int[][] listToArray(List<Data> list) {
        int[][] answer = new int[list.size()][];

        for (int i = 0; i < answer.length; i++) {
            Data data = list.get(i);
            answer[i] = new int[] {data.code, data.date, data.maximum, data.remain};
        }

        return answer;
    }

    private List<Data> sort(List<Data> list, String sortBy) {
        return switch (sortBy) {
            case "code" -> list.stream().sorted(Comparator.comparingInt(d -> d.code)).collect(Collectors.toList());
            case "date" -> list.stream().sorted(Comparator.comparingInt(d -> d.date)).collect(Collectors.toList());
            case "maximum" -> list.stream().sorted(Comparator.comparingInt(d -> d.maximum)).collect(Collectors.toList());
            default -> list.stream().sorted(Comparator.comparingInt(d -> d.remain)).collect(Collectors.toList());
        };
    }

    private List<Data> filter(List<Data> list, String ext, int valExt) {
        return switch (ext) {
            case "code" -> list.stream().filter(data -> data.code < valExt).collect(Collectors.toList());
            case "date" -> list.stream().filter(data -> data.date < valExt).collect(Collectors.toList());
            case "maximum" -> list.stream().filter(data -> data.maximum < valExt).collect(Collectors.toList());
            default -> list.stream().filter(data -> data.remain < valExt).collect(Collectors.toList());
        };
    }

    private List<Data> getList(int[][] data) {
        List<Data> list = new ArrayList<>();

        for (int[] d : data) {
            list.add(new Data(d[0], d[1], d[2], d[3]));
        }

        return list;
    }
}
