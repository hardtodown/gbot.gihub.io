package O1bitOperation;


public class 交换奇偶位 {
    public static int m(int i) {
        int x = 0Xaaaaaaaa;  // 0X表示十六进制，0b表示二进制
        int y = 0X55555555;
        return ((i&x)>>1)^((i&y)<<1);
    }
    public static void main(String[] args) {
        int a = 6;
        int b = m(a);
        assert b == 8;
        System.out.println(b);
    }
}
