public class rob3Test {


    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        int[] res = afterSort(root);

        return Math.max(res[0], res[1]);
    }


    public int[] afterSort(TreeNode root) {

        int[] res = new int[2];

        if (root == null) {
            return res;
        }

        int[] left = afterSort(root.left);
        int[] right = afterSort(root.right);
        int notCur = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int cur = root.val + left[0] + right[0];
        res[0] = notCur;
        res[1] = cur;

        return res;
    }

}
