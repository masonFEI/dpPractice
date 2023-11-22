public class twoSumTest {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] res = twoSum(nums, target);


        System.out.println(res);

    }


    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            }
        }

        return res;


    }


}
