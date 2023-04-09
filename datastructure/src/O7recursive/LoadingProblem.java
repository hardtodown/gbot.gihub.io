package O7recursive;

import java.util.Arrays;
import java.util.Scanner;

public class LoadingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int  C = sc.nextInt();
        Arrays.sort(w);
        int ans = solve(n, w, C);
        System.out.println(ans);
    }

    public static int solve(int n, int[] w, int c) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            sum += w[i];
            if (sum <= c) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
