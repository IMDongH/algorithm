package BOJ.implementation;

import java.util.*;
import java.io.*;


public class BOJ_2615 {
    static int[][] board = new int[20][20];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = new int[]{-1, 0, 1, 1};
    static int[] dy = new int[]{1, 1, 1, 0};
    static int result = 0, rX, rY;

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (board[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    if (checkValidPosition(i - dx[k], j - dy[k]) && board[i - dx[k]][j - dy[k]] == board[i][j]) {
                        continue;
                    }

                    int inARow = countStones(i, j, k, board[i][j]);

                    if (inARow == 5) {
                        result = board[i][j];
                        rX = i;
                        rY = j;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
        if (result != 0) {
            System.out.println(rX + " " + rY);
        }
    }

    private static int countStones(int x, int y, int direction, int prev) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if (!checkValidPosition(nx, ny) || board[nx][ny] != prev) {
            return 1;
        }

        return 1 + countStones(nx, ny, direction, prev);
    }

    private static boolean checkValidPosition(int x, int y) {
        return x >= 1 && x <= 19 && y >= 1 && y <= 19;
    }

}