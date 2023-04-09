package nine;

import java.util.Scanner;

/*对于顺时针从0到-1开始的经过平面每个整点的折线，>
对于整点(X, Y)，我们定义它到原点的距离dis(X, Y)是从原点到(X, Y)的螺旋折线段的长度。
例如dis(0, 1)=3, dis(-2, -1)=9
给出整点坐标(X, Y)，你能计算出dis(X, Y)吗？
输入格式：
X和Y
输出格式：
输出dis(X, Y)
输入样例：
0 1
输出样例：3*/
public class nine_seven {
    public static int check(long cx, long cy, long x, long y,int fx, int fy, long i) {
        if (cx == x && cy == y) {           // 在同一点
            return 0;
        }else if (fx == -1 && x >= cx + fx*i && x <= cx && cy == y || fx == 1 && x >= cx && x <= cx + fx*i && cy == y) {      // 在同一横线
            return 1;
        } else if (cx == x && fy == -1 && y <= cy && y >= cy + fy*i || cx == x && fy == 1 && y >= cy && y <= cy + fy*i) {      // 在同一竖线
            return 2;
        }else if (i % 2 != 0 && cx > -1 - i/2){             // 下
            return 3;
        } else if (i % 2 != 0 && cx == -1 - i / 2) {        // 左
            return 4;
        } else if (i % 2 == 0 && cx < i / 2) {              // 上
            return 5;
        } else if (i % 2 == 0 && cx == i / 2) {             // 右
            return 6;
        }
        return -1;
    }
    public static long dis(long x, long y) {
        long cx = 0, cy = 0;        // 当前坐标
        int fx = -1, fy = 1;        // 加减符号
        long sum = 0, i = 1;
        while (cx != x || cy != y) {
            int t = check(cx, cy, x, y,fx, fy, i);
            switch (t) {            // 替代if语句
                case 0:
                    return sum;
                case 1:
                    sum += Math.abs(x - cx);
                    return sum;
                case 2:
                    sum += Math.abs(y - cy);
                    return sum;
                case 3:
                case 5:
                    cx += fx * i;
                    sum += i;
                    fx = -fx;           // 是y就要变i
                    break;
                case 4:
                case 6:
                    cy += fy * i;
                    sum += i;
                    i++;
                    fy = -fy;
                    break;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        System.out.println(dis(x,y));
    }
}
