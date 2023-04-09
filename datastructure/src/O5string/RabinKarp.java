package O5string;
import static O2searchAndSort.a的n次幂.pow;

public class RabinKarp {
    public static void main(String[] args) {
        String s = "ABABABA";
        String p = "ABA";
        match(p, s);
    }

    public static void match(String p, String s) {
        long hash_p = hash(p);
        /*int p_len = p.length();
        for (int i = 0; i + p_len <= s.length(); i++) {
            long hash_i = hash(s.substring(i, i + p_len));
            if (hash_i == hash_p) {
                System.out.println("match:" + i);
            }
        }*/
        long[] hashOfS = hash(s, p.length());
        match(hash_p,hashOfS);
    }

    public static void match(long hash_p, long[] hash_s) {
        for (int i = 0; i < hash_s.length; i++) {
            if (hash_s[i] == hash_p) {
                System.out.println("match:" + i);
            }
        }
    }
    final static long seed = 31;
    public static long hash(String str) {
        long hash = 0;
        for (int i = 0; i != str.length(); ++i) {
            hash = seed * hash + str.charAt(i);
        }
        return hash % Long.MAX_VALUE;
    }

    public static long[] hash(final String s, final int n) {
        long[] res = new long[s.length() - n + 1];
        res[0] = hash(s.substring(0, n));
        for (int i = n; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oChar = s.charAt(i - n);
            long v = (res[i - n] * seed + newChar - pow(seed, n) * oChar) % Long.MAX_VALUE;
            res[i-n+1] = v;
        }
        return  res;
    }
}
