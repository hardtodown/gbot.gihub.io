package O5string;

public class ReverseString {
    public static String reverseString(String iniString) {
        char[] arr = new char[iniString.length()];
        for (int i = iniString.length() - 1; i > 0; i--) {
            arr[iniString.length() - i - 1] = iniString.charAt(i);
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "abcd osdm";
        System.out.println(reverseString(s));
    }
}
