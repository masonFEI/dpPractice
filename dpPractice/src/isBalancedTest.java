public class isBalancedTest {


    public static void main(String[] args) {

    }


    public boolean isBalanced(TreeNode root) {

        if(root ==null){
            return false;
        }

       int res =  checkhigh(root);

       return res!=-1;
    }


    public int checkhigh(TreeNode root) {

        if (root.left == null && root.right == null) {
            return 1;
        }

        int lefthigh = 0;

        if (root.left != null) {
            lefthigh = checkhigh(root.left);
        }

        int righthigh = 0;
        if (root.right != null) {
            righthigh = checkhigh(root.right);
        }


        if (lefthigh==-1|| righthigh == -1 || Math.abs(lefthigh - righthigh) > 1 ) {
            return -1;
        } else  {
            return Math.max(lefthigh, righthigh)+1;
        }


    }


}
