package O3sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopK {  // 依靠小顶堆实现
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int x = sc.nextInt();
        while (x != -1) {
            if (size++ < k) {
                pq.offer(x);
            } else if (x > pq.peek()){
                pq.poll();
                pq.offer(x);
            }
            x = sc.nextInt();
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        System.out.println(ans);
    }
}
