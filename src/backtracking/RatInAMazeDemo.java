package backtracking;/* Created by vermak5 on 11/30/2015 */

public class RatInAMazeDemo {

    public static void main(String[] args) {

        boolean[][] maze = TestMaze();

        solveMaze(maze);
    }

    // Test data
    private static boolean[][] TestMaze() {
        return new boolean[0][];
    }

    /*
     * Questions:
     * 1. Why use another sol matrix
     * 2. Understand going right and down. Could be any thing else. (startPoint, possible direction)
     * 3. Backtrack baby / Understand the POV of recursion
     */
    private static void solveMaze(boolean[][] maze) {
        int n = maze.length;
        boolean[][] sol = new boolean[n][n];

        if (!solveMazeUtil(maze, 0, 0, sol))
            System.out.println("Configuration not solvable");
        else
            print2DArray(n, maze);
    }

    // main method to backtrack
    private static boolean solveMazeUtil(boolean[][] maze, int row, int col, boolean[][] sol) {
        int n = maze.length;
        if (row == n - 1 && col == n - 1) {
            sol[row][col] = true;
            return true;
        }

        // check if the node is valid
        if (isSafe(maze, row, col)) {

            // mark this part of the solution
            sol[row][col] = true;

            // check right
            if (solveMazeUtil(maze, row, col + 1, sol))
                return true;

            // check down
            if (solveMazeUtil(maze, row + 1, col, sol))
                return true;

            // backtrack, in case of success, code path never comes here
            sol[row][col] = false;
            return false;
        }

        return false;
    }

    private static boolean isSafe(boolean[][] maze, int row, int col) {
        return false;
    }

    private static void print2DArray(int n, boolean[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
