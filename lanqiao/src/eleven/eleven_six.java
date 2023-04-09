package eleven;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*题目描述
输入一个字符串，请输出这个字符串包含多少个大写字母，多少个小写字母，多少个数字。
【输入格式】
输入一行包含一个字符串。
【输出格式】
输出三行，每行一个整数，分别表示大写字母、小写字母和数字的个数。
【样例输入】
1+a=Aab
【样例输出】
1
3
1*/
public class eleven_six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt = 0;
        String xPattern = "[a-z]";
        String dPattern = "[A-Z]";
        String nPattern = "\\d";
        Pattern p = Pattern.compile(xPattern);      // 直接调用函数
        Pattern p1 = Pattern.compile(dPattern);
        Pattern p2 = Pattern.compile(nPattern);
        Matcher m = p.matcher(s);
        Matcher m1 = p1.matcher(s);
        Matcher m2 = p2.matcher(s);
        while (m1.find()) {
            cnt ++;
        }
        System.out.println(cnt);
        cnt = 0;                                // 重置计数
        while (m.find()) {
            cnt ++;
        }
        System.out.println(cnt);
        cnt = 0;
        while (m2.find()) {
            cnt ++;
        }
        System.out.println(cnt);
    }
}
