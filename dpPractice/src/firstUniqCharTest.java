import java.util.*;

public class firstUniqCharTest {


    public static void main(String[] args) {

    }


    public char firstUniqChar(String s) {

        char res = ' ';

        if (s.equals("")) {
            return res;
        }

        Map<String, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String itemString = s.substring(i, i + 1);
            if (charIndexMap.containsKey(itemString)) {
                charIndexMap.put(itemString, Integer.MAX_VALUE);
            } else {
                charIndexMap.put(itemString, i);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(charIndexMap.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
        return list.get(0).getValue() != Integer.MAX_VALUE ? list.get(0).getKey().charAt(0) : ' ';


    }


}
