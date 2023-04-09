package O6math;

import java.util.Scanner;

import static java.lang.Math.abs;

public class ExtGcdDemo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();  // 坐标
        long y = sc.nextInt();  // 坐标
        long m = sc.nextInt();  // A一次跳长度
        long n = sc.nextInt();  // B一次跳长度
        long L = sc.nextInt();  // 维度总长度
        long a = m -n;
        long b = L;
        m = y -x;
        long d = 0;
        try {
            d = ExtGcd.linearEquation(a, b, m);
            long x0 = ExtGcd.x;
            b /= d;
            b = abs(b);
            x0 = (x0 % b + b) % b;
            System.out.println(x0);
        } catch (Exception e) {
            System.out.println("Impossible");
        }
    }
}
