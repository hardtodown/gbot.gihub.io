package O1bitOperation;

public class 出现K次 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 9, 7, 7, 7, 3, 3, 3, 6, 6, 6, 0, 0, 0};
        int len = arr.length;
        char[][] kradix = new char[len][];
        int k = 3;
        int maxlen = 0;
        for (int i = 0; i < len; i++) {
            kradix[i] = new StringBuilder(Integer.toString(arr[i],k)).reverse().toString().toCharArray();
            if (kradix[i].length > maxlen)
                maxlen = kradix[i].length;
        }
        int[] resArr = new int[maxlen];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < maxlen; j++) {
                if (j >= kradix[i].length)
                    resArr[j] += 0;
                else
                    resArr[j] += (kradix[i][j]-'0');
            }
        }

        int res = 0;
        for (int i = 0; i < maxlen; i++) {
            res += (resArr[i] % k) * (int) (Math.pow(k,i));
        }
        System.out.println(res);
    }
}
