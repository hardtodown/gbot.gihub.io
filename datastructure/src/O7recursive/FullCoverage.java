package O7recursive;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class FullCoverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = new Job(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(jobs);
        int start = 1;
        int end = 1;
        int ans = 1;
        for (int i = 0; i < N; i++) {
            int s = jobs[i].s;
            int t = jobs[i].t;
            if (i == 0 && s > 1) {
                break;
            }
            if (s <= start) {
                end = max(t, end);
            } else {
                ans++;
                start = end + 1;
                if (s <= start) {
                    end = max(t, end);
                } else {
                    break;
                }
            }
            if (end >= T) {
                break;
            }
        }
        if (end < T) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static class Job implements Comparable<Job> {
        int s;
        int t;

        public Job(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Job other) {
            int x = this.s - other.s;
            if (x == 0) {
                return this.t - other.t;
            } else {
                return x;
            }
        }
    }
}
