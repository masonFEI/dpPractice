import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelOrderTest {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }




    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        LinkedList<TreeNode> numQue = new LinkedList<>();
        LinkedList<TreeNode> sonQues = new LinkedList<>();
        sonQues.add(root);

        while (!sonQues.isEmpty()) {
            int count = sonQues.size();
            for (int i=0;i < count;i++){
                numQue.addLast(sonQues.pollFirst());
            }

            List<Integer> item = new ArrayList<>();
            while (!numQue.isEmpty()) {
                TreeNode itemNode = numQue.pollFirst();
                item.add(itemNode.val);

                if(itemNode.left!=null){
                    sonQues.addLast(itemNode.left);
                }

                if(itemNode.right != null){
                    sonQues.addLast(itemNode.right);
                }
            }
            res.add(item);
        }

        return res;

    }




      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
