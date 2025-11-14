package Streak_2;

//2536. Increment Submatrices by One

class Solution7 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n+1][n+1];
        for(int[] query : queries){
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            diff[r1][c1]++;
            diff[r2+1][c2+1]++;
            diff[r1][c2+1]--;
            diff[r2+1][c1]--;
        }
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>0){
                    diff[i][j] += diff[i-1][j];
                }
                if(j>0){
                    diff[i][j] += diff[i][j-1];
                }
                if(i>0 && j>0){
                    diff[i][j] -= diff[i-1][j-1];
                }
                matrix[i][j] = diff[i][j];
            }
        }
        return matrix;
    }
}
