package O5string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HasSameCharSet {
    public static Boolean check(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (!s2.contains(Character.toString(s1.charAt(i)))) {
                return false;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!s1.contains(Character.toString(s2.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static Boolean check1(String s1, String s2) {
        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i),false);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!map.containsKey(s2.charAt(i))) {
                return false;
            }
            map.put(s2.charAt(i),true);
        }
        for (Boolean c:map.values()) {
            if (c == false) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "aabdsndna";
        String s2 = "abdsn";
        System.out.println(check1(s1,s2));
    }
}
