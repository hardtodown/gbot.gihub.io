package O6math;

public class PrimeSelect {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        m1(100000);
        System.out.println("耗时："+(System.currentTimeMillis()-now)+"ms");
    }

    public static void m1(int N) {
        int n = 2;
        while (n / Math.log(n) < N) {
            n++;
        }
        int[] arr = new int[n];
        int x = 2;
        while (x < n) {
            if (arr[x] != 0) {
                x++;
                continue;
            }
            int k = 2;
            while (x * k < n) {
                arr[x * k++] = -1;
            }
            x++;
        }
        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum++;
            }
            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
    }
}
