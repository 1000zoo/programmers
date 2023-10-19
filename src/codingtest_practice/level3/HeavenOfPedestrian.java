//2023-10-20
//https://school.programmers.co.kr/learn/courses/30/lessons/1832
//보행자 천국

package codingtest_practice.level3;

public class HeavenOfPedestrian {

    private final int MOD = 20170805;

    private class Road {
        private int type;
        private int goRight;
        private int goDown;

        public Road() {}

        public Road(int type, int r, int d) {
            this.type = type;
            goRight = r;
            goDown = d;
        }

        public int toDown() {
            if (type == 2) {
                return goDown;
            }
            return (goDown + goRight) % MOD;
        }

        public int toRight() {
            if (type == 2) {
                return goRight;
            }
            return (goDown + goRight) % MOD;
        }
    }

    public int solution(int m, int n, int[][] cityMap) {
        Road[][] dp = new Road[m][n];
        initDp(dp, cityMap);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int type = cityMap[i][j];

                if (type == 1) {
                    dp[i][j] = new Road();
                    continue;
                }

                Road up = dp[i - 1][j];
                Road left = dp[i][j - 1];

                int fromLeft = left.toRight();
                int fromUp = up.toDown();

                dp[i][j] = new Road(type, fromLeft, fromUp);
            }
        }

        return dp[m-1][n-1].toDown();
    }

    private void initDp(Road[][] dp, int[][] cityMap) {

        int m = cityMap.length;
        int n = cityMap[0].length;

        for (int i = 0; i < m; i++) {
            int type = cityMap[i][0];
            if (type == 1) {
                while (i < m) {
                    dp[i++][0] = new Road();
                }
                break;
            }
            dp[i][0] = new Road(type, 0, 1);
        }

        for (int i = 0; i < n; i++) {
            int type = cityMap[0][i];
            if (type == 1) {
                while (i < n) {
                    dp[0][i++] = new Road();
                }
                break;
            }
            dp[0][i] = new Road(type, 1, 0);
        }
    }
}
