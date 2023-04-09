package O2searchAndSort;

import javax.swing.*;

public class 有序字符数组中的查找 {
    public static void main(String[] args) {
        String[] s = new String[]{"a","","ac","","ad","b","","ba"};
        int res = indexOf(s,"b");
        System.out.println(res);
    }
    public static int indexOf(String[] arr, String p) {
        int begin = 0;
        int end = arr.length-1;
        while (begin < end) {
            int mid = begin + ((end-begin)>>1);
            while (arr[mid].equals("")){
                if (++mid > end)
                {
                    return -1;
                }
            }
            if (arr[mid].compareTo(p) > 0)
            {
                end = mid -1;
            }
            else if(arr[mid].compareTo(p) < 0)
            {
                begin = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
