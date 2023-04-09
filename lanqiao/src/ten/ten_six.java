package ten;

/*小明对数位中含有2、0、1、9的数字很感兴趣（不包括前导0），在1到40中包括
这样的数字为1、2、9、10至32、39和40，共28个，他们的和是574。
请问，在1到n中，所有这样的数的和是多少？
【输入格式】
输入一行数包含一个整数n
【输出格式】
输出一行包含一个整数表示满足条件的数的和
【样例输入】
40
【样例输出】
574
*/
import java.util.Scanner;
public class ten_six {
    public Boolean isContains(int i)        // 判断是否包含
    {
        Boolean b = false;
        while(i != 0)
        {
            if(i%10 == 2 || i%10 == 0 || i%10 ==1 || i%10 == 9)
            {
                b = true;
                break;
            }
            i /= 10;
        }
        return b;
    }
    public static void main(String[] args) {
        ten_six t = new ten_six();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= a; i++) {      // 直接遍历求总数
            if(t.isContains(i))
            {
                sum += i;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}