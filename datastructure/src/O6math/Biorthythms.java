package O6math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biorthythms {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = 1;
        List<long[]> alist = new ArrayList<>();
        List<Long> dlist = new ArrayList<>();
        while (sc.hasNext()) {
            long[] a = {sc.nextLong(), sc.nextLong(), sc.nextLong()};
            long d = sc.nextLong();
            if (a[0] == -1 && a[1] == -1 && a[2] == -1 && d == -1) {
                break;
            } else {
                alist.add(a);
                dlist.add(d);
            }
        }
        for (int i = 0; i < alist.size(); i++) {
            long[] a = alist.get(i);
            long d = dlist.get(i);
            long[] m = {23, 28, 33};
            long res = ExtGcd.linearEquationGroup(a, m);
            while (res <= d) {
                res += 21252;
            }
            System.out.println("Case"+(t++)+":the next triple peak occurs in "+(res-d)+"days.");
        }
    }
}
