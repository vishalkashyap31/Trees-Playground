package edu.cs.ds.tree.binary;

/**
 * Convert the given {@link BinarySearchTree} into a Tree in which every node contains the sum of all the nodes which are greater than the node
 */
public class GreaterSumTree extends BinarySearchTree {

    /**
     * Get the sum of all the node data
     * 
     * @return sum of all the nodes
     */
    public int getTotalSum() {
        return getTotalSum(root);
    }

    /**
     * Convert the {@link BinarySearchTree} to the greater sum tree
     */
    public void convertBST2GreaterSumTree() {
        final int totalSum = getTotalSum(root);
        convertBST2GreaterSumTree(root, totalSum);
    }

    private int convertBST2GreaterSumTree(final Node root, int totalSum) {
        if (root == null) {
            return totalSum;
        }
        totalSum = convertBST2GreaterSumTree(root.getLeft(), totalSum);
        root.setData(totalSum - root.getData());
        totalSum = convertBST2GreaterSumTree(root.getRight(), totalSum);
        return totalSum;
    }

    private int getTotalSum(final Node root) {
        if (root == null) {
            return 0;
        }
        return getTotalSum(root.getLeft()) + root.getData() + getTotalSum(root.getRight());
    }
}
