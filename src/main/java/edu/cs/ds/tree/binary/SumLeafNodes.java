package edu.cs.ds.tree.binary;

public class SumLeafNodes extends BinaryTree {

    /**
     * Get the sum of all the leaf nodes in the {@link BinaryTree}
     * 
     * @return a int representing the sum
     */
    public int sumLeafNodes() {
        return sumLeafNodes(root);
    }

    private int sumLeafNodes(final Node root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return root.getData();
        }

        return sumLeafNodes(root.getRight()) + sumLeafNodes(root.getLeft());
    }
}
