package ten;

/*给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求
        第 20190324 项的最后 4 位数字。*/
public class ten_three {
    public static void main(String[] args) {
//        System.out.println(solve(20190324));
        int f = 1;
        int s = 1;
        int t = 1;
        for (int i = 4; i < 20190324; i += 3) {
            int sum = (f + s + t)%10000;            // 下一个状态
            f = s;
            s = t;
            t = sum;                                // 依次代表下一个状态数，整体移位
        }
        System.out.println(t);
    }
    /*会爆栈，可尝试使用带记忆缓存*/
    public static int solve(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return 1;
        }
        return (solve(n - 1)%10000 + solve(n - 2)%10000 + solve(n - 3)%10000)%10000;
    }
}
