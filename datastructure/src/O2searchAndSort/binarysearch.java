package O2searchAndSort;

public class binarysearch {
    //二分查找
    public static int binarySearch0(int[] arr, int low, int high, int key) {
        while (low <= high)
        {
            int mid = low + ((high-low)>>1);
            int midval = arr[mid];

            if (midval < key)
                low = mid + 1;
            else if (midval > key)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    //二分查找递归解法
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = low + ((high - low) >> 1);//low + high) >>> 1://防止溢出,移位也更高效。int midVal = arr[mid];
        int midval = arr[mid];
        if (midval < key)
            return binarySearch(arr, mid + 1, high, key);

        else if (midval > key)
            return binarySearch(arr, low, high - 1, key);

        else
            return mid; // key found
    }
    //顺序查找
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 7, 10};
//        System.out.println(binarySearch(arr,0,11,5));
        long now = System.currentTimeMillis();
        System.out.println(binarySearch0(arr,0,6,6));
        System.out.println(System.currentTimeMillis()-now+"ms");
    }
}
