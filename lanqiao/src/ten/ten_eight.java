package ten;

/*小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob
有多少次同时出现。
更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：在小说文本
中 Alice 和 Bob 之间不超过 K 个字符。
例如以下文本：
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob”
和”Bob. Alice”。前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。
注意:

Alice 和 Bob 是大小写敏感的，alice 或 bob 等并不计算在内。
Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能
有字母。例如 Bobbi 並不算出现了 Bob。
【输入格式】
第一行包含一个整数 K。
第二行包含一行字符串，只包含大小写字母、标点符号和空格。长度不超
过 1000000。
【输出格式】
输出一个整数，表示 Alice 和 Bob 同时出现的次数。
【样例输入】
20
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
【样例输出】
2*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ten_eight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer sc = new StringTokenizer(str,". ");
        List<String> wordList = new ArrayList<>();
        while (sc.hasMoreElements()) {
            wordList.add(sc.nextToken());
        }
        String s1 = "Alice";
        String s2 = "Bob";
        int sum = 0, tmp = 0;
        while (wordList.contains(s1)&&wordList.contains(s2)) {
            if (wordList.indexOf(s1) < wordList.indexOf(s2)) {      // 判断先后
                for (int j = wordList.indexOf(s1); j < wordList.indexOf(s2); ++j) {
                    tmp = tmp + 2 + wordList.get(j).length();       // 计算距离
                }
                if (tmp <= k) {                                     // 判断是否为合法距离
                    sum++;
                }
                wordList.remove(s1);                                // 重置目标
            }
            else {
                for (int j = wordList.indexOf(s2); j < wordList.indexOf(s1); ++j) {
                    tmp = tmp + 2 + wordList.get(j).length();
                }
                if (tmp <= k) {
                    sum++;
                }
                wordList.remove(s2);
            }
        }
        System.out.println(sum);
    }
}
