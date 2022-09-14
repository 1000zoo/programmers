//콜라츠 추측
//https://school.programmers.co.kr/learn/courses/30/lessons/12943

package codingtest_practice.level1;

public class CollatzConjecture {

    //num 이 적당히 큰 경우, 연산도중 overflow 가 발생할 수 있어서
    //long 으로 형변환해준 뒤 시작
    public int solution(int num) {
        if (num == 1) return 0;
        long temp = num;
        int count = 0;
        while (temp != 1) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                temp *= 3;
                temp += 1;
            }
            count++;
            if (count > 500) return -1;
        }
        return count;
    }
}
