package codingtest_practice.level1;

public class ParkWalking {
    private String[] park;
    private final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //E W S N

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        this.park = park;
        int[] curr = findStart();

        for (String route : routes) {
            int[] direction = getDirection(route.charAt(0));
            int count = Integer.parseInt(""+route.charAt(2));
            boolean legal = true;

            for (int i = 1; i <= count; i++) {
                int[] next = new int[] {curr[0] + direction[0] * i, curr[1] + direction[1] * i};
                if (!checkBoundary(next) || cantGo(next)) {
                    legal = false;
                    break;
                }
            }

            if (legal) {
                curr = new int[]{curr[0] + direction[0] * count, curr[1] + direction[1] * count};
            }
        }
        return curr;
    }

    private int[] findStart() {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') return new int[] {i, j};
            }
        }
        return null;
    }

    private int[] getDirection(char c) {
        int d = c == 'E' ? 0 : c == 'W' ? 1 : c == 'S' ? 2 : 3;
        return this.direction[d];
    }

    private boolean cantGo(int[] pos) {
        return park[pos[0]].charAt(pos[1]) == 'X';
    }
    private boolean checkBoundary(int[] pos) {
        return 0 <= pos[0] && pos[0] < park.length && 0 <= pos[1] && pos[1] < park[0].length();
    }
}
