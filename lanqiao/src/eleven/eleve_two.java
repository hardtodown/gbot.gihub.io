package eleven;

/*2020 年 7 月 1 日是中国共产党成立 99 周年纪念日。
中国共产党成立于 1921 年 7 月 23 日。
请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包含多少分钟？*/
public class eleve_two {
    public static void main(String[] args) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = month[6] - 23;
        for (int i = 7; i < 12; i++) {          // 计算七月剩余天数
            sum += month[i];
        }
        for (int i = 0; i < 6; i++) {           // 计算1921当年剩余天数
            sum += month[i];
        }
        sum += 2;                               // 计算缺失天数，7月1号当天加2020闰年2月缺失一天
        for (int i = 1922; i < 2020; i++) {     // 计算1922到2020之间的天数
            if (isYear(i)) {
                sum += 366;
            } else {
                sum += 365;
            }
        }
        System.out.println(sum*24*60);          // 转化成分钟
    }

    public static boolean isYear(int n) {
        if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {   // 判断是否为闰年
            return true;
        }
        return false;
    }
}
