package BOJ.backtracking;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_2580 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = list.get(j);
            }
        }
        sudoku(0, 0);

    }

    public static void sudoku(int x, int y) {
        if (y == 9) {
            sudoku(x + 1, 0);
            return;
        }
        if (x == 9) {
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    sb.append(anInt).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (promising(x, y, i)) {
                    arr[x][y] = i;
                    sudoku(x, y + 1);
                }
            }
            arr[x][y] = 0;
            return;
        }

        sudoku(x, y + 1);
    }

    public static boolean promising(int x, int y, int value) {

        // x 축에 포함되는지 확인
        for (int i = 0; i < 9; i++) {
            if (arr[x][i] == value) {
                return false;
            }
        }

        // y축에 포함되는지 확인
        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == value) {
                return false;
            }
        }


        // 한 사각형 안에 포함되는지 확인
        int divX = (x / 3) * 3;
        int divY = (y / 3) * 3;

        for (int i = divX; i < divX + 3; i++) {
            for (int j = divY; j < divY + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

}
