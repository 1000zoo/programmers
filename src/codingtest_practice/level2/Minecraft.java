//2023-09-10
//https://school.programmers.co.kr/learn/courses/30/lessons/172927?language=java#
//광물캐기

package codingtest_practice.level2;

import java.util.*;

public class Minecraft {

    private static class Minerals {
        public int dia;
        public int iron;
        public int stone;

        public Minerals() {
            this.dia = 0;
            this.iron = 0;
            this.stone = 0;
        }

        public void add(String m) {
            switch (m) {
                case "diamond" -> this.dia++;
                case "iron" -> this.iron++;
                case "stone" -> this.stone++;
            }
        }

        public int compare(Minerals m) {
            return this.dia != m.dia ? Integer.compare(this.dia, m.dia) :
                    this.iron != m.iron ? Integer.compare(this.iron, m.iron) :
                            Integer.compare(this.stone, m.stone);
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickSum = picks[0] + picks[1] + picks[2];
        List<Minerals> list = new ArrayList<>();

        for (int i = 0; i < pickSum; i++) {
            int end = Math.min((i + 1) * 5, minerals.length);
            Minerals temp = new Minerals();
            for (int j = i * 5; j < end; j++) {
                temp.add(minerals[j]);
            }
            list.add(temp);
            if (end == minerals.length) break;
        }

        list.sort((o1, o2) -> o2.compare(o1));

        int pickIndex = 0;
        for (Minerals m : list) {
            if (picks[pickIndex] == 0) pickIndex++;
            if (picks[pickIndex] == 0) pickIndex++;
            if (pickIndex == 3) break;
            answer += (calculate(m, pickIndex));
            picks[pickIndex]--;
        }

        return answer;
    }

    private int calculate(Minerals m, int pick) {
        int sum = 0;

        sum += (getTired(pick, "diamond")) * m.dia;
        sum += (getTired(pick, "iron")) * m.iron;
        sum += (getTired(pick, "stone")) * m.stone;

        return sum;
    }

    private int getTired(int pick, String mineral) {
        if (pick == 1 && mineral.equals("diamond")) return 5;
        if (pick == 2) {
            if (mineral.equals("diamond")) return 25;
            if (mineral.equals("iron")) return 5;
        }
        return 1;
    }
}
