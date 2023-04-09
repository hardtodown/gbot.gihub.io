package O7recursive;

import java.util.HashSet;
import java.util.Set;

public class LegalBrackets {
    public static void main(String[] args) {
        LegalBrackets lg = new LegalBrackets();
        Set<String> parantesis = lg.parenthesis1(3);
        System.out.println(parantesis);
    }

    public Set<String> parenthesis(int n) {
        Set<String> s = new HashSet<>();
        if (n == 1) {
            s.add("()");
            return s;
        }
        Set<String> s1 = parenthesis(n-1);
        for (String e:s1) {
            s.add("()"+e);
            s.add(e + "()");
            s.add("(" + e + ")");
        }
        return s;
    }

    public Set<String> parenthesis1(int n) {
        Set<String> res = new HashSet<>();
        res.add("()");
        if (n == 1) {
            return res;
        }
        for (int i = 2; i <= n; i++) {
            Set<String> nres = new HashSet<>();
            for (String e:res) {
                nres.add("()" + res);
                nres.add("(" + res + ")");
                nres.add(res + "()");
            }
            res = nres;
        }
        return res;
    }
}
