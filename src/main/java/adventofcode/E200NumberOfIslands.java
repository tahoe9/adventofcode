package adventofcode;

public class E200NumberOfIslands {
    public int numIslands(char[][] grid) {

        int count = 0;

        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;

        if (grid[row][col] == '0') return;

        if (grid[row][col] == '*') return;

        grid[row][col] = '*';

        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row+1, col);
    }

    public static void main(String[] strings) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
                };
        System.out.println(new E200NumberOfIslands().numIslands(grid) == 1);
    }
}
