package O6math;

public class ExtGcd {
    static long x;
    static long y;
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long ext_gcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long res = ext_gcd(b, a % b);
        long x1 = x;
        x = y;
        y = x1 - a / b * y;
        return res;
    }
    public static long linearEquation(long a, long b, long m) throws Exception {
        long d = ext_gcd(a, b);
        if (m % d != 0) {
            throw new Exception("无解");
        }
        long n = m / d;
        x *= n;
        y *= n;
        return d;
    }
    public static long inverseElement(long a, long mo) throws Exception {
        long d = linearEquation(a, mo, 1);
        x = (x % mo + mo) % mo;
        return d;
    }
    public static long linearEquationGroup(long[] a, long[] m) throws Exception {
        int len = a.length;
        if (len == 0 && a[0] == 0) {
            return m[0];
        }
        for (int i = 1; i < len; i++) {
            long a2_a1 = a[i] - a[i - 1];
            long d = linearEquation(m[i - 1], -m[i], a2_a1);
            long x0 = a[i - 1] + m[i - 1] * x;
            long lcm = m[i - 1] * m[i] / d;
            a[i] = (x0 % lcm + lcm) % lcm;
            m[i] = lcm;
        }
        return a[len - 1] % m[len - 1];
    }
}
