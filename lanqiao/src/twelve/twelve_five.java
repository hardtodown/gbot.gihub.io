package twelve;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图 中的最短路径。
小蓝的图由 2021 个结点组成，依次编号 1 至 2021。对于两个不同的结点 a, b，
如果 a 和 b 的差的绝对值大于 21，则两个结点 之间没有边相连；如果 a 和 b 的差的绝
对值小于等于 21，则两个点之间有一条 长度为 a 和 b 的最小公倍数的无向边相连。
例如：结点 1 和结点 23 之间没有边相连；结点 3 和结点 24 之间有一条无 向边，长度为 24；
结点 15 和结点 25 之间有一条无向边，长度为 75。请计算，结点 1 和结点 2021 之间的最短路径长度是多少。
*/
public class twelve_five {
    public static void main(String[] args) {
        int[][] graph = new int[2021][2021];
        for (int i = 1; i <= 2021; i++) {
            for (int j = i + 1; j <= 2021; j++) {
                if (Math.abs(i - j) > 21) {
                    graph[i-1][j-1] = graph[j-1][i-1] = Integer.MAX_VALUE;
                } else {
                    int lcm = lcm(i, j);
                    graph[i-1][j-1] = graph[j-1][i-1] = lcm;
                }
            }
        }

        int[] dist = new int[2021];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] visited = new boolean[2021];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(u -> dist[u]));
        pq.offer(0);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (visited[u]) continue;
            visited[u] = true;
            for (int v = 0; v < 2021; v++) {
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.clear();
                    for (int i = 0; i < 2021; i++) {
                        if (!visited[i]) pq.offer(i);
                    }
                }
            }
        }
        System.out.println(dist[2020]);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
