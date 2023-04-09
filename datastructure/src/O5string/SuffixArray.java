package O5string;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class SuffixArray {
    public static void main(String[] args) {
        int res = maxRepeatSubString("123232323");
        System.out.println(res);
    }

    public static int maxRepeatSubString(String src) {
        Match.Suff[] sa = Match.getSa2(src);
        int[] height = Match.getHeight(src, sa);
        int l = 0;
        int r = height.length;
        int ans = 0;
        while (l <= r) {
            int mid = ((r - l) >> 1);
            if (check(height, sa, mid)) {
                if (mid == height.length / 2) {
                    return mid;
                }
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static boolean check(int[] height, Match.Suff[] sa, int len) {
        int minIndex = sa[0].index;
        int maxIndex = sa[0].index;
        for (int i = 1; i < height.length; i++) {
            int index = sa[i].index;
            if (height[i] >= len) {
                minIndex = min(minIndex, index);
                maxIndex = max(maxIndex, index);
            } else {
                if (maxIndex - minIndex >= len) {
                    return true;
                }
                maxIndex = index;
                minIndex = index;
            }
        }
        return maxIndex-minIndex >= len;
    }
}
