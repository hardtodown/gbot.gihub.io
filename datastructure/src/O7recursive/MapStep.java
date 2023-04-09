package O7recursive;

public class MapStep {
    public static void main(String[] args) {
        System.out.println(solve1(2, 3));
    }

    public static int solve(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        return solve(x - 1, y) + solve(x, y - 1);
    }

    public static int solve1(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        int[][] state = new int[x][y];
        for (int i = 0; i < x; i++) {
            state[i][0] = 1;
        }
        for (int i = 0; i < y; i++) {
            state[0][i] = 1;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                state[i][j] = state[i - 1][j] + state[i][j - 1];
            }
        }
        return state[x - 1][y - 1];
    }
}
