package edu.cs.ds.tree.binary;

import java.io.IOException;

/**
 * A {@link BinaryTree} in which the {@link Node} data is always greater or equal than its children
 */
public class MaxHeapTree extends BinaryTree {

    /**
     * Add a new node into the {@link MaxHeapTree}
     *
     * @param newNode
     *            A new {@link Node} that has to be added into the Binary Tree
     * @throws IOException
     *             if the newNode is null
     */
    @Override
    public void addNode(final Node newNode) throws IOException {
        super.addNode(newNode);
        heapify(root, null);
    }

    /**
     * Delete data from the {@link MaxHeapTree}
     * 
     * @param data
     *            A int that needs to be deleted from the tree
     * @throws IOException
     */
    @Override
    public void delete(final int data) throws IOException {
        super.delete(data);
        heapify(root, null);
    }

    /**
     * Update the Max value with the new value
     * 
     * @param newValue
     *            new value with which the max node has to be updated
     */
    public void updateMax(final int newValue) {
        root.setData(newValue);
        heapify(root, null);
    }

    /**
     * Get the maximum node in the {@link MaxHeapTree}
     * 
     * @return A int which represents maximum in the {@link MaxHeapTree}
     */
    public int getMax() {
        return root.getData();
    }

    private void heapify(final Node root, final Node previous) {
        if (root == null) {
            return;
        }
        heapify(root.getRight(), root);
        heapify(root.getLeft(), root);
        if (root != null && previous != null && root.getData() > previous.getData()) {
            swap(root, previous);
        }
    }

    private void swap(final Node current, final Node previous) {
        final int currentNodeData = current.getData();
        current.setData(previous.getData());
        previous.setData(currentNodeData);
    }
}
