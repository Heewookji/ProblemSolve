package p02boggle;

import java.util.Scanner;

public class Main5 {

    static final int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
    static final int[] dy = { -1, 0, 1, 1, -1, 1, 0, -1 };

    public static void main(String[] args) {

        char[][] board = new char[5][5];

        Scanner sc = new Scanner(System.in);
        int testN = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testN; i++) {
            for (int y = 0; y < 5; y++)
                board[y] = sc.nextLine().toCharArray();
            int wordN = sc.nextInt();
            sc.nextLine();
            for (int w = 0; w < wordN; w++) {
                String word = sc.nextLine();
                System.out.println(word + " " + (solve(word, board, new int[5][5][word.length()]) ? "YES" : "NO"));
            }
        }
    }

    public static boolean solve(String word, char[][] board, int[][][] cache) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == word.charAt(0) && recursive(0, word, x, y, board, cache) == 1)
                    return true;
            }
        }
        return false;
    }

    public static int recursive(int index, String word, int x, int y, char[][] board, int[][][] cache) {
        if (index == word.length())
            return 1;
        if (y < 0 || x < 0 || y >= 5 || x >= 5)
            return -1;
        if (word.charAt(index) != board[y][x])
            return -1;
        if (cache[y][x][index] != 0)
            return cache[y][x][index];
        for (int i = 0; i < 8; i++) {
            if (recursive(index + 1, word, x + dx[i], y + dy[i], board, cache) == 1)
                return cache[y][x][index] = 1;
        }
        return cache[y][x][index] = -1;
    }

}