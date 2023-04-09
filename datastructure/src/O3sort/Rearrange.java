package O3sort;

import java.util.Random;

public class Rearrange {
    public static int[] findSegment(int[] A, int n) {
        int p1 = -1;
        int p2 = -1;
        int max = A[0];
        int min = A[n -1];
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < max) {
                p2 = i;
            }
        }
        for (int i = n - 1; i >= 0 ; i--) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > min) {
                p1 = i;
            }
        }
        if (p1 == -1) {
            return new int[]{0, 0};
        }
        return new int[]{p1,p2};
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
        }
        util.Util.print(arr);
        int[] res = findSegment(arr,arr.length);
        util.Util.print(res);
    }
}
