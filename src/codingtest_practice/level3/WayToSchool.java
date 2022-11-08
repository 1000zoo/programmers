package codingtest_practice.level3;

public class WayToSchool {
    public int[][] puddles;

    public int solution(int m, int n, int[][] p) {
        puddles = p;
        return sol1(1, 1, m, n);
    }

    //solution
    public int sol2(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        boolean[][] isPuddle = new boolean[m + 1][n + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[0]][puddle[1]] = true;
        }
        dp[m][n] = 1;
        for (int r = m; r > 0 ; r--) {
            for (int c = n; c > 0; c--) {
                if (r == m && c == n) continue;
                if (!isPuddle[r][c]) {
                    if (r == m) {
                        dp[r][c] += dp[r][c + 1];
                    } else if (c == n) {
                        dp[r][c] += dp[r + 1][c];
                    } else {
                        dp[r][c] += (dp[r][c + 1] + dp[r + 1][c]) % 1000000007;
                    }
                }
            }
        }
        return dp[1][1];
    }


    //solution1
    //재귀를 이용한 풀이
    //효율성테스트 통과 X
    public int sol1(int c, int r, int m, int n) {
        if (isPuddles(c, r)) {
            return 0;
        }
        if (c == m && r == n) return 0;
        if (c == m) {
            if (isPuddlesLine(c, r, true)) {
                return 0;
            } else {
                return 1;
            }
        }
        if (r == n) {
            if (isPuddlesLine(c, r, false)) {
                return 0;
            } else {
                return 1;
            }
        }
        int sum = 0;
        sum += sol1(c + 1, r, m, n);
        sum += sol1(c, r + 1, m, n);
        return sum;
    }

    public boolean isPuddlesLine(int c, int r, boolean cr) { //c : true, r : false
        if (puddles.length == 0 || puddles[0].length == 0) return false;
        int index = cr ? 0 : 1;
        int edge = cr ? c : r;
        int non = cr ? r : c;
        for (int[] puddle : puddles) {
            if (puddle[index] == edge && puddle[1 - index] >= non) {
                return true;
            }
        }
        return false;
    }

    public boolean isPuddles(int c, int r) {
        if (puddles.length == 0 || puddles[0].length == 0) return false;
        for (int[] puddle : puddles) {
            if (puddle[0] == c && puddle[1] == r) return true;
        }
        return false;
    }
}
