package O7recursive;

import O6math.NExponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NonemptySubset {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        Set<Set<Integer>> l = new NonemptySubset().getSubsets1(A, A.length);
        ArrayList<ArrayList<Integer>> a = new NonemptySubset().getSubsets2(A, A.length);
        System.out.println(l);
        System.out.println(a);
    }

    public Set<Set<Integer>> getSubsets(int[] A, int n, int cur) {
        Set<Set<Integer>> nSet = new HashSet<>();
        if (cur == 0) {
            Set<Integer> nill = new HashSet<>();
            Set<Integer> first = new HashSet<>();
            first.add(A[0]);
            nSet.add(nill);
            nSet.add(first);
            return nSet;
        }
        Set<Set<Integer>> oSet = getSubsets(A, n, cur - 1);
        for (Set<Integer> set:oSet) {
            nSet.add(set);
            Set<Integer> clone = (Set<Integer>)((HashSet)set).clone();
            clone.add(A[cur]);
            nSet.add(clone);
        }
        return nSet;
    }

    public Set<Set<Integer>> getSubsets1(int[] A, int n) {
        Set<Set<Integer>> res = new HashSet<>();
        res.add(new HashSet<>());
        for (int i = 0; i < n; i++) {
            Set<Set<Integer>> nRes = new HashSet<>();
            nRes.addAll(res);
            for (Set e:res) {
                Set clone = (Set) ((HashSet) e).clone();
                clone.add(A[i]);
                nRes.add(clone);
            }
            res = nRes;
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> getSubsets2(int[] A, int n) {
        //Arrays.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = NExponent.ex2(2,n)-1; i > 0; i--) {
            ArrayList<Integer> s = new ArrayList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (((i >> j) & 1) == 1) {
                    s.add(A[j]);
                }
            }
            res.add(s);
        }
        return res;
    }
}
