package O7recursive;

import java.util.*;

import static java.lang.System.exit;

public class PartialSum {
    static int k = 11;
    static int kk = k;
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 4, 7};
        int n = 4;
        getSum(a, n, k);
        dfs(a, k, 0,new ArrayList<Integer>());
    }
    public static void dfs(int[] a, int k, int n, ArrayList<Integer> inis) {
        if (k == 0) {
            System.out.print("yes ("+kk+"=");
            for (int i = 0; i < inis.size(); i++) {
                if (i == inis.size() - 1) {
                    System.out.print(inis.get(i)+")");
                    break;
                }
                System.out.print(inis.get(i) + "+");
            }

            exit(0);
        }
        if (k < 0 || n == a.length) {
            return;
        }
        dfs(a, k, n + 1,inis);
        inis.add(a[n]);
        int index = inis.size()-1;
        dfs(a, k - a[n], n + 1, inis);
        inis.remove(index);
    }

    public static void getSum(int[] a, int n, int k) {
        Set<Set<Integer>> res = new HashSet<>();
        res.add(new HashSet<>());
        for (int i = 0; i <= n; i++) {
            Set<Set<Integer>> nRes = new HashSet<>();
            nRes.addAll(res);
            for (Set e:res) {
                Set<Integer> tmp = (Set) ((HashSet) e).clone();
                tmp.add(a[i]);
                nRes.add(tmp);
            }
            res = nRes;
        }
        l3:
        for (Set e:res) {
            Object[] tmp = e.toArray();
            int sum = 0;
            for (int j = 0; j < tmp.length; j++) {
                sum += (int)tmp[j];
                if (sum == k) {
                    System.out.print("yes ("+k+"=");
                    for (int i = 0; i < tmp.length; i++) {
                        if (i == tmp.length-1) {
                            System.out.println(tmp[i]+")");
                            break l3;
                        }
                        System.out.print(tmp[i]+"+");
                    }
                }
            }
        }
    }
}
