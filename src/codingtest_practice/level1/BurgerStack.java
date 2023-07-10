//2023-07-10
//https://school.programmers.co.kr/learn/courses/30/lessons/133502
//햄버거 만들기

package codingtest_practice.level1;

public class BurgerStack {

    public int solution1(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i : ingredient) sb.append(i);
        String ing = sb.toString();
        int pos = 0;

        while (true) {
            int index = ing.indexOf("1231", pos);
            if (index == -1) break;

            pos = index - 3;
            ing = ing.substring(0, index) + ing.substring(index + 4, ing.length());
            answer++;
        }

        return answer;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/133502/solution_groups?language=java
    public int solution2(int[] ingredient) {
        int[] arr = new int[ingredient.length];
        int answer = 0;
        int index = 0;

        for (int i : ingredient) {
            arr[index++] = i;

            if (index >= 4 && arr[index - 1] == 1 && arr[index - 2] == 3 && arr[index - 3] == 2 && arr[index - 4] == 1) {
                answer++;
                index -= 4;
            }
        }
        return answer;
    }
}
