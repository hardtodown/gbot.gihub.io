package O5string;

import java.util.Arrays;

public class Same {
    public static Boolean checkSame(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    public static Boolean checkSame1(String A, String B) {
        char[] flag = new char[128];
        for (int i = 0; i < A.length(); i++) {
            flag[A.charAt(i)]++;
        }
        for (int i = 0; i < B.length(); i++) {
            flag[B.charAt(i)]--;
            if (flag[B.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
