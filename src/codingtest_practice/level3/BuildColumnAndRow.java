//2023-10-17
//https://school.programmers.co.kr/learn/courses/30/lessons/60061
//기둥과 보 설치

package codingtest_practice.level3;

import java.util.*;

class BuildColumnAndRow {

    private static class Location {
        public Structure col;
        public Structure row;

        public void setCol(Structure col) {
            this.col = col;
        }
        public void setRow(Structure row) {
            this.row = row;
        }

        public void removeCol() {
            this.col = null;
        }

        public void removeRow() {
            this.row = null;
        }

        public boolean hasCol() {
            return this.col != null;
        }
        public boolean hasRow() {
            return this.row != null;
        }
        public boolean isEmpty() {
            return !hasCol() && !hasRow();
        }
    }

    private static class Structure {
        public int x;
        public int y;
        public int type; //-1: 없음, 0: 기둥, 1: 보

        public Structure(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public boolean isEmpty() {
            return this.type == -1;
        }
    }

    private Location[][] wall;

    public int[][] solution(int n, int[][] buildFrame) {
        wall = new Location[n + 1][n + 1]; //[y][x]
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                wall[i][j] = new Location();
            }
        }

        for (int[] frame : buildFrame) {
            process(frame);
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Location curr = wall[i][j];
                if (curr.hasCol()) {
                    result.add(new int[]{j, i, 0});
                }
                if (curr.hasRow()) {
                    result.add(new int[]{j, i, 1});
                }
            }
        }

        int[][] answer = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        Arrays.sort(answer, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        return answer;
    }

    private void process(int[] frame) {
        if (frame[3] == 0) {
            remove(frame);
            return;
        }
        build(frame);
    }

    private boolean isValid(int x, int y, int type) {
        if (type == 0) {
            return y == 0 || wall[y][x].hasRow() || (x > 0 && wall[y][x - 1].hasRow()) || wall[y - 1][x].hasCol();
        }
        return (wall[y - 1][x].hasCol() || wall[y - 1][x + 1].hasCol()) || (x > 0 && wall[y][x - 1].hasRow() && wall[y][x + 1].hasRow());
    }

    private void build(int[] frame) {
        int x = frame[0];
        int y = frame[1];
        int type = frame[2];
        if (isValid(x, y, type)) {
            if (type == 0) {
                wall[y][x].setCol(new Structure(x, y, type));
                return;
            }
            wall[y][x].setRow(new Structure(x, y, type));
        }
    }

    private void remove(int[] frame) {
        int x = frame[0];
        int y = frame[1];
        int type = frame[2];

        Location curr = wall[y][x];
        Structure backup;

        if (type == 0) {
            backup = curr.col;
            curr.removeCol();
        } else {
            backup = curr.row;
            curr.removeRow();
        }

        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[0].length; j++) {
                if (wall[i][j].hasCol() && !isValid(j, i, 0)) {
                    if (type == 0) {
                        wall[y][x].setCol(backup);
                    } else {
                        wall[y][x].setRow(backup);
                    }
                    return;
                }
                if (wall[i][j].hasRow() && !isValid(j, i, 1)) {
                    if (type == 0) {
                        wall[y][x].setCol(backup);
                    } else {
                        wall[y][x].setRow(backup);
                    }
                    return;
                }
            }
        }
    }
}
