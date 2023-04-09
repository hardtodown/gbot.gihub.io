package O3sort;

public class ContainsAll {
    public static boolean check(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            if (s2.indexOf(a) == -1) {
                return false;
            }
        }
        return true;
    }
}
