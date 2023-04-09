package O6math;

import O4array.MatrixCalucation;

public class Fib {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(fib(i));
        }
    }

    public static long fib(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        long[][] matrix = {
                {0, 1},
                {1, 1}
        };
        long[][] res = MatrixCalucation.matrixPower(matrix, n - 1);
        res = MatrixCalucation.multiply(new long[][]{{1, 1}}, res);
        return res[0][0];
    }
}
