package eleven;

/*给定正整数n,求1^8+2^8+...+n^8 mod 123456789,其中mod表示取余
【输入格式】
输入的第一行包含一个整数 n。
【输出格式】
输出一行，包含一个整数，表示答案。
【样例输入】
2
【样例输出】
257
【样例输入】
987654
【样例输出】
43636805*/
import java.math.BigInteger;
import java.util.Scanner;

public class eleven_seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = BigInteger.valueOf(sc.nextInt());
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger s = BigInteger.valueOf(1);
        for (BigInteger i = s; i.compareTo(n) <= 0; i=i.add(s)) {
            sum=sum.add(i.pow(8));
        }
        BigInteger m = BigInteger.valueOf(123456789);
        System.out.println(sum.mod(m));
    }
}
