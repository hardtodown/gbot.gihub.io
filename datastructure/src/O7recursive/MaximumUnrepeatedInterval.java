package O7recursive;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumUnrepeatedInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        Arrays.sort(jobs);
        int res = solve(n, jobs);
        System.out.println(res);
    }

    public static int solve(int n, Job[] jobs) {
        int cnt =  1;
        int y = jobs[0].t;
        for (int i = 0; i < n; i++) {
            if (jobs[i].s > y) {
                cnt++;
                y = jobs[i].t;
            }
        }
        return cnt;
    }

    public static class Job implements Comparable<Job> {
        int s;
        int t;

        public Job(int s, int t) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Job other) {
            int x = this.t - other.t;
            if (x == 0) {
                return this.s - other.s;
            }else {
                return x;
            }
        }
    }
}
