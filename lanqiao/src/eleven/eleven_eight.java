package eleven;

import java.util.Scanner;

/*小明发明了一种给由全大写字母组成的字符串编码的方法。对于每一个大写字母，小明将它转换成它在 26 个英文字母中序号，即 A → 1, B → 2, … Z →26。这样一个字符串就能被转化成一个数字序列：比如 ABCXYZ → 123242526。现在给定一个转换后的数字序列，小明想还原出原本的字符串。当然这样的还原有可能存在多个符合条件的字符串。小明希望找出其中字典序最大的字
符串。
【输入格式】
一个数字序列。
【输出格式】
一个只包含大写字母的字符串，代表答案
【样例输入】
123242526
【样例输出】
LCXYZ
*/
public class eleven_eight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();                   // 用字符串处理防止数值溢出
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '2' && s.charAt(i + 1) < '7')        // 增大字典序判断
            {
                sb.append((char) (s.charAt(i + 1) + 36));           // 进制转化
                i++;
            } else if (s.charAt(i) == '1') {
                sb.append((char) (s.charAt(i + 1) + 26));
                i++;
            } else{
                sb.append((char) (s.charAt(i) + 16));
            }
            if (i == s.length() - 1) {
                flag = false;
            }
        }
        if (flag) {
            sb.append(s.charAt(s.length()-1)+16);                   // 处理最后一个数
        }
        System.out.println(sb);
    }
}
