import java.util.HashMap;
import java.util.Map;

public class minimizedStringLengthTest {


    public static void main(String[] args) {

    }


    public int minimizedStringLength(String s) {


        Map<String, Integer> letterCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            int count = 0;

            if (letterCountMap.containsKey(s.substring(i, i + 1))) {
                count = letterCountMap.get(s.substring(i, i + 1));
            }

            letterCountMap.put(s.substring(i, i + 1), count + 1);

        }

        return letterCountMap.size();
    }

}
