package O2searchAndSort;

import java.util.Scanner;

public class 上楼梯模型 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = f2(n);
        System.out.println(res);
    }

    public static int f(int n) {
        if (n == 0)
            return 1;
        if(n < 3)
            return n;
        return f(n - 1) + f(n - 2) + f(n - 3);
    }

    public static int f2(int n) {
        if (n == 0)
            return 1;
        if (n < 3)
            return n;
        int x1 = 1;
        int x2 = 2;
        int x3 = 4;
        for (int i = 4; i <= n; i+=3) {
            x1 += x2 + x3;
            x2 += x1 + x3;
            x3 += x1 + x2;
        }
        if (n % 3 == 0) {
            return x3;
        } else if (n % 3 == 1) {
            return x1;
        } else {
            return x2;
        }
    }
}
