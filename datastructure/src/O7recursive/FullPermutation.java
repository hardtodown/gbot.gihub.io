package O7recursive;

import O1bitOperation.出现K次;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullPermutation {
    public static void main(String[] args) {
        FullPermutation fp = new FullPermutation();
        String s = "ABC";
        System.out.println(permute(s));
        System.out.println(fp.insertMethod(s));
        System.out.println(fp.getPermutation1(s, s.length() - 1));
        System.out.println(fp.swapMethod(s, 0));
        fp.TopKMethod("", s.toCharArray());
    }

    public ArrayList<String> insertMethod(String A) {
        ArrayList<String> res = new ArrayList<>();
        res.add(A.charAt(0)+"");
        for (int i = 1; i < A.length(); i++) {
            ArrayList<String> nRes = new ArrayList<>();
            String tmp = "" + A.charAt(i);
            for (String str:res) {
                nRes.add(str+tmp);
                nRes.add(tmp + str);
                for (int j = 1; j < str.length(); j++) {
                    nRes.add(str.substring(0,j)+tmp+str.substring(j));
                }
            }
            res = nRes;
        }
        return res;
    }

    public ArrayList<String> getPermutation1(String A, int i) {
        ArrayList<String> res = new ArrayList();
        if (i == 0) {
            res.add(A.charAt(i)+"");
            return res;
        }
        ArrayList<String> nRes = getPermutation1(A,i-1);
        for (String str:nRes) {
            res.add(str+A.charAt(i));
            res.add(A.charAt(i)+str);
            for (int j = 1; j < str.length(); j++) {
                res.add(str.substring(0, j) + A.charAt(i) + str.substring(j));
            }
        }
        return res;
    }

    public ArrayList<String> swapMethod(String A, int k) {
        ArrayList<String> res = new ArrayList<>();
        char[] a = A.toCharArray();
        if (k == a.length) {
            res.add(new String(a));
            return res;
        }
        for (int i = k; i < A.length(); i++) {
            swap(a, k, i);
            res.addAll(swapMethod(new String(a),k+1));
            swap(a, k, i);
        }
        return res;
    }

    public void swap(char[] a, int k, int i) {
        char tmp = a[i];
        a[i] = a[k];
        a[k] = tmp;
    }
    final static int k = 3;
    static int count = 0;
    public static void TopKMethod(String A, char[] arr) {
        if (A.length() == arr.length) {
            count++;
            if (count == k) {
                System.out.println("-------:"+A);
                System.exit(0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (count(A.toCharArray(), ch) < count(arr, ch)) {
                TopKMethod(A + ch, arr);
            }
        }
    }

    public static int count(char[] arr, char ch) {
        int cnt = 0;
        for (char c:arr) {
            if (c == ch) {
                cnt++;
            }
        }
        return cnt;
    }
    public static List<String> permute(String str) {
        List<String> res = new ArrayList<>();
        int[] nums = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - 'A' + 1;
        }
        Arrays.sort(nums);
        do {
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append((char) ('A' + num - 1));
            }
            res.add(sb.toString());
        } while (nextPermutation(nums));
        return res;
    }
    private static boolean nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        return true;
    }

    private static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
