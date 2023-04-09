package O3sort;

public class selectK {
    public static int selectK(int[] arr, int p, int r, int k)
    {
        int q = quickSort.partition2(arr, p, r);
        int qk = q-p+1;
        if (qk < k) return selectK(arr,q+1,r,k-qk);
        else if (qk > k) return selectK(arr,p,q-1,k);
        else return arr[q];
    }

    public static void main(String[] args) {
        int[] A = {3,9,7,6,1,2};
        int k = selectK(A, 0, A.length-1,2);
        System.out.println(k);
    }
}
