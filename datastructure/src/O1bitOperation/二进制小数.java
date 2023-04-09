package O1bitOperation;

public class 二进制小数 {
    public static void main(String[] args) {
        double num = 0.625;
        StringBuilder sb = new StringBuilder("0.");  // 以字符串的形式记录二进制数
        while(num>0) {
            if (num*2>=1) {
                sb.append('1');
                num = num*2-1;  // 乘二取整
            }
            else {
                sb.append('0');
                num = num*2;
            }
            if (sb.length() > 34) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
