package O5string;

public class Zip {
    public static String zipString(String s) {
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                sb.append(s.charAt(i)).append(cnt);
                cnt = 1;
            }
        }
        sb.append(s.charAt(s.length()-1)).append(cnt);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = zipString("aaaabbbbcccccd");
        System.out.println(s.toString());
    }
}
