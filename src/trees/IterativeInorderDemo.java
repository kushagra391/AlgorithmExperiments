package trees;/* Authored by Kushagra on 2/9/2016. */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderDemo {

    public static void main(String[] args) {
        TreeNode root = createTree();
        List<TreeNode> inOrder = iterativeInorder(root);

    }

    private static List<TreeNode> iterativeInorder(TreeNode root) {

        List<TreeNode> inorderList = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();

        if (root == null) return inorderList;

        TreeNode node = root;

        // initialize stack
        while (node != null) {
            S.push(node);
            node = node.left;
        }

        // populate inorder
        while (!S.isEmpty()) {

            node = S.peek();

            // pop immediately
            if (node.right == null) {
                inorderList.add(node);
                S.pop();
            }
            else {

                // pop root element
                inorderList.add(node);
                S.pop();

                // go down the right subtree, repeat
                node = node.right;
                while (node != null) {
                    S.push(node);
                    node = node.left;
                }
            }
        }

        return inorderList;
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

}
