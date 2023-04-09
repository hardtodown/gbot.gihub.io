package thirteen;

import java.util.Scanner;

/*【问题描述】
小蓝老师教的编程课有N名学生，编号依次是 1…N。第i号学生这学期
刷题的数量是Ai对于每一名学生，请你计算他至少还要再刷多少道题，才能使得全班刷题
比他多的学生数不超过刷题比他少的学生数。
【输入格式】
第一行包含一个正整数N
第二行包含N个整数：A1,A2,...AN
【输出格式】
输出N个整数，依次表示第 1…N号学生分别至少还要再刷多少道题。
【样例输入】
5
12 10 15 20 6
【样例输出】
0 3 0 0 7
*/
public class thirteen_four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 复制数组
        System.arraycopy(nums, 0, temp, 0, nums.length);

        //快速选择
        int midValue = select(temp, (n + 2) >>> 1);

        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > midValue) {
                r++;
            } else if (nums[i] < midValue) {
                l++;
            }
        }

        int midOption = l < r ? 1 : 0;

        int option = l <= r ? 1 : 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            if (nums[i] == midValue) {
                count = midOption;
            } else if (nums[i] < midValue) {
                count = midValue - nums[i] + option;
            }

            if (i != n - 1) {
                System.out.print(count + " ");
            } else {
                System.out.println(count);
            }
        }
    }

    public static int select(int[] arr, int k) {
        return select0(arr, 0, arr.length - 1, k);
    }


    /**
     * 快速选择
     */
    private static int select0(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int mid = partition(arr, left, right);

        int res = mid - left + 1;

        if (k == res) {
            return arr[mid];
        } else if (k < res) {
            return select0(arr, left, mid - 1, k);
        } else {
            return select0(arr, mid + 1, right, k - res);
        }
    }


    /**
     * 基于随机选取轴的划分
     */
    private static int partition(int[] arr, int l, int r) {


        int pivotIndex = (int) (Math.random() * (r - l + 1)) + l;

        arr[l] = new int[]{arr[pivotIndex], arr[pivotIndex] = arr[l]}[0];

        int pivot = arr[l], left = l, right = r + 1;

        while (left < right) {
            while (arr[++left] < pivot && left < r) {
            }

            while (arr[--right] > pivot) {

            }

            if (left >= right) {
                break;
            }

            arr[left] = new int[]{arr[right], arr[right] = arr[left]}[0];
        }
        arr[l] = arr[right];

        arr[right] = pivot;

        return right;
    }
}
