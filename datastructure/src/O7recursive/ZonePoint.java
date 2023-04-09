package O7recursive;

import java.util.Arrays;
import java.util.Scanner;

public class ZonePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(intervals);
        int max = intervals[n - 1].t;
        int[] axis = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int s = intervals[i].s;
            int t = intervals[i].t;
            int cnt = sum(axis, s, t);
            intervals[i].c -= cnt;
            while (intervals[i].c > 0) {
                if (axis[t] == 0) {
                    axis[t] = 1;
                    intervals[i].c--;
                    t--;
                }else {
                    t--;
                }
            }
        }
        System.out.println(sum(axis, 0, max));
    }

    public static int sum(int[] axis, int s, int t) {
        int sum = 0;
        for (int i = s; i <= t; i++) {
            sum += axis[i];
        }
        return sum;
    }
    public static void updateSums(int t, int[] sums) {
        for (int i = t; i < sums.length; i++) {
            sums[i]++;
        }
    }

    public static class Interval implements Comparable<Interval> {
        int s;
        int t;
        int c;

        public Interval(int s, int t, int c) {
            this.c = c;
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Interval other) {
            int x = this.t - other.t;
            if (x == 0) {
                return this.s - other.s;
            } else {
                return x;
            }
        }
    }
}
