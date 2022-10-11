package codingtest_practice.level1;

public class TreasureMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = bridge(arr1[i] | arr2[i], n);
        }
        return answer;
    }

    private String bridge(int n, int length) {
        return decoder(toBinaryFormat(n, length));
    }

    private String toBinaryFormat(int n, int length) {
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            answer.append(n % 2);
            n /= 2;
        }
        int count = length - answer.length();
        for (int i = 0; i < count; i++) {
            answer.append(0);
        }
        return answer.reverse().toString();
    }

    private String decoder(String code) {
        StringBuilder answer = new StringBuilder();
        for (char c : code.toCharArray()) {
            if (c == '0') {
                answer.append(' ');
            } else if (c == '1') {
                answer.append('#');
            } else {
                answer.append('-');
            }
        }
        return answer.toString();
    }
}
