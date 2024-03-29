package thirteen;


/*这天小明正在学数数。
他突然发现有些正整数的形状像一座“山”，比如 123565321 、 145541 ，它们左右对称（回文）且数位上的数字先单调不减，后单调不增。
小明数了很久也没有数完，他想让你告诉他在区间[2022,2022222022]中有多少个数的形状像一座“山”。*/
public class thirteen_two {
    public static void main(String[] args) {
            //11111 1111111 111111111 2222 122221 12222221 1222222221
            //9|10//9+8+7+...+1|+8+7+...+1|+...+1|+8+7+...+1|+....+1|8+7+...+1|+...+1|+...+1|=(495+330+210+126+70+35+15+5+1)*2=2574
            //7|8//9+8+7+...+1|+8+7+...+1|+...+1|+8+7+...+1|+....+1|=(165+120+84+56+35+20+10+4+1=495*2=990
            //5|6//9+8+7+...+1|+8+7+...+1|+...+1|=(45+36+28+21+15+10+6+3+1)*2=330
            //2022=36
            //1287+495+495+495+165+165+36=3138
        /*整体思路既是从中间数位开始累加，到顶就进位，相当于一个特殊的十进制求和，也可以理解位翻牌子个位翻完十位
        翻，数组中第n位是前一个数组从第n位开始累加,因为从1111情况走完到222222之间少了111111到222222的情况
        既是前一位数组的总和，后面位次依次类推，然后计算即可得到答案，此题还可不借助数组直接多重循环记录过程中的相关
        值并求和即可，但是当最大数位不确定时便不可这样求解*/
        int[] tmp = new int[]{1,1,1,1,1,1,1,1,1};       //初始化数组,中间第一个数每次加一
        int n = 0;
        int ans = 0;                        //表示结果
        while (n++ < 5){                    // n小于2022222022的一半的位数即小于5看一半进行计算
            for (int i = 0; i < tmp.length; i++) {
                for (int j = i+1; j < tmp.length; j++) {
                    tmp[i] += tmp[j];       // 看成一种特殊的十进制加法用数组储存并更新数组，只增不减
                }
            }
            if (n <= 2) {               //因为从2022开始所以省略前两位，后面手算第二位
                continue;
            }
            ans+=2*tmp[0];              //因为奇偶数位结果相同所以乘二
            if (n == 4) {               //因为第五位时有9或10两个状态且为10时结果即是为7或8时的结果所以额外加一
                ans+=tmp[0];
            }
        }
        ans-=tmp[0]-36;                 //加上4位时的情况并且减去多加的第十位
        System.out.println(ans);
    }
}
