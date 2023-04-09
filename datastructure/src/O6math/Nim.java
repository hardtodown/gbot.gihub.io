package O6math;

public class Nim {
    public static void main(String[] args) {
        int[] A = {3, 4, 5};
        boolean res = solve(A);
        System.out.println(res);
    }

    public static boolean solve(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res != 0;
    }
}
