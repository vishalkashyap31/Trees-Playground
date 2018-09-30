package edu.cs.ds.tree.binary;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Represents a class that implements the Binary Tree operations
 */
public class BinaryTree {

    private Node root;
    private int noOfNodes;

    /**
     * Add a new node into the binary Tree
     * 
     * @param newNode
     *            A new {@link Node} that has to be added into the Binary Tree
     */
    public void addNode(final Node newNode) {
        if (root == null) {
            root = newNode;
            noOfNodes++;
            return;
        }

        final Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            final Node currentNode = nodeQueue.poll();

            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                break;
            } else {
                nodeQueue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                break;
            } else {
                nodeQueue.add(currentNode.getRight());
            }
        }

        noOfNodes++;
    }

    /**
     * Search data in the tree using BFS technique
     * 
     * @param data
     *            a int that needs to be searched
     * @return true if the data is found
     */
    public boolean search(final int data) {

        try {
            searchNode(data);
            return true;
        } catch (final IOException e) {

        }

        return false;
    }

    /**
     * Search data in the tree using BFS technique
     * 
     * @param data
     *            a int that needs to be searched
     * @return If matched found them {@link Node} or else NULL
     */
    public Node searchNode(final int data) throws IOException {
        if (root == null) {
            throw new IOException("Root node cannot be null");
        }

        final Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            final Node currentNode = nodeQueue.poll();

            if (data == currentNode.getData()) {
                return currentNode;
            }

            if (currentNode.getLeft() != null) {
                nodeQueue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                nodeQueue.add(currentNode.getRight());
            }
        }

        throw new IOException("Could not find the node with value " + data);
    }

    /**
     * Delete data from the tree
     * 
     * @param data
     *            A int that needs to be deleted from the tree
     * @throws IOException
     *             if the data is not present in three
     */
    public void delete(final int data) throws IOException {

        if (root == null) {
            throw new IOException("Root node cannot be null");
        }

        Node deleteNode = null;
        Node lastNode = null;

        final Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            lastNode = nodeQueue.poll();

            if (data == lastNode.getData()) {
                deleteNode = lastNode;
            }

            if (lastNode.getLeft() != null) {
                nodeQueue.add(lastNode.getLeft());
            }

            if (lastNode.getRight() != null) {
                nodeQueue.add(lastNode.getRight());
            }
        }

        if (deleteNode == null) {
            throw new IOException("Could not find the item to be deleted");
        }

        removeNode(lastNode);

        deleteNode.setData(lastNode.getData());
    }

    /**
     * Prints node data as in order traversal
     * 
     * @param root
     *            A {@link Node} on which in order traversal has to be done
     * @param inOrderList
     *            A {@link List} that will be populated with all the node's data
     */
    public void inOrderTraversal(final Node root, final List<Integer> inOrderList) {
        if (inOrderList != null && root != null) {
            inOrderTraversal(root.getLeft(), inOrderList);
            inOrderList.add(root.getData());
            inOrderTraversal(root.getRight(), inOrderList);
        }
    }

    /**
     * Prints node data as pre order traversal
     * 
     * @param root
     *            A {@link Node} on which pre order traversal has to be done
     * @param preOrderList
     *            A {@link List} that will be populated with all the node's data
     */
    public void preOrderTraversal(final Node root, final List<Integer> preOrderList) {
        if (preOrderList != null && root != null) {
            preOrderList.add(root.getData());
            preOrderTraversal(root.getLeft(), preOrderList);
            preOrderTraversal(root.getRight(), preOrderList);
        }
    }

    /**
     * Prints node data as post order traversal
     * 
     * @param root
     *            A {@link Node} on which post order traversal has to be done
     * @param postOrderList
     *            A {@link List} that will be populated with all the node's data
     */
    public void postOrderTraversal(final Node root, final List<Integer> postOrderList) {
        if (postOrderList != null && root != null) {
            postOrderTraversal(root.getLeft(), postOrderList);
            postOrderTraversal(root.getRight(), postOrderList);
            postOrderList.add(root.getData());
        }
    }

    /**
     * Get the root node
     * 
     * @return root Node
     */
    public Node getRootNode() {
        return root;
    }

    /**
     * Get the size of the tree
     * 
     * @return number of nodes in the tree
     */
    public int size() {
        return noOfNodes;
    }

    private void removeNode(final Node removeNode) throws IOException {
        if (root == null) {
            throw new IOException("Root node cannot be null");
        }

        final Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.empty()) {
            final Node currentNode = nodeStack.pop();

            if (removeNode.equals(currentNode.getLeft())) {
                currentNode.setLeft(null);
                break;
            }

            if (removeNode.equals(currentNode.getRight())) {
                currentNode.setRight(null);
                break;
            }

            if (currentNode.getLeft() != null) {
                nodeStack.push(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                nodeStack.push(currentNode.getRight());
            }
        }
    }
}
