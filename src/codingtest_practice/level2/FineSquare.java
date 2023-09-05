//2023-09-05
//https://school.programmers.co.kr/learn/courses/30/lessons/62048?language=java#
//멀쩡한 사각형

package codingtest_practice.level2;

public class FineSquare {

    public long solution(int w, int h) {
        long answer = 0;

        for (long x = 0; x < w; x++) {
            long temp = countSq(w, h, x, x + 1);
            answer += temp;
        }

        return ((long) w * h) - answer;
    }

    private long countSq(long w, long h, long x1, long x2) {
        double y1 = eqY(w, h, x1);
        double y2 = eqY(w, h, x2);

        return (long) (Math.floor(y1) - Math.floor(y2)) + (y1 % 1 == 0 ? 0 : 1);
    }

    private double eqY(long w, long h, long x) {
        return -1 * ((double) x * h / w) + h;
    }
}
