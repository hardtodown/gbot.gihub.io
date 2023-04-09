package twelve;
/*你有一架天平，现在你要设计一套砝码，使得利用这些砝码能够称出任意小于等于N的正整数
,那么这套砝码最少要包含多少个砝码,注意砝码可以放在天平两边
输入格式
输入包含一个正整数N。
输出格式
输出一个整数代表答案
样例输入 7
样例输出 3
*/
import java.io.BufferedInputStream;
import java.util.Scanner;

public class twelve_seven {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int num = in.nextInt();
        int sum = 0, pow3 = 1, cnt = 0;

        do {
            sum += pow3;
            pow3 *= 3;
            cnt++;
        } while (sum < num);

        System.out.println(cnt);
    }
}
