//2023-10-25
//https://school.programmers.co.kr/learn/courses/30/lessons/60062
//외벽 점검

package codingtest_practice.level3;

import java.util.*;

public class InspectWall {

    private static class Permutation {
        private final int[] originArray;
        private final List<List<Integer>> results;

        public Permutation(int[] array) {
            originArray = array;
            results = new ArrayList<>();
        }

        private void dfs(List<Integer> currList) {
            if (currList.size() == originArray.length) {
                results.add(new ArrayList<>(currList));
                return;
            }

            for (int i = 0; i < originArray.length; i++) {
                if (currList.contains(i)) continue;
                currList.add(i);
                dfs(currList);
                currList.remove(currList.size() - 1);
            }
        }

        private void setPermutation() {
            dfs(new ArrayList<>());
        }

        public List<int[]> getPermutation() {
            setPermutation();
            List<int[]> list = new ArrayList<>();

            for (List<Integer> l : results) {
                int[] temp = new int[originArray.length];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = originArray[l.get(i)];
                }
                list.add(temp);
            }

            return list;
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        int originLength = weak.length;

        dist = reverseSort(dist);
        weak = getTwice(weak, n);
        for (int i = 0; i < dist.length; i++) {
            int[] origin = Arrays.copyOfRange(dist, 0, i + 1);
            Permutation p = new Permutation(origin);
            List<int[]> possible = p.getPermutation();

            for (int[] temp : possible) {
                for (int k : weak) {
                    int count = 0;
                    int start = k;
                    for (int t : temp) {
                        int end = start + t;
                        count += counter(start, end, weak);
                        start = getNext(end, weak);
                    }
                    if (count == originLength) {
                        return temp.length;
                    }
                }
            }
        }

        return -1;
    }

    private int getNext(int end, int[] weak) {
        for (int w : weak) {
            if (end < w) return w;
        }
        return -1;
    }

    private int counter(int start, int end, int[] weak) {
        int count = 0;

        for (int w : weak) {
            if (start <= w && w <= end) count++;
        }

        return count;
    }

    private int[] getTwice(int[] weak, int n) {
        int[] newWeak = new int[2 * weak.length];
        int i = 0;
        for (; i < weak.length; i++) {
            newWeak[i] = weak[i];
        }
        for (; i < newWeak.length; i++) {
            newWeak[i] = n + weak[i % weak.length];
        }
        return newWeak;
    }

    private int[] reverseSort(int[] dist) {
        List<Integer> list = new ArrayList<>();
        for (int d : dist) list.add(d);
        list.sort(Collections.reverseOrder());
        dist = list.stream().mapToInt(i -> i).toArray();
        return dist;
    }
}
