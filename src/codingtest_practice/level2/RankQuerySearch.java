//2023-09-18
//https://school.programmers.co.kr/learn/courses/30/lessons/72412
//순위 검색

package codingtest_practice.level2;

import java.util.*;

public class RankQuerySearch {

    //refer by: https://school.programmers.co.kr/questions/29190
    Map<String, ArrayList<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String i : info) {
            String[] arr = i.split(" ");
            setMap(arr, new String[4], Integer.parseInt(arr[4]), 0);
        }

        for (String k : map.keySet()) {
            Collections.sort(map.get(k));
        }

        for (int i = 0; i < query.length; i++) {
            String[] qq = query[i].split(" and | ");
            String q = String.join(" ", Arrays.copyOfRange(qq, 0, 4));
            int score = Integer.parseInt(qq[4]);

            if (!map.containsKey(q)) {
                answer[i] = 0;
            } else {
                ArrayList<Integer> list = map.get(q);
                answer[i] = list.size() - binarySearch(list, score);
            }
        }

        return answer;
    }

    private int binarySearch(List<Integer> list, int n) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < n) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    private void setMap(String[] origin, String[] info, int score, int depth) {
        if (depth == 4) {
            String key = String.join(" ", info);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(score);
            return;
        }
        info[depth] = origin[depth];
        setMap(origin, info, score, depth + 1);
        info[depth] = "-";
        setMap(origin, info, score, depth + 1);
    }

    //=================================================================================

    public int[] wrongSolution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int index = 0;
        for (String q : query) {
            String[] w = q.split(" and ");
            w = new String[] {w[0], w[1], w[2], w[3].split(" ")[0], w[3].split(" ")[1]};
            int count = 0;

            for (String i : info) {
                String[] a = i.split(" ");
                boolean yes = true;
                 for (int j = 0; j < a.length; j++) {
                      if (w[j].equals("-")) continue;
                      if (j == 4) {
                          yes = Integer.parseInt(w[4]) <= Integer.parseInt(a[4]);
                      } else {
                          yes = a[j].equals(w[j]);
                      }
                      if (!yes) break;
                 }
                count += yes ? 1 : 0;
            }
            answer[index++] = count;
        }


        return answer;
    }
}
