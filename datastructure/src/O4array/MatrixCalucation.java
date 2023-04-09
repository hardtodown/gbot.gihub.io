package O4array;

import java.util.Scanner;

public class MatrixCalucation {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] A = new int[M][N];
        int[][] B = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = sc.nextInt();
            }
        }*/
        int[][] A = new int[][]{
                {1,2},
                {1,-1}
        };
        int[][] B = new int[][]{
                {1,2,-3},
                {-1,1,2}
        };
    }

    public static int[][] getX(int[][] a, int[][] b) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = (a[i][j] - b[i][j])/2 + (a[i][j] - b[i][j])%2;
            }
        }
        return res;
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[a.length][b[0].length];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {    // a的行数
            for (int j = 0; j < b[0].length; j++) { // b的列数
                for (int k = 0; k < b.length; k++) {    // a的列数
                    sum += a[i][k] * b[k][j];
                }
                res[i][j] = sum;
                sum = 0;
            }
        }
        return res;
    }

    public static long[][] matrixPower(long[][] matrix, long n) {
        long[][] result = new long[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }
        while (n != 0) {
            if ((n & 1) != 0) {
                result = multiply(result, matrix);
            }
            n >>= 1;
            matrix = multiply(matrix, matrix);
        }
        return result;
    }
}
