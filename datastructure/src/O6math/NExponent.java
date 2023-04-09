package O6math;

public class NExponent {
    public static int ex2(int n, int m) {
        int a = n;
        int res = 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                res *= a;
            }
            a = a * a;
            m >>= 1;
        }
        return res;
    }
    public static long ex2(long n, long m) {
        long a = n;
        long res = 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                res *= a;
            }
            a = a * a;
            m >>= 1;
        }
        return res;
    }
}
