package seven;

/*   B      DEF
A + --- + ------- = 10
     C      GHI
这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
比如：
6+8/3+952/714 就是一种解法，
5+3/1+972/486 是另一种解法。
这个算式一共有多少种解法？
注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。*/
public class seven_three {
    static int count = 0;
    static int[] arr = {1,2,3,4,5,6,7,8,9};
    public static void main(String[] args)
    {
        f(0);
        System.out.println(count);
    }
    //全排列
    private static void f(int index) {
        if(index == 8) {
            check();
            return ;
        }

        for(int i = index;i<arr.length;i++) {
            {
                int t = arr[index];
                arr[index] =arr[i];
                arr[i] = t;
            }
            f(index+1);
            {
                int t = arr[index];
                arr[index] =arr[i];
                arr[i] = t;
            }
        }
    }

    private static void check() {
        //6+(8*714+3*952)/(3*714)  求出来是10
        int m = arr[3]*100+arr[4]*10+arr[5];
        int n = arr[6]*100+arr[7]*10+arr[8];
        if((arr[1]*n+arr[2]*m)%(arr[2]*n) == 0&&arr[0] + (arr[1]*n+arr[2]*m) /(arr[2]*n) == 10) count ++;
    }
}
