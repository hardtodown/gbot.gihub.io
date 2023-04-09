package O2searchAndSort;
import util.Util;

public class 递归前引 {
    /*递归求阶层*/
    public static int f1(int n)
    {
        if (n == 1)
            return 1;
        return n * f1(n-1);
    }
    /*打印i到j*/
    public static void f2(int i, int j)
    {
        if (i > j)
            return;
        System.out.println(i);
        f2(i+1,j);
    }
    /*递归求数组元素之和*/
    public static int f3(int[] arr, int begin)
    {
        if (begin==arr.length-1)
            return arr[begin];
        return arr[begin] + f3(arr,begin+1);
    }
    /*递归翻转字符串*/
    public static String reverse(String s,int length)
    {
        if (length == 0)
            return s.charAt(0)+"";
        return s.charAt(length) + reverse(s,length-1);
    }
    /*递归求斐波那契第n个数的大小*/
    public static int fib(int n)
    {
        if (n == 1 || n == 2)
            return 1;
        return fib(n-1) + fib(n-2);
    }
    /*递归求最大公约数*/
    public static int gcd(int m, int n)
    {
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }
    /*递归实现插入排序*/
    public static void insertSort(int[] arr, int k)
    {
        if (k == 0)
            return;
        insertSort(arr,k-1);
        int x = arr[k];
        int index = k-1;
        while (index>-1 && x < arr[index])
        {
            arr[index+1] = arr[index];
            index--;
        }
        arr[index+1] = x;
    }
    /*汉诺塔模型*/
    public static void a ( int N, String from, String to, String helper) {
        if (N == 1) {
            System.out.println("move " + N + " from " + from + " to " + to);
        } else {
            a(N - 1, from, helper, to);
            System.out.println("move " + N + " from " + from + " to " + to);
            a(N - 1, helper, to, from);
        }
    }
    public static void main(String[] args) {
        System.out.println(f3(new int[]{1,2,3,4,5},0));
        f2(1,10);
        System.out.println(f1(4));
        System.out.println(reverse("12345",4));
        System.out.println(fib(4));
        System.out.println(gcd(6,4));
        int[] a = new int[]{6,5,2,3,8};
        insertSort(a,4);
        Util.print(a);
        a(3,"a","b","c");
    }
}
