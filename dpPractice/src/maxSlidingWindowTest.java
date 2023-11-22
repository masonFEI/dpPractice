import java.util.Arrays;
import java.util.LinkedList;

public class maxSlidingWindowTest {


    public static void main(String[] args) {

    }


    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == k) {
            int max = Arrays.stream(nums).max().getAsInt();
            return new int[]{max};
        } else {
            int steps = nums.length - k + 1;
            int[] res = new int[steps];

            LinkedList<Integer> valueList = new LinkedList<>();
            LinkedList<Integer> indexList = new LinkedList<>();
            int left = 0;
            int right = left + k;

            for (int i =0;i<steps;i++){
                int pointer = left;

                while (pointer < right){
                    while (!valueList.isEmpty() && valueList.peekLast() < nums[pointer]) {
                        valueList.removeLast();
                        indexList.removeLast();
                    }
                    valueList.add(nums[pointer]);
                    indexList.add(pointer);
                    pointer++;
                }

                left++;
                right++;

                res[i]=valueList.peekFirst();
                valueList.removeFirst();
                indexList.removeFirst();

            }

            return res;
        }


    }


}
