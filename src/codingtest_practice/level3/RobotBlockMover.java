//2023-10-30
//https://school.programmers.co.kr/learn/courses/30/lessons/60063
//블록 이동하기

package codingtest_practice.level3;

import java.util.*;

public class RobotBlockMover {

    static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position position = (Position) obj;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class Robot {
        Position p1, p2;
        int distance;

        public Robot(Position p1, Position p2, int distance) {
            this.p1 = p1;
            this.p2 = p2;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Robot robot = (Robot) obj;
            return p1.equals(robot.p1) && p2.equals(robot.p2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }
    }

    public int solution(int[][] board) {
        int N = board.length;
        Set<Robot> visited = new HashSet<>();
        Queue<Robot> queue = new LinkedList<>();

        Robot start = new Robot(new Position(0, 0), new Position(0, 1), 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Robot current = queue.poll();

            if ((current.p1.row == N - 1 && current.p1.col == N - 1) ||
                    (current.p2.row == N - 1 && current.p2.col == N - 1)) {
                return current.distance;
            }

            if (visited.contains(current)) continue;
            visited.add(current);

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                Position newP1 = new Position(current.p1.row + dir[0], current.p1.col + dir[1]);
                Position newP2 = new Position(current.p2.row + dir[0], current.p2.col + dir[1]);

                Robot newRobot = new Robot(newP1, newP2, current.distance + 1);

                if (newP1.row >= 0 && newP1.row < N && newP1.col >= 0 && newP1.col < N &&
                        newP2.row >= 0 && newP2.row < N && newP2.col >= 0 && newP2.col < N &&
                        board[newP1.row][newP1.col] == 0 && board[newP2.row][newP2.col] == 0) {
                    queue.add(newRobot);
                }
            }

            if (current.p1.row == current.p2.row) {
                for (int dr : new int[]{-1, 1}) {
                    if (current.p1.row + dr >= 0 && current.p1.row + dr < N &&
                            board[current.p1.row + dr][current.p1.col] == 0 &&
                            board[current.p2.row + dr][current.p2.col] == 0) {
                        queue.add(new Robot(current.p1, new Position(current.p1.row + dr, current.p1.col), current.distance + 1));
                        queue.add(new Robot(current.p2, new Position(current.p2.row + dr, current.p2.col), current.distance + 1));
                    }
                }
            }

            else {
                for (int dc : new int[]{-1, 1}) {
                    if (current.p1.col + dc >= 0 && current.p1.col + dc < N &&
                            board[current.p1.row][current.p1.col + dc] == 0 &&
                            board[current.p2.row][current.p2.col + dc] == 0) {
                        queue.add(new Robot(current.p1, new Position(current.p1.row, current.p1.col + dc), current.distance + 1));
                        queue.add(new Robot(current.p2, new Position(current.p2.row, current.p2.col + dc), current.distance + 1));
                    }
                }
            }
        }

        return -1;
    }
}
