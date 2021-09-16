package pro.incq.dsaa.introduction;

import java.util.ArrayList;
import java.util.List;

/**
 * excise 1.6
 */
public class Permute {
    public List<String> permute(String str) {
        return permute(str.toCharArray(), 0, str.length() - 1);
    }

    private List<String> permute(char[] str, int low, int high) {
        List<String> ret = new ArrayList<>();
        if (low == high) {
            ret.add(String.valueOf(str[low]));
            return ret;
        }
        List<String> preStrs = permute(str, low, high - 1);
        char addedChar = str[high];
        for (String preStr : preStrs) {
            ret.add(preStr + addedChar);
            for (int i = preStr.length() -1 ; i >= 1; i--) {
                ret.add(preStr.substring(0, i) + addedChar + preStr.substring(i));
            }
            ret.add(addedChar + preStr);
        }
        return ret;
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<String> permutes = permute.permute("abcdef");
        System.out.println(permutes);
    }
}
