package O4array;

import java.util.Arrays;

public class MaxSubMatrix {
    public static int maxsum(int[][] matrix) {
        int beginRow = 0;
        final int M = matrix.length;
        final int N = matrix[0].length;
        int[] sum = new int[N];
        int max = 0;
        while (beginRow < M) {
            for (int i = beginRow; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    sum[j] += matrix[i][j];
                }
                int t = MaxSubArray.findByDp(sum);
                if (t > max) {
                    max = t;
                }
            }
            Arrays.fill(sum,0);
            beginRow++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {-1,-1,-1,-1},
                {-1,-1,2,-1},
                {-1,2,2,-1},
                {-1,-1,-1,-1}
        };
        System.out.println(maxsum(a));
    }
}
