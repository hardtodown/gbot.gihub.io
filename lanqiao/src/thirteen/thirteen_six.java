package thirteen;

import java.util.Scanner;

/*小明有一个大小为N×M的矩阵，可以理解为一个N行M列的二维数组。
我们定义一个矩阵m的稳定度 f(m)为 f(m) =max(m)−min(m)，其中max(m)
表示矩阵m中的最大值，min(m)表示矩阵m中的最小值。现在小明想要从这
个矩阵中找到一个稳定度不大于limit的子矩阵，同时他还希望这个子矩阵的面
积越大越好（面积可以理解为矩阵中元素个数）。
子矩阵定义如下：从原矩阵中选择一组连续的行和一组连续的列，这些行
列交点上的元素组成的矩阵即为一个子矩阵。
样例输入:
3 4
2 0 7 9
0 6 9 7
8 4 6 4
8
样例输出:6*/
public class thirteen_six {
    static int[][] arr;

    public static void Java_B_F() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int limit = scanner.nextInt();
        int max_area = Integer.MIN_VALUE;
        for (int i = N; i > 0; i--) {
            for (int j = M; j > 0; j--) { // i*j的矩阵
                for (int x = 0; x <= N - i; x++) {
                    for (int y = 0; y <= M - j; y++) { // 左上角坐标
                        int max = find_max(i, j, x, y);
                        int min = find_min(i, j, x, y);
                        if ((max - min) <= limit) {
                            max_area = Math.max(max_area, i * j);
                        }
                    }
                }
            }
        }
        System.out.println(max_area);
    }

    private static int find_min(int i, int j, int x, int y) {
        // 寻找最小值
        int res = Integer.MAX_VALUE;
        for (int n = x; n < x + i; n++) {
            for (int m = y; m < y + j; m++) {
                res = Math.min(res, arr[n][m]);
            }
        }
        return res;
    }

    private static int find_max(int i, int j, int x, int y) {
        // 寻找最大值
        int res = Integer.MIN_VALUE;
        for (int n = x; n < x + i; n++) {
            for (int m = y; m < y + j; m++) {
                res = Math.max(res, arr[n][m]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Java_B_F();
    }
}
