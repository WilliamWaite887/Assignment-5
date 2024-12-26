public class WordSearchPuzzle implements WordSearchInterface {
    
    @Override
    public boolean isIncreasingSequencePossible(char[][] grid, int startRow, int startCol, int endRow, int endCol){
        if (startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0 || 
        startRow >= grid.length || startCol >= grid[0].length || 
        endRow >= grid.length || endCol >= grid[0].length) {
        throw new IndexOutOfBoundsException("out of bounds");
    }
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    return solve(grid, startRow, startCol, endRow, endCol, visited);
}
    public boolean solve(char[][] grid, int currentRow, int currentCol, int endRow, int endCol, boolean[][] visited){
        // base case
        if (currentCol == endCol && currentRow == endRow){
            return true;
        }
        visited[currentRow][currentCol] = true;

        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                if (i == 0 && j ==0){
                    continue;
                }
                int newRow = currentRow + i;
                int newCol = currentCol + j;
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && !visited[newRow][newCol]){              
                    if (grid[newRow][newCol] > grid[currentRow][currentCol]){
                        if (solve(grid, newRow, newCol, endRow, endCol, visited)) {
                            return true;
                        }
                    }
                }
            }
        }
        visited[currentRow][currentCol] = false;
        return false;
    }
}
