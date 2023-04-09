package O5string;

public class IsRotate {
    public static Boolean isRotate(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(b).append(b);
        return sb.toString().contains(a);
    }

    public static void main(String[] args) {
        System.out.println(isRotate("defabd", "fabdde"));
        System.out.println(isRotate("abc","acb"));
    }
}
