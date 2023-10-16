package codingtest_practice.level3;

public class BuildColumnAndRow {

    private class Location {
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

        @Override
        public String toString() {
            return "col: " + col + ", row: " + row;
        }
    }

    private class Structure {
        public int x;
        public int y;
        public int type; //-1: 없음, 0: 기둥, 1: 보

        public int oppX;
        public int oppY;

        public Structure(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.oppX = x;
            this.oppY = y;
            setOpp();
        }

        private void setOpp() {
            if (type == 0) {
                this.oppY += 1;
            }
            if (type == 1) {
                this.oppX += 1;
            }
        }

        public boolean isEmpty() {
            return this.type == -1;
        }
        public boolean isColumn() {
            return this.type == 0;
        }
        public boolean isRow() {
            return this.type == 1;
        }

        @Override
        public String toString() {
            return "Structure = [" + x + ", " + y + "], type = " + type;
        }
    }

    private Location[][] wall;

    public int[][] solution(int n, int[][] buildFrame) {
        int[][] answer = {};
        wall = new Location[n + 1][n + 1]; //[y][x]
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                wall[i][j] = new Location();
            }
        }

        for (int[] frame : buildFrame) {
            process(frame);
        }

        return answer;
    }

    private void process(int[] frame) {
        if (frame[3] == 0) {
            remove(frame);
            return;
        }
        build(frame);
    }

    private void build(int[] frame) {
        if (frame[2] == 0) {
            buildColumn(frame[0], frame[1]);
            return;
        }
        buildRow(frame[0], frame[1]);
    }

    private boolean canBuildColumn(int x, int y) {
        if (y == 0) {
            return true;
        }

        Location curr = wall[y][x];
        Location under = wall[y - 1][x];

        if (x == 0) {
            return curr.hasRow() || under.hasCol();
        }
        Location left = wall[y][x - 1];

        return left.hasRow() || curr.hasRow() || under.hasCol();
    }

    private void buildColumn(int x, int y) {
        if (canBuildColumn(x, y)) {
            Structure struct = new Structure(x, y, 0);
            Location curr = wall[y][x];
            curr.setCol(struct);
        }
    }

    private boolean canBuildRow(int x, int y) {
        if (y == 0) return false;

        Location under = wall[y - 1][x];
        Location right = wall[y][x + 1]; // 벽을 벗어나는 경우는 없다.
        if (x == 0) {
            return under.hasCol() || right.hasCol();
        }
        Location left = wall[y][x - 1];
        Location underRight = wall[y - 1][x + 1];

        return (left.hasRow() && right.hasRow()) ||
                under.hasCol() || underRight.hasCol();
    }

    private void buildRow(int x, int y) {
        if (canBuildRow(x, y)) {
            Structure struct = new Structure(x, y, 1);
            Location curr = wall[y][x];
            curr.setRow(struct);
        }
    }

    private void remove(int[] frame) {
        if (frame[2] == 0) {
            removeColumn(frame[0], frame[1]);
            return;
        }
        removeRow(frame[0], frame[1]);
    }

    private boolean canNotRemoveColumnCase0(int x, int y) {
        Location left = wall[y][x - 1];
        return !canNotRemoveColumnCase1(x, y) || left.hasCol();
    }

    private boolean canNotRemoveColumnCase1(int x, int y) {
        // 위에 기둥은 있는데 나머지는 없는 경우
        Location upper = wall[y + 1][x];
        Location upperRight = wall[y + 1][x - 1];
        return upper.hasCol() && !upper.hasRow() && !upperRight.hasRow();
    }

    private boolean canNotRemoveColumnCase2(int x, int y) {
        Location curr = wall[y][x];
        return false;
    }

    private boolean canRemoveColumn(int x, int y) {
//        Location upper = wall[y + 1][x];
//        if (x == 0) {
//            return !upper.isEmpty();
//        }
//        if (x == 1) {
//
//        }
//        if (canNotRemoveColumnCase1(x, y) ||
//        ) {
//            return false;
//        }

        return false;
    }

    private void removeColumn(int x, int y) {
        if (canRemoveColumn(x, y)) {
            Location curr = wall[y][x];
            curr.removeCol();
        }
    }

    private boolean canRemoveRow(int x, int y) {
        return false;
    }

    private void removeRow(int x, int y) {
        if (canRemoveRow(x, y)) {
            Location curr = wall[y][x];
            curr.removeRow();
        }
    }
}
