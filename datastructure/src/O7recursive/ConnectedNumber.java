package O7recursive;

import java.util.Scanner;

public class ConnectedNumber {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        n = N;
        m = M;
        sc.nextLine();
        char[][] a = new char[N][];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 'W') {
                    dfs(a, i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(char[][] a, int i, int j) {
        a[i][j] = '.';
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0) {
                    continue;
                }
                if (k + i >= 0 && k + i <= n - 1 && l + j >= 0 && j + l <= m - 1) {
                    if (a[i + k][j + l] == 'W') {
                        dfs(a, i + k, j + l);
                    }
                }
            }
        }
    }
}
