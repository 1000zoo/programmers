//2023-10-28
//https://school.programmers.co.kr/learn/courses/30/lessons/150367#
//표현 가능한 이진트리

package codingtest_practice.level3;

public class BinaryTreeRepresentationChecker {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = process(numbers[i]);
        }

        return answer;
    }

    private int process(long number) {
        int[] binary = toBinaryArray(number);
        return dfs(binary, 0, binary.length - 1) ? 1 : 0;
    }

    private boolean dfs(int[] binary, int left, int right) {
        if (right <= left) {
            return true;
        }

        int mid = (left + right) / 2;

        if (binary[mid] == 1) {
            return dfs(binary, left, mid - 1) && dfs(binary, mid + 1, right);
        }
        return onlyZero(binary, left, right);
    }

    private boolean onlyZero(int[] binary, int left, int right) {
        if (right == left) {
            return binary[left] == 0;
        }
        int mid = (left + right) / 2;
        if (binary[mid] == 1) {
            return false;
        }
        return onlyZero(binary, left, mid - 1) && onlyZero(binary, mid + 1, right);
    }

    private int[] toBinaryArray(long number) {
        int[] binaryArray = new int[binaryLength(number)];
        String binary = Long.toBinaryString(number);
        int diff = binaryArray.length - binary.length();

        for (int i = 0; i < diff; i++) {
            binaryArray[i] = 0;
        }
        for (int i = diff; i < binaryArray.length; i++) {
            binaryArray[i] = binary.charAt(i - diff) - '0';
        }

        return binaryArray;
    }

    private int binaryLength(long number) {
        return (int) (Math.pow(2, logCeil(logCeil(number)))) - 1;
    }

    private int logCeil(long number) {
        double log = log2(number);
        int ans = (int) Math.ceil(log2(number));
        return log % 1 == 0 ? ans + 1 : ans;
    }

    private double log2(long number) {
        return Math.log(number) / Math.log(2);
    }
}
