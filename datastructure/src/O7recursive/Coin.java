package O7recursive;

public class Coin {
    public static void main(String[] args) {
        int[] coin = new int[]{1, 5, 10, 25};
        System.out.println(countWaysCore2(5, coin, 1));
    }
    public static int countWaysCore(int n, int[] coin, int cur) {
        if (cur == 0)
            return 1;
        int tmp = n / coin[cur];
        int cnt = 0;
        while (tmp >= 0) {
            cnt += countWaysCore(n - coin[cur] * tmp, coin, cur - 1);
            tmp--;
        }
        return cnt;
    }

    public static int countWaysCore2(int n, int[] coin, int cur) {
        if (cur == 0) {
            return 1;
        }
        int[][] state = new int[coin.length][n + 2];
        for (int i = 0; i <= n; i++) {
            state[0][i] = 1;
        }
        for (int i = 1; i < coin.length; i++) {
            for (int j = 0; j <= n; j++) {
                int tmp = j / coin[i];
                while (tmp >= 0) {
                    state[i][j] += state[i-1][j-coin[i]*tmp];
                    tmp--;
                }
            }
        }
        return state[cur][n];
    }
}
