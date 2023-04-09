package eleven;

import java.math.BigInteger;

/*【问题描述】
斐波那契数列满足 F1 = F2 = 1，从 F3 开始有 Fn = Fn−1 + Fn−2。请你计算 GCD(F2020, F520)。*/
public class eleven_five {
    public static void main(String[] args) {
        BigInteger num1 = BigInteger.valueOf(1);        // 初始化为1
        BigInteger num2 = BigInteger.valueOf(1);
        for(int i = 3; i <= 2020; i++) {
            BigInteger temp = num2;
            num2 = num1.add(num2);
            num1 = temp;
        }
        BigInteger f2020 = num2;

        num1 = BigInteger.valueOf(1);
        num2 = BigInteger.valueOf(1);
        for(int i = 3; i <= 520; i++) {
            BigInteger temp = num2;
            num2 = num1.add(num2);
            num1 = temp;
        }
        BigInteger f520 = num2;

        BigInteger gcd = f2020.gcd(f520);       // 内置了gcd方法可以直接调用
        System.out.println(gcd);
    }
}
