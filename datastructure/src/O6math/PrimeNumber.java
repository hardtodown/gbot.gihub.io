package O6math;

import java.util.HashMap;
import java.util.Map;

public class PrimeNumber {
    public static void main(String[] args) {
        boolean res = isPrime(7L);
        System.out.println(res);
        System.out.println(primeFactor(100));
    }

    public static Map<Integer, Integer> primeFactor(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                Integer v = map.get(i);
                if (v == null) {
                    map.put(i, 1);
                } else {
                    map.put(i, v + 1);
                }
                num /= i;
            }
        }
        return map;
    }

    public static boolean isPrime(long l) {
        for (int i = 2; i <= Math.sqrt(l); i++) {
            if (l % i == 0) {
                return false;
            }
        }
        return true;
    }
}
