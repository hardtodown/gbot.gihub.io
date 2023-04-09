package nine;

import java.util.Arrays;
import java.util.Scanner;

/*给定三个整数数组
A = [A1, A2, ... AN],
B = [B1, B2, ... BN],
C = [C1, C2, ... CN]，
请你统计有多少个三元组(i, j, k) 满足：
1 <= i, j, k <= N
Ai < Bj < Ck
输入格式:
第一行包含一个整数N。
第二行包含N个整数A1, A2, ... AN。
第三行包含N个整数B1, B2, ... BN。
第四行包含N个整数C1, C2, ... CN。
输出格式: 一个整数表示答案
输入样例
3
1 1 1
2 2 2
3 3 3
输出样例:27*/
public class nine_six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (A[i] < B[j] && B[j] < C[k]) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
