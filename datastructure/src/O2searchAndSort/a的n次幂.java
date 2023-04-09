package O2searchAndSort;

import java.util.Scanner;

public class a的n次幂 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(pow(a,n));
    }

    public static long pow(long a, long n) {
        long res = a;
        int ex = 1;
        if (n == 0)
            return 1;
        while ((ex<<1)<=n) {
            res *= res;
            ex <<= 1;
        }
        return res*pow(a,n-ex);
    }
}
