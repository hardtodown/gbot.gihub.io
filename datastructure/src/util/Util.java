package util;

import java.util.Arrays;

public class Util {
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void print(int[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }
}
