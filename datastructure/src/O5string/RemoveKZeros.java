package O5string;

import com.sun.xml.internal.ws.policy.AssertionSet;

public class RemoveKZeros {
    public static String remove(String s, int k) {
        String regexp = "0{" + k + "}";
        return s.replaceAll(regexp,"");
    }

    public static String remove1(String s, int k) {
        char[] arr = s.toCharArray();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '0') {
                cnt++;
            } else {
                for (int j = 0; j < cnt % k; j++) {
                    sb.append('0');
                }
                sb.append(c);
                cnt = 0;
            }
        }
        for (int j = 0; j < cnt % k; j++) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        assert remove("A0000B00",3).equals("A0B00");
    }
}
