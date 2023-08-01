//2022-10-11 (resolve: 2023-08-02)
//https://school.programmers.co.kr/learn/courses/30/lessons/17681
//비밀지도

package codingtest_practice.level1;

public class TreasureMap {
    public String[] newSolution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            temp = "0".repeat(n - temp.length()) + temp;
            answer[i] = temp.replaceAll("0", " ").replaceAll("1", "#");
        }

        return answer;
    }

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
