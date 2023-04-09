package O3sort;

import java.util.Arrays;

public class minFreeld {
    public static int find2(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            if (i+1 != arr[i])
                return i+1;
            i++;
        }
        return i+1;
    }
    public static int find3(int[] arr) {
        int n = arr.length;
        int[] helper = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (arr[i] < n+1) {
                helper[arr[i]]=1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (helper[i]==0) {
                return i;
            }
        }
        return n+1;
    }
    public static int find4(int[] arr, int l, int r) {
        if (l > r)
            return l+1;
        int midIndex = l + ((r - l) >> 1);
        int q = selectK.selectK(arr, l, r, midIndex - l + 1);
        int t = midIndex + 1;
        if (q == t) {
            return find4(arr, midIndex + 1, r);
        } else {
            return find4(arr, l, midIndex - 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,8,9,10,11,12};
        long now = System.currentTimeMillis();
        System.out.println(find2(arr));
        System.out.println(System.currentTimeMillis() - now + "ms");

        now = System.currentTimeMillis();
        System.out.println(find4(arr,0,arr.length-1));
        System.out.println(System.currentTimeMillis()-now+"ms");
    }
}
