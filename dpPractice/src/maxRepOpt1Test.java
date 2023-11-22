import java.util.HashMap;
import java.util.Map;

public class maxRepOpt1Test {


    public static void main(String[] args) {
        String text = "aaabbaaa";

        int res = maxRepOpt1(text);

        System.out.println(res);
    }


    public static int maxRepOpt1(String text) {

        int maxCount = 0;
        Map<String, Integer> lettersCountMapping = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            int itemCount = 0;
            if (lettersCountMapping.containsKey(text.substring(i, i + 1))) {
                itemCount = lettersCountMapping.get(text.substring(i, i + 1));
            }

            lettersCountMapping.put(text.substring(i, i + 1), itemCount + 1);
        }

        int i = 0;
        while (i < text.length()) {
            int j = i;

            while (j < text.length() && text.substring(j, j + 1).equals(text.substring(i, i + 1))) {
                j++;
            }
            int l = j - i;
            int k = j + 1;

            while (k < text.length() && text.substring(k, k + 1).equals(text.substring(i, i + 1))) {
                k++;
            }
            int r = k - j - 1;
            int itemCount = Math.min(l + r + 1, lettersCountMapping.get(text.substring(i, i + 1)));
            maxCount = itemCount > maxCount ? itemCount : maxCount;
            i = j;
        }

        return maxCount;
    }


}
