import java.util.LinkedList;

public class maxDepthTest {


    public static void main(String[] args) {

    }


    public int maxDepth(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        res = 1;

        while (!que.isEmpty()) {

            Integer queSize = que.size();

            res++;
            for (int i = queSize; i > 0; i--) {
                TreeNode item = que.pollFirst();
                if (item.left != null) {
                    que.addLast(item.left);
                }

                if (item.right != null) {
                    que.addLast(item.right);
                }
            }
        }

        return res;


    }


}
