package chapter10;

public class TextVariable {
    public static void main(String[] args) {
        // 分割split的用法
        /*String str = "this is a text.";
        String[] arr = str.split(" |\\.");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
        System.out.println("这就话一共有"+arr.length+"个单词");*/
        // 使用位运算实现加减乘除
        /*TextVariable t = new TextVariable();
        *//*
位运算实现加减乘除
*//*
#include<stdio.h>
//加法函数
        int add ( int a, int b)
        {
            int temp;
            while (b)//当b为0时则代表没有进位了
            {
                temp = a ^ b;
                b = (a & b) << 1;
                a = temp;
            }
            return a;
        }
//减法函数
        int sub ( int a, int b)
        {
            b = ~b + 1;//将b转换为其补码形式
            return add(a, b);
        }
//乘法函数
        int mul ( int a, int b)
        {
            int sum = 0;
            while (b) {
                sum = add(sum, a);
                b--;
            }
            return sum;
        }
//除法函数
        int division ( int a, int b)
        {
            int result = 0;
            if (a == 0) {
                return 0;
            }
            while (1) {
                if (a > mul(a, result)) {
                    break;
                }
                result++;
            }
            return result - 1;
        }
        int main ()
        {

            int a, b, c;
            scanf("%d%d", & a,&b);
            //测试加法函数
            c = add(a, b);
            printf("%d\n", c);
            //测试减法函数
            c = sub(a, b);
            printf("%d\n", c);
//测试乘法函数
            c = mul(a, b);
            printf("%d\n", c);
//测试除法函数
            c = division(a, b);
            printf("%d\n", c);
            return 0;
        }
*/
        //leetcode的第十四题，最长公共字串，startsWith函数的巧妙运用
        /*class Solution {
            public String longestCommonPrefix(String[] strs) {
                if(strs.length==0)return "";
                //公共前缀比所有字符串都短，随便选一个先
                String s=strs[0];
                for (String string : strs) {
                    while(!string.startsWith(s)){
                        if(s.length()==0)return "";
                        //公共前缀不匹配就让它变短！
                        s=s.substring(0,s.length()-1);
                    }
                }
                return s;
            }
        }*/
        //leetcode的第十二题，数字与罗马数字转换
        /*class Solution {
            public:
            string intToRoman(int num) {
                int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
                string reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

                string res;
                for(int i=0; i<13; i++){
                    while(num>=values[i]){
                        num -= values[i];
                        res += reps[i];
                    }
                }
                return res;
            }
        };*/
        //动态规划的部分示例代码，超重要！！！！！
        //1.0带记忆缓存，基础部分
        /*class Solution{
            public int rob(int[] nums){
                this.nums = nums;
                this.cache = new int[nums.length];
                Array.fill(cache, -1);
                return rec(nums.length - 1);
            }
        }
        int[] nums;
        int[] cache;
        public int rec(int index){
            if(index == 0)
                return nums[0];
            if(index == 1)
                return Math.max(nums[0],nums[1]);
            if(cache[index] != -1)
                return cache[index];
            int max = Math.max(rec(index - 2) + nums[index], rec(index - 1));
            cache[index] = max;
            return max;
        }*/
        //1.1 和计算
        /*import java.util.*;

        public class addNums {
            int[] cache;

            public int getNums(int n) {
                if (n <= 3) {
                    return 1;
                }
                if (cache[n - 3] != 0) {
                    return cache[n - 3];
                }
                int tmp = getNums(n - 1) + (n - 1) * (n - 2) / 2;
                cache[n - 3] = tmp;
                return tmp;
            }

            public static void main(String[] args) {
                int[] nums = new int[] {-1, 0, 1, -1, 2,3,6};
                addNums m = new addNums();
                m.cache = new int[nums.length - 2];
                System.out.println(m.getNums(nums.length));
            }
        }*/
        //2.0动态规划实例化代码，由小到大
        /*class Solution{
            public int rob(int[] nums){
                if(nums.length == 0)
                    return 0;
                if(nums.length == 1)
                    return nums[0];
                int pre1 = nums[0];
                int pre2 = Math.max(nums[0], nums[1]);
                int res = pre2;
                for (int i = 2; i < nums.length; i++) {
                    res = Math.max(pre2, pre1 + nums[i]);
                    pre1 = pre2;
                    pre2 = res;
                }
                return res;
            }
        }*/
        //2.1 和计算
        /*import java.util.*;

        public class autoGetNums {
            public static void main(String[] args) {
                int[] nums = new int[] {-1, 0, 1, -1, 2,3,6,8};
                int pre1 = 1,i = 4;
                int pre2 = 3;
                if(nums.length <= 3)
                {
                    System.out.println("1");
                }
                int sum = pre1;
                while(i++ <= nums.length){
                    sum += pre2;
                    pre1 = pre2;
                    pre2 = pre1 + i-2;
                }
                System.out.println(sum);
            }
        }*/
        //leetcode的第十一题，盛最多水的容器
        /*public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            int minH = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            // 快速跳过这步可太妙了
            while (height[l] <= minH && l < r) {
                l++;
            }
            while (height[r] <= minH && l < r) {
                r--;
            }
        }
        return maxArea;
    }*/
        //leetcode的第十题，正则表达式匹配
        /*class Solution {
            int m, n;
            String ss;
            String pp;

            public boolean isMatch(String s, String p) {
                m = s.length();
                n = p.length();
                ss = s;
                pp = p;
                //多开一个空间放两个空串匹配
                boolean[][] f = new boolean[m + 1][n + 1];
                f[0][0] = true;
                for (int i = 0; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {
                        //p[j - 1]为 *
                        if (p.charAt(j - 1) == '*') {
                            //匹配 0 次，相当于直接扔掉 p[j - 1]和p[j - 2]
                            f[i][j] = f[i][j - 2];
                            //如果s[i - 1] == p[j -2]相等，可以尝试匹配s[i - 1]多次，边匹配边把s[i - 1]扔掉，s串回退，等待进行下一次匹配
                            if (matches(i, j - 1)) f[i][j] |= f[i - 1][j];
                        } else {
                            //s[i-1]==p[j-1]，则f[i][j]能否匹配由f[i-1][j-1]决定
                            if (matches(i, j)) f[i][j] = f[i - 1][j - 1];
                        }

                    }
                }
                return f[m][n];
            }

            boolean matches(int i, int j) {
                if (i == 0) return false;
                if (pp.charAt(j - 1) == '.') return true;
                return pp.charAt(j - 1) == ss.charAt(i - 1);
            }
        }*/
        //leetcode的第六题，z字形排列
        /*int len = s.length();
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        int x=2;
        if(numRows==1){
            return s;
        }else{
            x=2+2*(numRows-2);
        }
        for(int j=0;j<numRows;j++){
            for(int i=0;i*x-j<len;i++){
                if(i*x-j>0&&j<numRows-1){
                    res.append(s.charAt(i*x-j));
                }
                if(j>0&&i*x+j<len){
                    res.append(s.charAt(i*x+j));
                }
            }

        }
        return res.toString();*/
        //leetcode的第五题，最长回文字串，动态规划
        /*class Solution {
            public String longestPalindrome(String s) {
                if(s.equals("")) return s;
                int len = s.length(), left = 0, right = 0;
                boolean[][] db = new boolean[len][len];
                for(int j = 0; j < len; j++)
                {
                    for(int i = 0; i <= j; i++)
                    {
                        db[i][j] = (s.charAt(i) == s.charAt(j))&&(j - i < 2 || db[i+1][j-1]);
                        if(db[i][j] && j - i > right - left)
                        {
                            left = i;
                            right = j;
                        }
                    }
                }
                return s.substring(left,right+1);
            }
        }*/
        //可以通过强制数据转换判断数据是否溢出判断数据是否超出数据类型范围
    }
}
