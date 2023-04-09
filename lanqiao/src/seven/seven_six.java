package seven;

/*如下十个格子
  口口口
口口口口
口口口
填入0~9的数字。要求：连续的两个数字不能相邻。
（左右、上下、对角都算相邻）
一共有多少种可能的填数方案？
请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。*/
public class seven_six {
    static int[] nums = new int[10];
    static boolean[] vis = new boolean[10];
    static int cnt;

    public static void main(String[] args) {
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int cur) {
        if (cur == 10 && check(nums)) {
            cnt++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!vis[i]) {
                nums[cur] = i;
                vis[i] = true;
                dfs(cur + 1);
                vis[i] = false;
            }
        }
    }

    public static boolean check(int[] a) {
        return Math.abs(a[0] - a[1]) != 1 && Math.abs(a[1] - a[2]) != 1 && Math.abs(a[3] - a[4]) != 1 && Math.abs(a[4] - a[5]) != 1 && Math.abs(a[5] - a[6]) != 1 && Math.abs(a[7] - a[8]) != 1 && Math.abs(a[8] - a[9]) != 1 && Math.abs(a[0] - a[4]) != 1 && Math.abs(a[1] - a[5]) != 1 && Math.abs(a[2] - a[6]) != 1 && Math.abs(a[3] - a[7]) != 1 && Math.abs(a[4] - a[8]) != 1 && Math.abs(a[5] - a[9]) != 1 && Math.abs(a[0] - a[3]) != 1 && Math.abs(a[1] - a[4]) != 1 && Math.abs(a[2] - a[5]) != 1 && Math.abs(a[0] - a[5]) != 1 && Math.abs(a[1] - a[6]) != 1 && Math.abs(a[3] - a[8]) != 1 && Math.abs(a[4] - a[9]) != 1 && Math.abs(a[4] - a[7]) != 1 && Math.abs(a[5] - a[8]) != 1 && Math.abs(a[6] - a[9]) != 1;
    }
}
