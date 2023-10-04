package codingtest_practice.level3;

public class MaxSliceSumOfPulseArray {

    public long solution(int[] sequence) {
        return Math.max(maxSumOfPartition(sequence, 1), maxSumOfPartition(sequence, -1));
    }

    private long maxSumOfPartition(int[] sequence, int start) {
        int[] array = getPulseDotArray(sequence, start);
        long[] dp = new long[array.length];
        dp[0] = array[0];
        long max = dp[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0L) + array[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    private int[] getPulseDotArray(int[] array, int start) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i] * start;
            start *= -1;
        }
        return result;
    }
}
