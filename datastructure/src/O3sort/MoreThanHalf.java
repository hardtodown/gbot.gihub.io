package O3sort;

import java.util.Arrays;

public class MoreThanHalf {
    public static void solve1(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length/2]);
    }

    public static void solve2(int[] arr) {
        int res = selectK.selectK(arr,0,arr.length-1,arr.length/2);
        System.out.println(res);
    }

    public static void solve3(int[] arr) {
        int candidate = arr[0];
        int nTimes = 1;
        for (int i = 0; i < arr.length; i++) {
            if (nTimes == 0) {
                candidate = arr[i];
                nTimes = 1;
                continue;
            }
            if (candidate == arr[i]) {
                nTimes++;
            } else {
                nTimes--;
            }
        }
        System.out.println(candidate);
    }

    public static void solve4(int[] arr){
        int candidate = arr[0];
        int nTimes = 1;
        int countOfLast = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[arr.length - 1]) {
                countOfLast++;
            }
            if (nTimes == 0) {
                candidate = arr[i];
                nTimes = 1;
                continue;
            }
            if (candidate == arr[i]) {
                nTimes++;
            } else {
                nTimes--;
            }
        }
        if (countOfLast == arr.length/2) {
            System.out.println(arr.length-1);
        } else {
            System.out.println(candidate);
        }

    }

}
