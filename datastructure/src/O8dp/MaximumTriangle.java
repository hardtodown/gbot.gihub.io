package O8dp;

public class MaximumTriangle {
    public static int dfs(int[][] triangle, int i, int j) {
        int rowIndex = triangle.length;
        if (i == rowIndex - 1) {
            return triangle[i][j];
        } else {
            return triangle[i][j] + Math.max(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1));
        }
    }

    public static int mDfs(int[][] triangle, int i, int j, int[][] map) {
        int rowIndex = triangle.length;
        int value = triangle[i][j];
        if (i == rowIndex - 1) {
            return triangle[i][j];
        }else {
            int v1 = map[i + 1][j];
            if (v1 == 0) {
                map[i + 1][j] = mDfs(triangle, i + 1, j,map);
            }
            int v2 = map[i + 1][j+1];
            if (v2 == 0) {
                map[i + 1][j+1] = mDfs(triangle, i + 1, j+1,map);
            }
            value = value + Math.max(v1, v2);
            map[i][j] = value;
            return value;
        }
    }

    public static int dp(int[][] triangle, int i, int j) {
        int rowCount = triangle.length;
        int columnCount = triangle[rowCount - 1].length;
        int[] states = new int[columnCount];
        for (int k = 0; k < columnCount; k++) {
            states[k] = triangle[rowCount-1][k];
        }
        for (int row = rowCount-2; row >= 0; row--) {
            for (int col = 0; col < triangle[row].length; col++) {
                states[col] = triangle[row][col] + Math.max(states[col], states[col + 1]);
            }
        }
        return states[0];
    }
    public static void main(String[] args) {

    }
}
