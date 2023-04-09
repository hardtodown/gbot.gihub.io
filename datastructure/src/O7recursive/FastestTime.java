package O7recursive;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

public class FastestTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = sc.nextInt();
            }
            Arrays.sort(speed);
            solve(n, speed);
        }
    }

    public static void solve(int n, int[] speed) {
        int left = n;
        int ans = 0;
        while (left > 0) {
            if (left == 1) {
                ans += speed[0];
                break;
            } else if (left == 2) {
                ans += speed[1];
                break;
            } else if (left == 3) {
                ans += speed[2] + speed[0] + speed[1];
                break;
            } else {
                int s1 = speed[1] + speed[0] + speed[left - 1] + speed[1];
                int s2 = speed[left - 1] + speed[left - 2] + 2*speed[0];
                ans += min(s1, s2);
                left -= 2;
            }
        }
        System.out.println(ans);
    }
}
