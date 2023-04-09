package O6math;

import static java.lang.Math.abs;

public class ExtGcdDemo {
    public static void main(String[] args) {
        try {
            long ans = ExtGcd.linearEquation(97, -127, 1);
            long x = ExtGcd.x;
            long y = ExtGcd.y;
            System.out.println(abs(x) + abs(y));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
