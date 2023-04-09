package O4array;

public class MaxSquare {
    static int[][][] rec;
    public static int solve(int[][] A) {
        int N = A.length;
        int n = N;
        while (n > 0) {
            for (int i = 0; i < N; i++) {
                if (i + n > N) {
                    break;
                }
                l3:
                for (int j = 0; j < N; j++) {
                    if (j + n > N) {
                        break;
                    }
                    if (check(i, j, n)) {
                        return n;
                    }
                }
            }
            n--;
        }
        return n;
    }

    private static boolean check(int i, int j, int n) {
        if (rec[i][j][0]>=n&&rec[i][j][1]>=n&&rec[i][j+n-1][1]>=n&&rec[i+n-1][j][0]>=n)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] A;
        A = new int[][]{
                {1,1,1,1},
                {1,1,0,0},
                {1,0,1,1},
                {0,1,0,1},
        };
        help(A);
        print(rec, A.length);
        int rec = solve(A);
        System.out.println(rec);
    }

    private static void print(int[][][] rec,int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(rec[i][j][0]+","+rec[i][j][1]+"\t");
            }
            System.out.println();
        }
    }

    private static void help(int[][] A) {
        int N = A.length;
        rec = new int[N][N][2];
        int row = N - 1;
        for (int j = N-1; j >= 0 ; j--) {
            int value = A[row][j];
            if (value == 1) {
                if (j == N - 1) {
                    rec[row][j][0] = 1;
                } else {
                    rec[row][j][0] += rec[row][j + 1][0] + 1;
                }
                rec[row][j][1] = 1;
            }
        }
        row--;
        for (int i = row; i >= 0; i--) {
            for (int j = N-1; j >= 0 ; j--) {
                int value = A[i][j];
                if (value == 1) {
                    if (j == N - 1) {
                        rec[i][j][0] = 1;
                    } else {
                        rec[i][j][0] += rec[i][j + 1][0] + 1;
                    }
                    rec[i][j][1] += rec[i + 1][j][1] + 1;
                }
            }
        }
    }
}
