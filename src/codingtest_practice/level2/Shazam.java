//2023-07-27
//https://school.programmers.co.kr/learn/courses/30/lessons/17683#
//방금 그곡

package codingtest_practice.level2;

public class Shazam {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int prevPlayTime = 0;
        m = replaceAllHash(m);

        for (String info : musicinfos) {
            String[] split = info.split(",");
            String start = split[0];
            String end = split[1];
            String title = split[2];
            String pitch = replaceAllHash(split[3]);
            int playTime = getPlayTime(start, end);
            String actual = actualPlay(pitch, playTime);

            if (actual.contains(m) && playTime > prevPlayTime) {
                answer = title;
                prevPlayTime = playTime;
            }
        }

        return answer.length() == 0 ? "(None)" : answer;
    }

    private String actualPlay(String pitch, int playTime) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playTime; i++) {
            sb.append(pitch.charAt(i % pitch.length()));
        }
        return sb.toString();
    }

    private int getPlayTime(String start, String end) {
        return convertTime(end) - convertTime(start);
    }

    private int convertTime(String time) {
        String[] temp = time.split(":");
        return 60 * Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
    }

    private String replaceAllHash(String origin) {
        return origin.replaceAll("C#", "H")
                .replaceAll("D#", "I")
                .replaceAll("F#", "J")
                .replaceAll("G#", "K")
                .replaceAll("A#", "L");
    }
}
