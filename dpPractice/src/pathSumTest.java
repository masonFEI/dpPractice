import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pathSumTest {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;

        List<List<Integer>> res = pathSum(root,targetSum);

        System.out.println(res);

    }


    public static List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        LinkedList<String> sumNumList = new LinkedList<>();
        LinkedList<String> lines = new LinkedList<>();
        nodeList.add(root);

        sumNumList.add( String.valueOf(root.val));

        while (!nodeList.isEmpty()) {

            int nodelength = nodeList.size();

            for (int j = nodelength; j > 0; j--) {
                TreeNode item = nodeList.pollFirst();
                String numString = sumNumList.pollFirst();

                if (item.left == null && item.right == null) {
                    lines.add(numString);
                }

                String leftNumlist = numString;
                String rightNumlist = numString;

                if (item.left != null) {
                    nodeList.addLast(item.left);
                    leftNumlist+=","+String.valueOf(item.left.val);
                    sumNumList.addLast(leftNumlist);
                }

                if (item.right != null) {
                    nodeList.addLast(item.right);
                    rightNumlist+=","+String.valueOf(item.right.val);
                    sumNumList.addLast(rightNumlist);
                }
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            String item = lines.get(i);
            String[] itemStrings = item.split(",");
            List<Integer> itemList=new ArrayList<>();
            int sum =0;
            for (int j=0;j<itemStrings.length;j++) {
                itemList.add(Integer.valueOf(itemStrings[j]));
                sum+=Integer.valueOf(itemStrings[j]);
            }

            if (sum == target) {
                res.add(itemList);
            }
        }

        return res;

    }


}
