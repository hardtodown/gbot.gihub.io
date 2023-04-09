package O5string;

import java.util.Arrays;

public class WordReverse {
    public static String reverseWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int head = 0;
        String s;
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                s = sb.substring(head,i);
                sb1 = new StringBuilder(s).reverse();
                sb2.append(sb1).append(" ");
                head = i+1;
            } else if (i == sb.length() - 1) {
                s = sb.substring(head, i + 1);
                sb1 = new StringBuilder(s).reverse();
                sb2.append(sb1);
            }
        }
        return sb2.toString();
    }
    public static String reverseWord1(String word) {
        StringBuilder sb = new StringBuilder();
        String[] words = word.split("\\s");
        for (String w:words) {
            sb.insert(0, w + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "how are you";
        System.out.println(reverseWord1(s));
    }
}
