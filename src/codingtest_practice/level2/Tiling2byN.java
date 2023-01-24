//
//2023-01-24
//2 x n 타일링

package codingtest_practice.level2;

public class Tiling2byN {
    //solution 1
    //fibonacci + memoization 이용
    public int solution1(int n) {
        if (n <= 2) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
        }

        return memo[n];
    }

    //solution2
    //nCr (조합) 이용
    //n이 작으면 가능
    public int solution2(int n) {
        int answer = 0;
        int r = 0;
        for (int i = n; i >= r; i -= 1) {
            answer += nCr(i, r++);
        }
        return answer;
    }

    static int nCr(int n, int r){
        if( r > n ) return -1;
        if( r == 0 ) return 1;
        if( n == r ) return 1;
        if( n-r<r ) r=n-r;
        int res = 1;
        for(int i=1; i<=r; i++) res = res*(n-i+1)/i;
        return res;
    }
}
