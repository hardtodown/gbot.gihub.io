package twelve;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

/*小蓝有一个超大的仓库，可以摆放很多货物。现在，小蓝有 n 箱货物要摆放在仓库，
每箱货物都是规则的正方体。小蓝 规定了长、宽、高三个互相垂直的方向，每箱货物的边都必须
严格平行于长、 宽、高。 小蓝希望所有的货物最终摆成一个大的立方体。即在长、宽、高的方向上
分别堆 L、W、H 的货物，满足 n = L × W × H。给定 n，请问有多少种堆放货物的方案满足要求。
例如，当 n = 4 时，有以下 6 种方案：1×1×4、1×2×2、1×4×1、2×1×2、 2 × 2 × 1、4 × 1 × 1。
请问，当 n = 2021041820210418 （注意有 16 位数字）时，总共有多少种方案？
  */
public class twelve_four {
    static long n = 2021041820210418L;
    static long ans = 0;
    public static void main(String[] args) {
        long tmp = (long) sqrt(n);
        Set<Long> set = new HashSet<>();
        for (long i = 1; i < tmp; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        Long[] arr = set.toArray(new Long[0]);
        for (long i : arr) {
            for (long j : arr) {
                for (long k : arr) {
                    if (i * j * k == n) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
