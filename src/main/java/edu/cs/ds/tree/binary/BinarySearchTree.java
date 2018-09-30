package edu.cs.ds.tree.binary;

import java.io.IOException;

/**
 * Represents a binary search tree.
 */
public class BinarySearchTree {

    private Node root;
    private int noOfNodes;

    /**
     * Add a new node to the binary tree
     * 
     * @param newNode
     *            A new {@link Node} to be added
     * @throws IOException
     *             if the newNode is null
     */
    public void addNode(final Node newNode) throws IOException {
        if (newNode == null) {
            throw new IOException("New node cannot be null");
        }

        if (root == null) {
            root = newNode;
            noOfNodes++;
            return;
        }

        Node previousNode = null;
        Node currentNode = root;

        while (currentNode != null) {
            previousNode = currentNode;
            if (currentNode.getData() > newNode.getData()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        if (previousNode.getData() > newNode.getData()) {
            previousNode.setLeft(newNode);
        } else {
            previousNode.setRight(newNode);
        }

        noOfNodes++;
    }

    /**
     * Search a particular data in the tree
     * 
     * @param data
     *            A int that has to be searched
     * @return true if the data is present in tree
     */
    public boolean search(final int data) {
        try {
            if (searchNode(data) != null) {
                return true;
            }
        } catch (final IOException e) {

        }
        return false;
    }

    /**
     * Search a particular data in the tree
     * 
     * @param data
     *            A int that has to be searched
     * @return Matched {@link Node}
     * @throws IOException
     *             when the node could not be found
     */
    public Node searchNode(final int data) throws IOException {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                return currentNode;
            }

            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        throw new IOException("Node not found");
    }

    /**
     * Delete data from the tree
     *
     * @param data
     *            A int that needs to be deleted from the tree
     * @throws IOException
     *             if the data is not present in tree
     */
    public void delete(final int data) throws IOException {

        if (root == null) {
            throw new IOException("Root node cannot be null");
        }

        final Node deleteNode = searchNode(data);
        Node previousNode = null;
        Node lastNode = root;

        while (lastNode.getRight() != null) {
            previousNode = lastNode;
            lastNode = lastNode.getRight();
        }

        if (lastNode.getLeft() != null) {
            previousNode.setRight(lastNode.getLeft());
        }

        deleteNode.setData(lastNode.getData());
        noOfNodes--;
    }

    /**
     * Get the size of the tree
     *
     * @return number of nodes in the tree
     */
    public int size() {
        return noOfNodes;
    }

}
