package ten;

/*“饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有
一个优先级，初始时 (0 时刻) 优先级都为 0。
每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减
到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果
优先级小于等于 3，则会被清除出优先缓存。
给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优
先缓存中。
【输入格式】
第一行包含 3 个整数 N、M 和 T。
以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到
一个订单。
【输出格式】
输出一个整数代表答案。
【样例输入】
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
【样例输出】
1
【样例解释】
6 时刻时，1 号店优先级降到 3，被移除出优先缓存；2 号店优先级升到 6，
加入优先缓存。所以是有 1 家店 (2 号) 在优先缓存中。
*/
import java.util.*;

public class ten_seven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            int sum = 0,flag = 0;
            int N = input.nextInt();        // 店数
            int M = input.nextInt();        // 订单数
            int T = input.nextInt();        // 时刻
            int tmp[] = new int[N+1];
            int[][] orders = new int[M][2];
            int[][] a = new int[N+1][T+1];  // 定义一个状态
            for (int i = 0; i < N+1; i++) {
                Arrays.fill(a[i],-1);   // 初始化-1没有订单该时刻减一计算总优先级和时即减一
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 2; j++) {
                    orders[i][j] = input.nextInt();
                }
            }
            for (int i = 0; i < M; i++) {
                if(a[orders[i][1]][orders[i][0]] == -1)
                {
                    a[orders[i][1]][orders[i][0]] = 2;
                }
                else
                {
                    a[orders[i][1]][orders[i][0]] += 2;     // 增加优先级
                }
            }
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < T+1; j++) {
                    tmp[i] += a[i][j];
                    if(tmp[i] < 0)                      // 优先级不能小于0
                    {
                        tmp[i] = 0;
                        continue;
                    }
                    else
                    {
                        if(tmp[i] > 5)
                        {
                            flag = 1;                     // 判断是否进入优先缓存
                        }
                        if(flag == 1 && tmp[i] <= 3)
                        {
                            flag = 0;                     // 判断是否退出优先缓存
                        }
                    }
                }
                if(flag == 1 && tmp[i] > 3)
                {
                    sum += 1;
                }
            }
            System.out.println(sum);
        }
        catch (Exception e){
            input.close();
        }
    }
    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Set<Integer> set = new HashSet<Integer>();
            int N = input.nextInt();
            int M = input.nextInt();
            int T = input.nextInt();
            int[][] orders = new int[M][2];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 2; j++) {
                    orders[i][j] = input.nextInt();
                }
            }
            int[] priority = new int[N];
            int[] sign = new int[N];
            for (int i = 1; i <= T; i++) {
                for (int j = 0; j < M; j++) {
                    if (orders[j][0] == i) {
                        priority[orders[j][1] - 1] += 2;
                        if (priority[orders[j][1] - 1] > 5 && !set.contains(orders[j][1] - 1)) {
                            set.add(orders[j][1] - 1);
                        }
                        sign[orders[j][1] - 1] = 1;
                    }
                }
                for (int j = 0; j < N; j++) {
                    if (sign[j] == 0 && priority[j] > 0) priority[j]--;
                    if (priority[j] <= 3) {
                        set.remove(j);
                    }
                }
                sign = new int[N];
            }
            System.out.println(set.size());
        } catch (Exception e) {
            input.close();
        }
    }*/
}