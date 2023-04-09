package O3sort;
import util.Util;

import java.util.Random;

public class quickSort {
    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition2(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
    }
    // 单向扫描
    public static int partition(int[] arr, int p, int r) {
        int sp = p + 1;
        int bigger = r;
        while (sp <= bigger) {
            if(arr[sp] <= arr[p]) {
                sp++;
            }
            else {
                Util.swap(arr,sp,bigger);
                bigger--;
            }
        }
        Util.swap(arr,p,bigger);
        return bigger;
    }
    // 双向扫描
    public static int partition2(int[] arr, int p, int r) {
        int sp = p + 1;
        int bigger = r;
        while (sp <= bigger) {
            while (sp<=bigger && arr[sp] <= arr[p]) {
                sp++;
            }
            while (sp<=bigger && arr[bigger] > arr[p]) {
                bigger--;
            }
            if (sp<bigger)
                Util.swap(arr,sp,bigger);
        }
        Util.swap(arr,p,bigger);
        return bigger;
    }
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        Util.print(arr);
        long time = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        System.out.println(System.currentTimeMillis()-time+"ms");
        Util.print(arr);
    }
}
