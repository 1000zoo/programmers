//2023-09-20
//https://school.programmers.co.kr/learn/courses/30/lessons/169198
//당구 연습

package codingtest_practice.level2;

public class BilliardPractice {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int i = 0;

        for (int[] ball : balls) {
            answer[i++] = getMinDistance(m, n, startX, startY, ball[0], ball[1]);
        }

        return answer;
    }

    private int getMinDistance(int m, int n, int x1, int y1, int x2, int y2) {
        double upX = (double) (x1 * (n - y2) + x2 * (n - y1)) / (2 * n - y1 - y2);
        double downX = (double) (-1 * x1 * y2 - x2 * y1) / (-1 * y1 - y2);
        double leftY = (double) (-1 * y1 * x2 - y2 * x1) / (-1 * x1 - x2);
        double rightY = (double) (y1 * (m - x2) + y2 * (m - x1)) / (2 * m - x1 - x2);

        double[] up = {upX, n};
        double[] down = {downX, 0};
        double[] left = {0, leftY};
        double[] right = {m, rightY};

        double upDistance = getDistance(x1, y1, up) + getDistance(x2, y2, up);
        double downDistance = getDistance(x1, y1, down) + getDistance(x2, y2, down);
        double leftDistance = getDistance(x1, y1, left) + getDistance(x2, y2, left);
        double rightDistance = getDistance(x1, y1, right) + getDistance(x2, y2, right);

        int u = (int) Math.ceil(Math.pow(upDistance, 2));
        int d = (int) Math.ceil(Math.pow(downDistance, 2));
        int l = (int) Math.ceil(Math.pow(leftDistance, 2));
        int r = (int) Math.ceil(Math.pow(rightDistance, 2));

        int min = Integer.MAX_VALUE;

        if (!(x1 == x2 && y1 < y2)) min = u;
        if (!(x1 == x2 && y1 > y2)) min = Math.min(min, d);
        if (!(y1 == y2 && x1 < x2)) min = Math.min(min, r);
        if (!(y1 == y2 && x1 > x2)) min = Math.min(min, l);


        return min;
    }

    private double getDistance(int x1, int y1, double[] side) {
        return Math.sqrt(Math.pow(side[0] - x1, 2) + Math.pow(side[1] - y1, 2));
    }
}
