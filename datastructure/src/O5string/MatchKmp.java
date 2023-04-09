package O5string;

public class MatchKmp {
    public static int indexOf(String src, String key) {
        for (int i = 0; i < src.length(); i++) {
            for (int j = i; j < key.length(); j++) {
                if (src.charAt(j) != key.charAt(j-i)) {
                    break;
                } else if (j == key.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int indexOf1(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return -1;
        }
        if (p.length() > s.length()) {
            return -1;
        }
        int[] next = next(p);
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = p.length();
        while (i < slen) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == plen) {
                return (i - j);
            }
        }
        return -1;
    }

    public static int[] next(String ps) {
        int plength = ps.length();
        int[] next = new int[plength];
        char[] p = ps.toCharArray();
        next[0] = -1;
        if (ps.length() == 1) {
            return next;
        }
        next[1] = 0;
        int j = 1;
        int k = next[j];
        while (j < plength - 1) {
            if (k < 0 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s1 = "ababba";
        String s2 = "bab";
        System.out.println(indexOf1(s1,s2));
    }
}
