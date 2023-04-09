package O2searchAndSort;
import util.Util;

import java.util.Random;


public class shellSort {
    // 希尔排序
    public static void shellSort(int[] arr)
    {
        for (int interval = arr.length/2; interval > 0 ; interval=interval/2) {
            for (int i = interval; i < arr.length; i++) {
                int target = arr[i];
                int j = i - interval;
                while (j > -1 && target < arr[j])
                {
                    arr[j + interval] = arr[j];
                    j -= interval;
                }
                arr[j + interval] = target;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        Util.print(arr);
        long time = System.currentTimeMillis();
        shellSort(arr);
        System.out.println(System.currentTimeMillis()-time+"ms");
        Util.print(arr);
    }
}
