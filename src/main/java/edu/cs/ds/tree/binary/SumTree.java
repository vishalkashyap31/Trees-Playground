package edu.cs.ds.tree.binary;

/**
 * A binary tree where each node in the converted tree will contains the sum of the left and right sub trees in the original tree. The leaf nodes will
 * be 0 as it does not have children
 */
public class SumTree extends BinaryTree {

    /**
     * Convert the {@link BinaryTree} into a {@link SumTree}
     */
    public void converToSumTree() {
        converToSumTree(root);
    }

    private int converToSumTree(final Node root) {
        if (root == null) {
            return 0;
        }
        final int nodeData = root.getData();
        root.setData(converToSumTree(root.getRight()) + converToSumTree(root.getLeft()));
        return nodeData;
    }
}
