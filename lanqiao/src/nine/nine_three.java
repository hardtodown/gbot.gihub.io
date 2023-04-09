package nine;

import java.math.BigInteger;

/*设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。
答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，
实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，
(2+3i)^5 的写成: 122-597i*/
public class nine_three {
    public static void main(String[] args) {
        BigInteger v = BigInteger.valueOf(2);
        BigInteger i = BigInteger.valueOf(3);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger three = BigInteger.valueOf(3);
        for (int j = 1; j < 123456; j++) {             // 可以使用快速幂运算效率变成logn
            BigInteger v1 = v.multiply(two).subtract(i.multiply(three));
            BigInteger i1 = i.multiply(two).add(v.multiply(three));
            v = v1;
            i = i1;
        }
        System.out.println(v.toString()+(i.compareTo(BigInteger.ZERO) < 0?'-':'+')+ i +'i');
    }
}
