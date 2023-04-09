package O6math;

import java.util.Scanner;

public class Weighing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final String s = Integer.toString(N, 3);
        int[] flag = new int[s.length()+1];
        if (s.charAt(s.length()-1)=='2'){
            flag[s.length()] = -1;
            flag[s.length()-1]++;
        } else if (s.charAt(s.length()-1)=='1'){
            flag[s.length()] = 1;
        } else if (s.charAt(s.length() - 1) == '0') {
            flag[s.length()] = 0;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (flag[i+1] != 1 && s.charAt(i) == '2') {
                flag[i+1] = -1;
                flag[i]++;
            }else if (flag[i+1] != 1 && s.charAt(i) == '1'){
                flag[i+1] = 1;
            }else if (flag[i+1] != 1 && s.charAt(i) == '0'){
                flag[i+1] = 0;
            }else if (flag[i+1] == 1 && s.charAt(i) == '2'){
                flag[i+1] = 0;
                flag[i]++;
            }else if (flag[i+1] == 1 && s.charAt(i) == '1'){
                flag[i+1] = -1;
                flag[i]++;
            } else if (flag[i+1] == 1 && s.charAt(i) == '0'){
                flag[i+1] = 1;
            }
        }
        boolean b = true;
        for (int i = flag.length-1; i >= 0; i--) {
            if (b && flag[i] > 0) {
                System.out.print((int)Math.pow(3, flag.length-i-1)*flag[i]);
                b = false;
            } else if (flag[i] > 0){
                System.out.print("+"+(int)Math.pow(3,flag.length-i-1)*flag[i]);
            } else if (flag[i] < 0){
                System.out.print((int)Math.pow(3,flag.length-i-1)*flag[i]);
                b = false;
            }
        }
        System.out.println("="+N);
    }
}
