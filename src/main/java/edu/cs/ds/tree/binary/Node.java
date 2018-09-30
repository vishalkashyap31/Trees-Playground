package edu.cs.ds.tree.binary;

/**
 * Represents a node in a binary tree
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(final int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Node) == false) {
            return false;
        }

        final Node otherNode = ((Node) other);
        return data == otherNode.data && left == otherNode.getLeft() && right == otherNode.right;
    }
}
