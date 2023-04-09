package twelve;

import java.util.Scanner;

/*把杨辉三角按照从上到下从左到右的顺序排成一列，现给定一个正整数N，求该
正整数在该序列中第一次出现时是第几个数
样例输入 6
样例输出 13*/
public class twelve_eight {
    public static void main(String[] args) {
        int[] yanghui = new int[10001];
        int pos = 0;
        yanghui[pos++] = 1;
        for (int i = 2; i <= 101; i++) {
            yanghui[pos++] = 1;
            int tmp = yanghui[pos-i];
            for (int j = i-1; j >= 2; j--) {
                yanghui[pos++] = yanghui[pos-i] + tmp;
                tmp = yanghui[pos-i];
            }
            yanghui[pos++] = 1;
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = -1;
        for (int i = 0; i < pos; i++) {
            if (yanghui[i] == n) {
                ans = i+1;
                break;
            }
        }
        System.out.println(ans);
    }
}
