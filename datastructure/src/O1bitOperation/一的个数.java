package O1bitOperation;

import java.util.Scanner;

public class 一的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(Integer.toString(a,2));  // 以二进制形式输出

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((a&(1<<i))==(1<<i)) // 让1左移比较
            {
                count++;
            }
        }
        System.out.println(count);

        count = 0;
        for (int i = 0; i < 32; i++) {
            if ((a>>>i&1)==1)  // 让a无符号右移比较
            {
                count++;
            }
        }
        System.out.println(count);
        sc.close();

        count = 0;
        while (a != 0) {
            a = a&(a-1);  // 每次消除最低位置的1
            count++;
        }
        System.out.println(count);  // count为一时该数为2的整数次方（二进制中只有一个1）
    }
}
