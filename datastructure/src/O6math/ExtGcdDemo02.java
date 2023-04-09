package O6math;

import java.util.Scanner;

public class ExtGcdDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int B = sc.nextInt();
            try {
                ExtGcd.inverseElement(B, 9973);
                long x = ExtGcd.x;
                System.out.println(x * n % 9973);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
