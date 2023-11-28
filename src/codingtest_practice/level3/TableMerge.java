//2023-11-28 (첫번째 시도)
//https://school.programmers.co.kr/learn/courses/30/lessons/150366
//표 병합

package codingtest_practice.level3;

import java.util.*;
import java.util.stream.*;

class TableMerge {

    private final static int ROW_MAX = 50;
    private final static int COL_MAX = 50;

    private static class Table {
        private final Map<String, Cell> map;

        public Table() {
            map = new HashMap<>();
            initTable();
        }

        private void initTable() {
            for (int i = 1; i <= ROW_MAX; i++) {
                for (int j = 1; j <= COL_MAX; j++) {
                    Cell cell = new Cell(i, j);
                    map.put(cell.getPos(), cell);
                }
            }
        }

        private String toKey(int r, int c) {
            return "" + r + "," + c;
        }

        private void update(int r, int c, String value) {
            map.get(toKey(r, c)).updateValue(value);
        }

        private void update(String v1, String v2) {
            for (Cell cell : findAll(v1)) {
                cell.updateValue(v2);
            }
        }

        private List<Cell> findAll(String keyValue) {
            return map.values().stream()
                    .filter(cell -> cell.hasSameValue(keyValue))
                    .collect(Collectors.toList());
        }

        private String print(int r, int c) {
            String key = toKey(r, c);
            return map.get(key).getValue();
        }

        private void merge(int r1, int c1, int r2, int c2) {
            if (r1 == r2 && c1 == c2) return;
            String key1 = toKey(r1, c1);
            String key2 = toKey(r2, c2);
            Cell cell1 = map.get(key1);
            Cell cell2 = map.get(key2);
            MergedCell mc;
            if (cell1.isEmpty() && cell2.isEmpty()) {
                mc = new MergedCell("");
            } else if (cell1.isEmpty()) {
                if (cell2.notMerged()) {
                    mc = new MergedCell(cell2.getValue());
                } else {
                    mc = cell2.getMergedCell();
                    mc.addCell(cell1);
                    cell1.merge(mc);
                    return;
                }
            } else {
                if (cell1.notMerged()) {
                    mc = new MergedCell(cell1.getValue());
                } else {
                    mc = cell1.getMergedCell();
                    mc.addCell(cell2);
                    cell2.merge(mc);
                    return;
                }
            }
            mc.addCell(cell1);
            mc.addCell(cell2);
            cell1.merge(mc);
            cell2.merge(mc);
        }

        private void unmerge(int r, int c) {
            String key = toKey(r, c);
            Cell cell = map.get(key);
            if (cell.notMerged()) return;
            String value = cell.mergedCell.value;
            cell.mergedCell.unmerged();
            cell.updateValue(value);
        }

        public String toString() {
            List<Cell> cells = map.values().stream()
                    .filter(cell -> !cell.isEmpty())
                    .collect(Collectors.toList());
            return cells.toString();
        }
    }

    private static class MergedCell {
        private String value;
        private List<Cell> mergedList;

        public MergedCell(String value) {
            this.value = value;
            mergedList = new ArrayList<>();
        }

        public void update(String newValue) {
            this.value = newValue;
        }

        public void unmerged() {
            for (Cell cell : mergedList) {
                cell.unmerge();
            }
        }

        public void addCell(Cell cell) {
            mergedList.add(cell);
        }

        public String getValue() {
            return value;
        }
    }

    private static class Cell {
        private final int row;
        private final int col;

        private String value;
        private MergedCell mergedCell;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getPos() {
            return "" + row + "," + col;
        }

        public void merge(MergedCell mc) {
            this.value = null;
            this.mergedCell = mc;
        }

        public void unmerge() {
            mergedCell = null;
        }

        public boolean notMerged() {
            return mergedCell == null;
        }

        public MergedCell getMergedCell() {
            return mergedCell;
        }

        public void updateValue(String value) {
            if (mergedCell != null) {
                mergedCell.update(value);
                return;
            }
            this.value = value;
        }

        public boolean isEmpty() {
            return value == null && mergedCell == null;
        }

        public boolean hasSameValue(String v) {
            if (value == null) return false;
            return value.equals(v);
        }

        public String getValue() {
            if (value == null && mergedCell == null) {
                return "EMPTY";
            } else if (value == null) {
                return mergedCell.getValue();
            }
            return value;
        }

        public String toString() {
            return "(" + row + ", " + col + "): " + getValue();
        }
    }

    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        Table table = new Table();

        for (String command : commands) {
            String temp = process(table, command);

            if (temp.isEmpty()) continue;
            answer.add(temp);
        }

        String[] arr = new String[answer.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }

    private String process(Table table, String command) {
        String[] split = command.split(" ");

        if (split[0].equals("UPDATE")) {
            if (split.length == 4) {
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                String value = split[3];
                table.update(r, c, value);
            } else {
                table.update(split[1], split[2]);
            }
        } else if (split[0].equals("MERGE")) {
            int r1 = Integer.parseInt(split[1]);
            int c1 = Integer.parseInt(split[2]);
            int r2 = Integer.parseInt(split[3]);
            int c2 = Integer.parseInt(split[4]);
            table.merge(r1, c1, r2, c2);
        } else if (split[0].equals("UNMERGE")) {
            int r = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            table.unmerge(r, c);
        } else {
            int r = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            return table.print(r, c);
        }
        return "";
    }
}