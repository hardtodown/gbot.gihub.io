package ten;

/*把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包
含数字 2 和 4，一共有多少种不同的分解方法？
注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和
1001+1000+18 被视为同一种。*/
public class ten_four {
    public static boolean contains(int n) {     // 判断是否包含
        while (n > 0) {
            if (n % 10 == 2 || n % 10 == 4) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1; i < 2019; i++) {        // 暴力破解
            if (contains(i)) continue;          // 判断减少循环次数
            for (int j = 1; j < 2019; j++) {
                if (contains(j)) continue;
                for (int k = 1; k < 2019; k++) {
                    if (contains(k)) continue;
                    if (i == j || i == k || j == k) continue;
                    if (i + j + k == 2019) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt/6);              // 三个数排列6种情况取其一
    }
}
