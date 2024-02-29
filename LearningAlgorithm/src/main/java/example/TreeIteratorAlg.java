package example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author liusc
 * @Date 2024/2/29 23:10
 * desc: 二叉树层序遍历
 * @Version 1.0
 */
public class TreeIteratorAlg {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = traversal.levelOrder(root);

        System.out.println("层序遍历结果：");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class BinaryTreeLevelOrderTraversal {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> levelValues = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    levelValues.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add(levelValues);
            }

            return result;
        }
    }
}
