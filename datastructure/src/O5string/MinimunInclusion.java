package O5string;

import java.util.Arrays;

public class MinimunInclusion {
    public static int indexOf(String[] q, String word) {
        for (int i = 0; i < q.length; i++) {
            if (q[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
    public static void minmunKeys(String[] lines, String[] keys) {
        int begin = -1;
        int end = -1;
        int p2 = -1;
        int len = Integer.MAX_VALUE;
        int[] keyfound = new int[keys.length];
        for (int i = 0; i < lines.length; i++) {
            Arrays.fill(keyfound,0);
            String word1 = lines[i];
            int index = indexOf(keys, word1);
            if (index == -1) {
                continue;
            } else {
                keyfound[index] = 1; // 标记第一个关键字
            }
            int j;
            if (p2 != -1) {
                j = p2;
            } else {
                j = i + 1;
            }
            for (; j < lines.length; j++) {
                String word2 = lines[j];
                int index1 = indexOf(keys, word2);
                if (index1 == -1 || keyfound[index1] == 1) {
                    continue;
                } else {
                    keyfound[index1] = 1;
                    if (sum(keyfound) == keys.length) {
                        p2 = j;
                        if (j - i + 1 < len) {
                            len = j - i + 1;
                            begin = i;
                            end = j;
                        }
                        break;
                    }
                }
            }
        }
        print(lines, begin, end);
    }

    private static void print(String[] lines, int begin, int end) {
        System.out.println(begin + " " + end);
        for (int i = begin; i <= end; i++) {
            System.out.println(lines[i] + " ");
        }
    }

    private static int sum(int[] keyfound) {
        int sum = 0;
        for (int e:keyfound) {
            sum += e;
        }
        return sum;
    }

    public static void main(String[] args) {
        minmunKeys(new String[]{"a", "b", "c", "d", "h", "e", "f", "c", "c", "d", "e", "f", "d", "c"}, new String[]{"c", "e"});
        minmunKeys(new String[]{"a", "b", "c", "d", "h", "e", "f", "c", "c", "d", "e", "f", "d", "c"}, new String[]{"c", "e"});
    }
}
