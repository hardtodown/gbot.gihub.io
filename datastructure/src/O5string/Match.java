package O5string;

import java.util.Arrays;

public class Match {
    public static void main(String[] args) {
        String src = "abcabc";
        int[] height = getHeight(src, getSa2(src));
    }

    public static int[] getHeight(String src, Suff[] sa) {
        int strLenngth = src.length();
        int[] rk = new int[strLenngth];
        for (int i = 0; i < strLenngth; i++) {
            rk[sa[i].index] = i;
        }
        int[] height = new int[strLenngth];
        int k = 0;
        for (int i = 0; i < strLenngth; i++) {
            int rankOfSuffI = rk[i];
            if (rankOfSuffI == 0) {
                height[0] = 0;
                continue;
            }
            int rankOfPre = rankOfSuffI - 1;
            int indexOfPre = sa[rankOfPre].index;
            if (k > 0) {
                k--;
            }
            for (; indexOfPre + k < strLenngth && i + k < strLenngth; k++) {
                if (src.charAt(indexOfPre + k) != src.charAt(i + k)) {
                    break;
                }
            }
            height[rankOfSuffI] = k;
        }
        return height;
    }

    public static Suff[] getSa2(String src) {
        int n = src.length();
        Suff[] sa = new Suff[n];
        for (int i = 0; i < n; i++) {
            sa[i] = new Suff(src.charAt(i), i);
        }
        Arrays.sort(sa);
        int[] rk = new int[n];
        rk[sa[0].index] = 1;
        for (int i = 1; i < n; i++) {
            rk[sa[i].index] = rk[sa[i - 1].index];
            if (sa[i].c != sa[i - 1].c) {
                rk[sa[i].index]++;
            }
        }
        for (int k = 2; rk[sa[n-1].index] < n; k*=2) {
            final int kk = k;
            Arrays.sort(sa,(o1,o2)->{
                int i = o1.index;
                int j = o2.index;
                if (rk[i] == rk[j]) {
                    if (i+kk/2 >= n || j+kk/2 >= n) {
                        return -(i-j);
                    }
                    return rk[i+kk/2]-rk[j+kk/2];
                } else {
                    return rk[i] - rk[j];
                }
            });
            rk[sa[0].index] = 1;
            for (int i = 1; i < n; i++) {
                int i1 = sa[i].index;
                int i2 = sa[i-1].index;
                rk[i1] = rk[i2];
                try {
                    if (!src.substring(i1, i1 + kk).equals(src.substring(i2, i2 + kk))) {
                        rk[i1]++;
                    }
                } catch (Exception e) {
                    rk[i1]++;
                }
            }
        }
        return sa;
    }
    public static class Suff implements Comparable<Suff> {
        public char c;
        public int index;

        public Suff(char c, int index) {
            this.c = c;
            this.index = index;
        }
        @Override
        public int compareTo(Suff o2) {
            return this.c-o2.c;
        }
        @Override
        public String toString() {
            return "Suff{"+"c='"+c+'\''+",index="+index+'}';
        }
    }
}
