package Codesignal;

import java.util.*;

public class Codesignal_LabyrinthMatrix {

        static class Cell {
            final int x;
            final int y;

            Cell(int x, int y) {
                this.x = x;
                this.y = y;
            }

            // Could be problematic : needs more tight hashcode
            @Override
            public int hashCode() {
                return x - y;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Cell)) {
                    return false;
                }

                Cell other = (Cell) obj;
                return other.x == this.x && other.y == this.y;
            }
        }

        public static boolean func(int n, int m, int[][] obstacles, int[][] teleports) {
            Set<Cell> obstacleCells = new HashSet<>();
            Map<Cell, Cell> teleportCells = new HashMap<>();

            for (int[] obstacle : obstacles) {
                obstacleCells.add(new Cell(obstacle[0], obstacle[1]));
            }

            for (int[] teleport : teleports) {
                teleportCells.put(new Cell(teleport[0], teleport[1]), new Cell(teleport[2], teleport[3]));
            }

            int i = 0;
            int j = 0;

            while (true) {
                if (i == n - 1 && j == m - 1) return true;
                Cell current = new Cell(i, j);
                if (obstacleCells.contains(current)) {
                    return false;
                }
                if (teleportCells.containsKey(current)) {
                    Cell teleportSpot = teleportCells.get(current);
                    i = teleportSpot.x;
                    j = teleportSpot.y;
                } else {
                    if (j + 1 >= m) return false;
                    j++;
                }
            }
        }

        public static void main(String[] args) {
            int[][] teleports = {{0, 1, 1, 1}, {1, 2, 0, 2}, {0, 3, 2, 1}};
            int[][] obstacles = {{2, 0}, {1, 0}};
            System.out.println(func(3, 4, obstacles, teleports));
        }
}

