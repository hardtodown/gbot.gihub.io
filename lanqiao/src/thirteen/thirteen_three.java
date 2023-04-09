package thirteen;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*给定一个只包含大写字母的字符串S，请你输出其中出现次数最多的字母。
如果有多个字母均出现了最多次，按字母表顺序依次输出所有这些字母。*/
public class thirteen_three {
    /*在一些特定的情况下，会发现由于哈希函数的巧妙设计，元素的HashCode值可以保证与元素的值有关，
    并且可以保持元素被添加进Set的顺序不变，这时，HashSet 在输出元素时就会保持它们被添加进 Set 的顺序。但是这种实现方式不可靠，
    不能依赖于元素顺序，如果需要保持元素有序，则需要使用 TreeSet。所以该题完全可以不使用set实现有风险*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cnt = new char[26];          // 记录每个字母出现次数
        String next = sc.next();
        for (int i = 0; i < next.length(); i++) {
            cnt[next.charAt(i)-65]++;
        }
        Set<Integer> set = new HashSet<>();     // 有风险，可以用TreeSet代替或者直接找cnt数组中最大值并且输出最大值代表的字母
        int sum = cnt[0];
        set.add(0);                            // 加入第一个字符对应的数字
        for (int i = 1; i < cnt.length; i++) {
            if (sum < cnt[i]) {
                sum = cnt[i];
                set.clear();                   // 更新并且清空集合
                set.add(i);
            } else if (sum == cnt[i]) {
                set.add(i);
            }
        }
        for (int i:set) {
            System.out.print((char)(i+65)); // 转成字母
        }
    }
}
