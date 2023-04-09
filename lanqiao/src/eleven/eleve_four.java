package eleven;

/*
题目描述
某市市长获得了若干批口罩，每一批口罩的数目如下：（如果你把以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在试题目录下有一个文件
mask.txt，内容与下面的文本相同）
9090400
8499400
5926800
8547000
4958200
4422600
5751200
4175600
6309600
5865200
6604400
4635000
10663400
8087200
4554000
现在市长要把口罩分配给市内的 2 所医院。由于物流限制，每一批口罩只能全部分配给其中一家医院。市长希望 2
所医院获得的口罩总数之差越小越好。请你计算这个差最小是多少？*/
public class eleve_four {
    public static void main(String[] args) {
        int[] nums = { 90904, 84994, 59268, 85470, 49582, 44226,
                57512, 41756, 63096, 58652, 66044, 46350, 106634, 80872, 45540 };   // 同倍缩短，也可再同减最小值减少数据复杂度
        System.out.println(dfs(nums,0, 0)*100);
    }
    public static int dfs(int[] nums, int sum, int i) {     // 直接暴力搜索，可试试带记忆缓存提升性能
        if (i == nums.length) {
            return sum;
        }
        return Math.min(Math.abs(dfs(nums, sum + nums[i], i + 1)), Math.abs(dfs(nums, sum - nums[i], i + 1)));
    }
}
