package O7recursive;

import java.util.Scanner;

public class AdjacentNonRepeatingString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int n = sc.nextInt();
//        dfs(l, n, "");
    }
    static int cnt;
    public static void dfs(int l, int n, String s) {
        for (char i = 'A'; i < 'A'+l; i++) {
            if (isHard(s, i)) {
                String x = s + i;
                System.out.println(x);
                cnt++;
                if (cnt == n) {
                    System.exit(0);
                }
                dfs(l, n, x);
            }
        }
    }

    public static boolean isHard(String s, char i) {
        int cnt = 0;
        for (int j = s.length()-1; j >= 0; j-=2) {
            final String s1 = s.substring(j, j + cnt + 1);
            final String s2 = s.substring(j + cnt + 1) + i;
            if (s1.equals(s2)) {
                return false;
            }
            cnt++;
        }
        return true;
    }
}
