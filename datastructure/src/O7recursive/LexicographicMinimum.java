package O7recursive;

import java.util.Scanner;

public class LexicographicMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(sc.next());
        }
        solve(sb.toString());
    }

    public static void solve(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        StringBuilder sb2 = new StringBuilder();
        int N = s.length();
        int cnt = 0;
        while (sb2.length() < N) {
            if (s.compareTo(s1) <= 0) {
                sb2.append(s.charAt(0));
                s = s.substring(1);
            } else {
                sb2.append(s1.charAt(0));
                s1 = s1.substring(1);
            }
            if (sb2.length() % 80 == 0) {
                System.out.println(sb2.substring(cnt * 80, (cnt + 1) * 80));
                cnt++;
            }
        }
        if (sb2.length() > cnt * 80) {
            System.out.println(sb2.substring(cnt * 80));
        }
    }
}
