package O3sort;

import java.util.Random;

public class mergeSort {
    private static int[] helper;

    public static void sort(int[] arr) {
        helper = new int[arr.length];
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] A, int p, int r) {
        if (p < r) {
            int mid = p + ((r - p) >> 1);
            sort(A,p,mid);
            sort(A,mid+1,r);
            merge(A,p,mid,r);
        }
    }

    private static void merge(int[] A, int p, int mid, int r) {
        System.arraycopy(A,p,helper,p,r-p+1);
        int left = p,right = mid + 1;
        int current = p;
        while (left <= mid && right <= r) {
            if (helper[left] <= helper[right])
                A[current++] = helper[left++];
            else
                A[current++] = helper[right++];
        }
        while (left <= mid) {
            A[current] = helper[left];
            current++;
            left++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        util.Util.print(arr);
        sort(arr);
        util.Util.print(arr);
    }
}
