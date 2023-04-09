package O2searchAndSort;

import java.util.Arrays;
import java.util.Random;

public class bubbleSort {
    public static void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        util.Util.print(arr);
        long time = System.currentTimeMillis();
        sort(arr);
        System.out.println(System.currentTimeMillis()-time+"ms");
        util.Util.print(arr);
    }
}