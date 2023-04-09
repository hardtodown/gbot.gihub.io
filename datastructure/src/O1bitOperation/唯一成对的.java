package O1bitOperation;

import util.Util;
import java.util.*;

public class 唯一成对的 {

    public static void main(String[] args) {
        int N = 11;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = i + 1;
        }
        arr[arr.length-1] = new Random().nextInt(N - 1) + 1;
        int index = new Random().nextInt(N);
        Util.swap(arr,index,arr.length-1);
        Util.print(arr);
        int x = 0;
        for (int i = 1; i < N; i++) {
            x = x^i;
        }
        for (int i = 0; i < N; i++) {
            x = x^arr[i];
        }
        System.out.println(x);
        System.out.println("=============");
        int[] helper = new int[N]; // 开辟一块辅助空间
        for (int i = 0; i < N; i++) {
            if (helper[arr[i]] == 0)
            {
                helper[arr[i]] = 1;  // 元素值作为下标索引
            }
            else
            {
                System.out.println(arr[i]);
            }
        }
    }
}
