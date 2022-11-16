package codingtest_practice.level2;

import java.util.*;
public class LengthOfTraversal {
    final Set<String> visited = new HashSet<>();
    final int[][] direction = new int[][]{
            {0,1}, {1,0}, {0,-1}, {-1,0}    //up right down left
    };

    public int solution(String dirs) {
        int[] curr = new int[]{0, 0};

        for (char c : dirs.toCharArray()) {
            int command = getCommand(c);
            if (canMove(curr, command)) {
                move(curr, command);
            }
        }

        return visited.size();
    }

    private void move(int[] curr, int command) {
        int oriX = curr[0], oriY = curr[1];
        curr[0] += direction[command][0];
        curr[1] += direction[command][1];

        //가는 경로 (점 A 에서 점 B)
        //(처음 x / 처음 y / 이동한 후 x / 이동한 후 y)
        String path1 = "" + oriX + "/" + oriY  +
                        "/" + curr[0] + "/" + curr[1];
        //돌아오는 경로 (점 B 에서 점 A)
        String path2 = "" + curr[0] + "/" + curr[1] +
                        "/" + oriX + "/" + oriY;

        //만약 반대의 경우가 이미 visited 에 존재한다면, 추가하지 않음.
        if (!visited.contains(path2)) {
            visited.add(path1);
        }
    }

    private boolean canMove(int[] curr, int command) {
        int x = curr[0] + direction[command][0];
        int y = curr[1] + direction[command][1];

        return (x <= 5 && x >= -5) && (y <= 5 && y >= -5);
    }

    private int getCommand(char c) {
        return c == 'U' ? 0 :
                c == 'R' ? 1 :
                        c == 'D' ? 2 :
                                c == 'L' ? 3 : -1;
    }
}
