package O5string;

import com.sun.deploy.util.StringUtils;

public class Difference {
    public Boolean checkDifference(String iniString) {
        if (iniString.length() == 0) {
            return true;
        }
        int[] flag = new int[128];
        for (int i = 0; i < iniString.length(); i++) {
            int c = (int) iniString.charAt(i);
            flag[c]++;
            if (flag[c] > 1) {
                return false;
            }
        }
        return true;
    }
}
