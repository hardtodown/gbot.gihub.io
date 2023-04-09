package nine;

/*x星球的居民脾气不太好，但好在他们生气的时候唯一的异常举动是：摔手机。
各大厂商也就纷纷推出各种耐摔型手机。x星球的质监局规定了手机必须经过耐摔测试，并且评定出一个耐摔指数来，之后才允许上市流通。
x星球有很多高耸入云的高塔，刚好可以用来做耐摔测试。塔的每一层高度都是一样的，与地球上稍有不同的是，
他们的第一层不是地面，而是相当于我们的2楼。
如果手机从第7层扔下去没摔坏，但第8层摔坏了，则手机耐摔指数=7。
特别地，如果手机从第1层扔下去就坏了，则耐摔指数=0。
如果到了塔的最高层第n层扔没摔坏，则耐摔指数=n
为了减少测试次数，从每个厂家抽样3部手机参加测试。
某次测试的塔高为1000层，如果我们总是采用最佳策略，在最坏的运气下最多需要测试多少次才能确定手机的耐摔指数呢？
请填写这个最多测试次数。*/
public class nine_four {
    static int N = 1000;
    static int[] f1 = new int[N + 1];
    static int[] f2 = new int[N + 1];
    static int[] f3 = new int[N + 1];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            f1[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                int max = 1 + Math.max(f2[i - j], f1[j - 1]);
                ans = Math.min(ans, max);
            }
            f2[i] = ans;
        }
        for (int i = 1; i <= N; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                int max = 1 + Math.max(f3[i - j], f2[j - 1]);
                ans = Math.min(ans, max);
            }
            f3[i] = ans;
        }
        System.out.println(f3[1000]);
    }
}
