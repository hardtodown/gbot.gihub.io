package O3sort;

import java.util.Random;

public class dropSort {
    public static int findTarget(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            int midval = arr[mid];
            if (mid == low) {
                if (midval >= key)
                    return mid;
                else if (arr[high] <= key)
                    return high+1;
                else
                    return high;
            }
            if (midval < key)
                low = mid + 1;
            else if (midval > key)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    public static int[] sort(int[] arr) {
        int[] tmp = new int[arr.length];
        int j = 0;
        tmp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int target = findTarget(tmp,0,i-1,arr[i]);
            for (int k = i; k > target; k--) {
                tmp[k] = tmp[k-1];
            }
            tmp[target] = arr[i];
        }
        return tmp;
    }
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        util.Util.print(arr);
        long time = System.currentTimeMillis();
        arr = sort(arr);
        System.out.println(System.currentTimeMillis()-time+"ms");
        util.Util.print(arr);
    }
}
