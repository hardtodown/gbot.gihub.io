package O7recursive;

import java.util.Scanner;

public class PrimeRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        a[0] = 1;
        dfs(N ,a ,1);
    }

    public static void dfs(int n, int[] A, int cur) {
        if (cur == n && isP(A[0]+A[n-1])) {
            print(A);
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (check(A, i, cur)) {
                A[cur] = i;
                dfs(n, A, cur + 1);
                A[cur] = 0;
            }
        }
    }

    public static boolean check(int[] A, int i, int cur) {
        for (int e:A) {
            if (e == i || !isP(A[cur - 1] + i)) {
                return false;
            }
        }
        return true;
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + (i == A.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static boolean isP(int k) {
        for (int i = 2; i*i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
