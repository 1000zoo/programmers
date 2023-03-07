package codingtest_practice.level1;

public class DesktopCleanup {
    public int[] solution(String[] wallpaper) {
        int x1 = 50, y1 = 50;
        int x2 = -1, y2 = -1;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                char temp = wallpaper[i].charAt(j);
                if (temp == '#') {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i + 1);
                    y2 = Math.max(y2, j + 1);
                }
            }
        }
        return new int[] {x1, y1, x2, y2};
    }
}
