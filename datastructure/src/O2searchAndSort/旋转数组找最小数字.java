package O2searchAndSort;

public class 旋转数组找最小数字 {
    public static int min(int[] arr) {
        int begin = 0;
        int end = arr.length-1;
        if (arr[begin] < arr[end]) return arr[begin];
        while (begin+1<end) {
            int mid = begin + ((end-begin)>>1);
            if (arr[begin] <= arr[mid])
            {
                begin = mid;
            }
            else
            {
                end = mid;
            }
        }
        return arr[end];
    }
    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,1,2};
        System.out.println(min(a));
    }
}
