package twelve;

import java.util.HashSet;
import java.util.Set;

/*在平面直角坐标系中，两点可以确定一条直线。如果有多点在一条直线上，
那么这些点中任意两点确定的直线是同一条。
给定平面上 2 × 3 个整点 {(x, y)|0 ≤ x < 2, 0 ≤ y < 3, x ∈ Z, y ∈ Z}，
即横坐标 是 0 到 1 (包含 0 和 1) 之间的整数、纵坐标是 0 到 2 (包含 0 和 2) 之间的整数 的点。
这些点一共确定了 11 条不同的直线。
给定平面上 20 × 21 个整点 {(x, y)|0 ≤ x < 20, 0 ≤ y < 21, x ∈ Z, y ∈ Z}，
即横 坐标是 0 到 19 (包含 0 和 19) 之间的整数、纵坐标是 0 到 20 (包含 0 和 20) 之 间的整数的点。
请问这些点一共确定了多少条不同的直线。
*/
public class twelve_three {
    public static void main(String[] args) {
        Set<String> ans = new HashSet<String>();
        for(int a1 = 0; a1 <= 19; a1++) {
            for(int b1 = 0; b1 <= 20; b1++) {
                for(int a2 = 0; a2 <= 19; a2++) {
                    for(int b2 = 0; b2 <= 20; b2++) {
                        // 斜率不存在和斜率为0的特殊情况，我们可以手动计算无需特殊判断
                        if(a1 == a2 || b1 == b2) {
                            continue;
                        }
                        // 以分子/分母的形式表达斜率k和截距b时，分子和分母需要是最简的形式
                        StringBuilder sb = new StringBuilder();
                        int up = b2 - b1;
                        int down = a2 - a1;
                        int r = gcd(up, down);
                        sb.append(up / r + " ");
                        sb.append(down / r + " ");
                        up = b1 * down - a1 * up;
                        r = gcd(up, down);
                        sb.append(up / r + " ");
                        sb.append(down / r);
                        ans.add(sb.toString());
                    }
                }
            }
        }
        // 斜率不存在的直线20根，斜率为0的直线21根
        System.out.println(ans.size() + 20 + 21);
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
