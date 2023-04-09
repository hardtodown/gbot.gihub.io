package O8dp;

import static java.lang.Math.max;

public class LongestIncrementalSubsequence {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 5, 6, 7, 2, 8};
        System.out.println(dp2(arr));
    }

    public static int dp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int ans = -1;
        for (int i = 1; i < arr.length; i++) {
            int cnt = 1;
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    cnt = max(cnt, dp[j]+1);
                }
            }
            dp[i] = cnt;
            ans = max(ans, dp[i]);
        }
        return ans;
    }
    public static int f(int[] arr) {
        int maxCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int p = i;
            int cnt = 1;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[p]) {
                    cnt++;
                    p = j;
                }
            }
            maxCnt = max(maxCnt, cnt);
        }
        return maxCnt;
    }
    public static int dp2(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > dp[res - 1]) {
                dp[res] = arr[i];
                res++;
            }else {
                for (int j = 0; j < res; j++) {
                    if (dp[j] > arr[i]) {
                        dp[j] = arr[i];
                    }
                }
            }
        }
        return res;
    }
}
