package seven;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*有12张连在一起的12生肖的邮票。
现在你要从中剪下5张来，要求必须是连着的。
  1   2   3   4
  5   6   7   8
  9   10  11  12
请你计算，一共有多少种不同的剪取方法。
请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。*/
public class seven_seven {
    static int[] vis = new int[12];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        f(0,0);
        int ans = 0;
        for(String str:set) {
            if(check(str)) {
                ans ++;
            }
        }
        System.out.println(ans);
    }

    //把字符串转化成二维数组
    private static boolean check(String str) {
        char[] b = str.toCharArray();
        char[][] arr = new char[3][4];
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<4;j++) {
                arr[i][j] = b[i*4+j];
            }
        }
        int count = 0;
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<4;j++) {
                if(arr[i][j] == '1') {
                    dfs(arr,i,j);
                    count ++;
                }
            }
        }
        return count == 1;
    }

    //递归检测连通快
    private static void dfs(char[][] arr, int i, int j) {
        arr[i][j] = '0';
        if(i-1>=0 && arr[i-1][j] == '1') dfs(arr,i-1,j);
        if(i+1<3 && arr[i+1][j] == '1') dfs(arr,i+1,j);
        if(j-1>=0 && arr[i][j-1] == '1') dfs(arr,i,j-1);
        if(j+1<4 && arr[i][j+1] == '1') dfs(arr,i,j+1);
    }

    private static void f(int index, int num) {
        if(index == 12 && num != 5) return;
        if(index == 12 && num == 5) {
            set.add(vis[0]+""+vis[1]+""+vis[2]+""+vis[3]+""+vis[4]+""+vis[5]+""+vis[6]+""+vis[7]+""+vis[8]+""+vis[9]+""+vis[10]+""+vis[11]);
            return;
        }
        f(index +1,num);
        vis[index] = 1;
        f(index +1,num +1);
        vis[index] = 0;
    }
}
