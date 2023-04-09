package O5string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeriodicString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int caseNum = 1;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            String s = sc.next();
            list.add(s);
        }
        for (int j = 0; j < list.size(); j++) {
            String s = list.get(j);

            int[] next = MatchKmp.next(s);
            System.out.println("Test case#"+(j+1));
            boolean flag = false;
            for (int i = 2; i < next.length; i++) {
                int k = next[i];
                int t = i - k;
                if (i % t == 0 && i / t > 1) {
                    System.out.println(i+" "+i/t);
                }
            }
            System.out.println();
        }
    }
}
