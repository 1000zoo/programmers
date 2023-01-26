//2023-01-26
//https://school.programmers.co.kr/learn/courses/30/lessons/17680#
//캐시

package codingtest_practice.level2;

import java.util.*;

public class CacheLRU {

    private Queue<String> cache;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;
        int answer = 0;
        cache = new LinkedList<>();

        for (String city : cities) {
            String c = city.toLowerCase();
            if (cache.contains(c)) {
                cache.remove(c);
                cache.add(c);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.add(c);
                answer += 5;
            }
        }
        return answer;
    }

    //테스트 케이스 18, 19가 안됐는데,
    //반례는 찾지 못했지만 queue.remove(obj)를 사용했을 때 해결됐다.
    public int nt(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;
        int answer = 0;
        cache = new LinkedList<>();

        for (String city : cities) {
            String c = city.toLowerCase();
            if (cache.contains(c)) answer += 1;
            else answer += 5;
            if (cache.size() == cacheSize) {
                cache.poll();
                cache.add(c);
            } else {
                if (cache.contains(c)) lru(c);
                else cache.add(c);
            }
            System.out.println(cache);
        }
        return answer;
    }

    private void lru(String city) {
        Stack<String> temp = new Stack<>();
        while (!city.equals(cache.peek())) {
            temp.push(cache.poll());
        }
        cache.poll();
        while (!temp.isEmpty()) {
            cache.add(temp.pop());
        }
        cache.add(city);
    }


    //["a", "b", "b", "b", "b", "a"] <= 이 경우 안됨
    public int wrong(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> recent = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (recent.containsKey(city)) {
                int recentIndex = recent.get(city);
                if (i - recentIndex <= cacheSize) {
                    answer += 1;
                } else {
                    answer += 5;
                }
            } else {
                answer += 5;
            }
            recent.put(city, i);
        }
        return answer;
    }
}
