package leetcode;

public class a63 {
    public static void main(String[] args) {

    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i - 1][0] == 0) {
                while (i < m) {
                    obstacleGrid[i++][0] = 0;
                }
                break;
            }
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i - 1] == 0) {
                while (i < n) {
                    obstacleGrid[0][i++] = 0;
                }
                break;
            }
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
