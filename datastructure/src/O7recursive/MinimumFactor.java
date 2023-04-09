package O7recursive;

import java.util.Scanner;

public class MinimumFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            cnt[i] = sc.nextInt();
        }
        int A = sc.nextInt();
        int res = solve(A, 5);
        System.out.println(res);
    }

    static int[] cnt = new int[6];
    static int[] coins = {1, 5, 10, 50, 100, 500};
    public static int solve(int sum, int n) {
        if (n == 0) {
            return sum;
        }
        int tmp = sum / coins[n];
        int a = Math.min(tmp, cnt[n]);
        int t = a * coins[n];
        return tmp + solve(sum - t, n - 1);
    }
}
