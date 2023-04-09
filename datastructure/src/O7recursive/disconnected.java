package O7recursive;

import java.util.Scanner;

public class disconnected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        dfs(a, 0);
        System.out.println(cnt);
    }
    static int cnt = 0;
    public static void dfs(int[] a, int row) {
        if (row == a.length) {
            cnt++;
            return;
        }
        for (int col = 0; col < a.length; col++) {
            if (check(a, row, col)) {
                a[row] = col;
                dfs(a, row + 1);
                a[row] = 0;
            }
        }
    }

    public static boolean check(int[] a, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (i - a[i] == row - col || i + a[i] == row + col || a[i] == col) {
                return false;
            }
        }
        return true;
    }
}
