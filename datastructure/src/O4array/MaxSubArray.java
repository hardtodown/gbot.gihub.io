package O4array;

import java.util.Date;

public class MaxSubArray {
    public static int findByDp(int[] arr) {
        int max = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,3,4,-2,6,-1};
        long now = new Date().getTime();
        System.out.println(findByDp(arr));
        System.out.println(new Date().getTime()-now+"ms");
    }
}
