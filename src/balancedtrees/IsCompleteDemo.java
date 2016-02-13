package balancedtrees;/* Authored by Kushagra on 2/12/2016. */

import trees.TreeNode;

public class IsCompleteDemo {

    public static void main(String[] args) {

        TreeNode root = TreeNode.getBST1();
        System.out.println(isComplete(root));
    }

    private static boolean isComplete(TreeNode root) {

        int size = getSize(root);
        int index = 0;

        return isCompleteHelper(root, index, size);
    }

    private static boolean isCompleteHelper(TreeNode root, int index, int size) {

        if (root == null) return true;

        // if a node has been left empty, eventually the index has to surpass size
        if (index >= size)
            return false;

        return isCompleteHelper(root.left, 2*index + 1, size) ||
                isCompleteHelper(root.right, 2*index + 2, size);
    }

    private static int getSize(TreeNode root) {
        if (root == null) return 0;
        else
            return 1 + getSize(root.left) + getSize(root.right);
    }
}



