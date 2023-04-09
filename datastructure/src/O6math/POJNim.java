package O6math;

import java.util.Arrays;
import java.util.Scanner;

public class POJNim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        int[][] data = new int[caseNum][];
        for (int i = 0; i < caseNum; i++) {
            int k = sc.nextInt();
            data[i] = new int[k];
            for (int j = 0; j < caseNum; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < caseNum; i++) {
            String res = deal(data[i]);
            System.out.println(res);
        }
    }

    public static String deal(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        int res = 0;
        if ((len & 1) == 1) {
            for (int i = 0; i < len; i+=2) {
                res ^= (i==0)?(A[0]-1):(A[i]-A[i-1]-1);
            }
        } else {
            for (int i = 0; i < len; i+=2) {
                res ^= (A[i]-A[i-1]-1);
            }
        }
        if (res == 0) {
            return "Bob will win";
        } else {
            return "Georgia will win";
        }
    }
}
