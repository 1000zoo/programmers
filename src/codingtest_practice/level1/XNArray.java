//x 만큼 간격이 있는 n 개의 숫자
//https://school.programmers.co.kr/learn/courses/30/lessons/12954#

package codingtest_practice.level1;

public class XNArray {

    //x 가 int 형이기 때문에, long 으로 형변환 해준 뒤 계산을 해야 overflow 가 나타나지 않는다.
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }
        return answer;
    }
}
