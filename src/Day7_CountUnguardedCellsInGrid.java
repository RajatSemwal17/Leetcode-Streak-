//2257. Count Unguarded Cells in the Grid

class Solution7 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] g : guards){
            grid[g[0]][g[1]] = 2;
        }
        for(int[] w : walls){
            grid[w[0]][w[1]] = 2;
        }
        for(int[] g : guards){
            int r = g[0];
            int c = g[1];

            // right
            for(int i=c+1;i<n;i++){
                if(grid[r][i] == 2) break;
                grid[r][i] = 1;
            }
            // left
            for(int i=c-1;i>=0;i--){
                if(grid[r][i] == 2) break;
                grid[r][i] = 1;
            }
            // up
            for(int i=r-1;i>=0;i--){
                if(grid[i][c] == 2) break;
                grid[i][c] = 1;
            }
            // down
            for(int i=r+1;i<m;i++){
                if(grid[i][c] == 2) break;
                grid[i][c] = 1;
            }
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}