package thirteen;

import java.util.Scanner;

/*满足N!的末尾恰好有K个 0 的最小的N是多少?
如果这样的N不存在输出-1 。
样例输入:2
样例输出:10*/
public class thirteen_five {
    public static long nums(long n) {
        long res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();
        long l = 1, r = Long.MAX_VALUE - 1;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (nums(mid) < K) {
                l = mid + 1;
            }else if (nums(mid) > K){
                r = mid - 1;
            }else {
                System.out.println(mid-mid%5);
                return;
            }
        }
        System.out.println(-1);
    }
}
