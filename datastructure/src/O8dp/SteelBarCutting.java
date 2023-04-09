package O8dp;

import java.util.Arrays;

import static java.lang.Math.cbrt;
import static java.lang.Math.max;

public class SteelBarCutting {
    static int n = 10;
    static int[] p = {1, 5, 8, 16, 10, 17, 17, 20, 24, 30};
    static int[] vs = new int[n+1];
    public static int r(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= x; i++) {
            if (vs[x-i] ==-1) {
                vs[x-i] = r(x-i);
            }
            int v = p[i - 1] + vs[x - i];
            ans = max(v, ans);
        }
        vs[x] = ans;
        return ans;
    }
    public static int dp() {
        vs[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                vs[i] = max(p[j - 1] + vs[i - j], vs[i]);
            }
        }
        return vs[n];
    }
    public static void main(String[] args) {
        Arrays.fill(vs, -1);
        int ans = r(n);
        System.out.println(ans);
        System.out.println(dp());
    }
}
