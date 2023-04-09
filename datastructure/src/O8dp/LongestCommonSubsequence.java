package O8dp;

import java.util.ArrayList;

public class LongestCommonSubsequence {
    public static ArrayList<Character> dfs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        ArrayList<Character> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    list.add(s1.charAt(i));
                    list.addAll(dfs(s1.substring(i + 1), s2.substring(j + 1)));
                    break;
                }
            }
            if (list.size() > ans.size()) {
                ans = list;
            }
        }
        return ans;
    }

    public static String dp(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int flag = 0;
        for (int i = 1; i <= len1; i++) {
            if (flag == 1) {
                dp[i][1] = 1;
            } else if (s1.charAt(i - 1) == s2.charAt(0)) {
                dp[i][1] = 1;
            }else {
                dp[i][1] = 0;
            }
        }
        flag = 0;
        for (int i = 1; i <= len2; i++) {
            if (flag == 1) {
                dp[1][i] = 1;
            } else if (s2.charAt(i - 1) == s1.charAt(0)) {
                flag = 1;
            }else {
                dp[1][i] = 0;
            }
        }
        for (int i = 2; i <= len1; i++) {
            for (int j = 2; j <= len2; j++) {
                int maxOfLeftAndUp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(maxOfLeftAndUp, dp[i - 1][j - 1] + 1);
                }else {
                    dp[i][j] = maxOfLeftAndUp;
                }
            }
        }
        return parseDp(dp, s1, s2);
    }

    public static String parseDp(int[][] dp, String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        StringBuilder sb = new StringBuilder();
        while (M > 0 && N > 0) {
            if (dp[M][N] > Math.max(dp[M - 1][N], dp[M][N - 1])) {
                sb.insert(0, s1.charAt(M - 1));
                M--;
                N--;
            }else {
                if (dp[M - 1][N] > dp[M][N - 1]) {
                    M--;
                }else {
                    N--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(dp("AB34C","A1BC2"));
    }
}
