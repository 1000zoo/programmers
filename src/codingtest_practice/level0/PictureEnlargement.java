//2023-06-26
//https://school.programmers.co.kr/learn/courses/30/lessons/181836
//그림 확대

package codingtest_practice.level0;

public class PictureEnlargement {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int rowLength = picture[0].length() * k;

        for (int i = 0; i < answer.length; i++) {
            char[] temp = new char[rowLength];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = picture[i / k].charAt(j / k);
            }
            answer[i] = new String(temp);
        }

        return answer;
    }
}
