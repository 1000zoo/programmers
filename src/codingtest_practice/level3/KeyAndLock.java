//2023-10-06
//https://school.programmers.co.kr/learn/courses/30/lessons/60059
//자물쇠와 열쇠

package codingtest_practice.level3;

import java.util.*;

public class KeyAndLock {
    public boolean solution(int[][] key, int[][] lock) {
        int[][] temp = extendedLock(lock, key.length);
        if (isFullOfOne(lock)) return true;

        for (int r = 0; r < 4; r++) {
            for (int i = 0; i < key.length + lock.length - 1; i++) {
                for (int j = 0; j < key.length + lock.length - 1; j++) {
                    if (isMatch(key, temp, i, j)) return true;
                }
            }
            rotate(key);
        }

        return false;
    }

    private boolean isFullOfOne(int[][] arr) {
        for (int[] ar : arr) {
            for (int a : ar) {
                if (a == 0) return false;
            }
        }
        return true;
    }

    private void rotate(int[][] key) {
        int[][] temp = clone(key);

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = temp[j][key.length - i - 1];
            }
        }
    }

    private int[][] clone(int[][] arr) {
        int[][] temp = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i].clone();
        }

        return temp;
    }

    private void print(int[][] arr) {
        for (int[] ar : arr) {
            for (int a : ar) {
                System.out.print(a + ", ");
            }
            System.out.println("");
        }
    }

    private boolean isMatch(int[][] key, int[][] originLock, int iIndex, int jIndex) {
        int[][] lock = clone(originLock);
        int lockMin = key.length - 1;
        int lockMax = lock.length - lockMin;

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                int lockI = iIndex + i;
                int lockJ = jIndex + j;
                if (!(lockMin <= lockI && lockI < lockMax) || !(lockMin <= lockJ && lockJ < lockMax)) {
                    continue;
                }


                if (key[i][j] == lock[lockI][lockJ]) {
                    return false;
                }
                lock[lockI][lockJ] = 1;
            }
        }


        for (int i = lockMin; i < lockMax; i++) {
            for (int j = lockMin; j < lockMax; j++) {
                if (lock[i][j] == 0) return false;
            }
        }

        return true;
    }

    private int[][] extendedLock(int[][] lock, int keyLength) {
        int extendedLength = (keyLength - 1) * 2 + lock.length;
        int[][] el = new int[extendedLength][extendedLength];

        for (int i = 0; i < lock.length; i++) {
            int index = i + keyLength - 1;
            for (int j = 0; j < lock.length; j++) {
                el[index][j + keyLength - 1] = lock[i][j];
            }
        }

        return el;
    }
}
