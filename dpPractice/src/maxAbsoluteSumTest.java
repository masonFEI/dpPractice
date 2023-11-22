public class maxAbsoluteSumTest {


    public static void main(String[] args) {
        int[] nums = {-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9};

        int res = maxAbsoluteSum(nums);

        System.out.println(res);
    }


    public static int maxAbsoluteSum(int[] nums) {

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = Math.max(0,nums[0]);;
        dpMin[0] = Math.min(0,nums[0]);
        int res = Math.max(Math.max(dpMax[0],-dpMin[0]),0);

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i-1]+nums[i],nums[i]);
            dpMin[i] = Math.min(dpMin[i-1]+nums[i],nums[i]);
            res = Math.max(Math.max(dpMax[i],-dpMin[i]),res) ;
        }

        return res;

    }


}
