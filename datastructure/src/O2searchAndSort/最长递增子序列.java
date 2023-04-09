package O2searchAndSort;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,9,2,5,7,3,4,6,8,0};
        int begin = 0;
        int end = begin;
        int maxlength = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]) {
                end++;
                if (maxlength < end - begin) {
                    maxlength = end - begin + 1;
                }
            }
            else {
                begin = i+1;
                end = begin;
            }
        }
        System.out.println(maxlength);
    }
}
