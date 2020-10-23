package Blackrock.src;

import java.util.Arrays;

public class wordSearch {
    public static void main(String[] args) {
        char[][] grid = {{'C', 'A', 'T'},
                {'I', 'D', 'O'}, {'M', 'O', 'M'}};
        String[] words = {"CAT", "TOM", "ADO", "MOM", "CDM"};
        wordSearch obj = new wordSearch();
        System.out.println(Arrays.toString(obj.function(grid, words)));
    }

    public boolean[] function(char[][] grid, String[] words) {
        final boolean[] result = new boolean[words.length];
        int id = 0;
        for (String word : words) {
//            char st = word.charAt(0);
            boolean temp = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    temp = temp || left(i, j, grid, word, 0) || right(i, j, grid, word, 0) || top(i, j, grid, word, 0) || bottom(i, j, grid, word, 0);
                    if(temp) {
                        break;
                    }
                }
                if(temp) {
                    break;
                }
            }
            result[id++] = temp;
        }
        return result;
    }

    public boolean left(int i, int j, char[][] grid, String word, int word_idx) {
        if (word_idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] != word.charAt(word_idx)) {
            return false;
        }
        return left(i, j - 1, grid, word, word_idx+1);
    }

    public boolean right(int i, int j, char[][] grid, String word, int word_idx) {
        if (word_idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] != word.charAt(word_idx)) {
            return false;
        }
        return right(i, j + 1, grid, word, word_idx+1);
    }

    public boolean top(int i, int j, char[][] grid, String word, int word_idx) {
        if (word_idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] != word.charAt(word_idx)) {
            return false;
        }
        return top(i-1, j, grid, word, word_idx+1);
    }

    public boolean bottom(int i, int j, char[][] grid, String word, int word_idx) {
        if (word_idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] != word.charAt(word_idx)) {
            return false;
        }
        return bottom(i+1, j, grid, word, word_idx+1);
    }
}
