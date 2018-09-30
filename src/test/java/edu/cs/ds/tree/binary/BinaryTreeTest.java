package edu.cs.ds.tree.binary;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test class for {@link BinaryTree}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryTreeTest {

    final BinaryTree binaryTree = new BinaryTree();

    @Before
    public void setUp() {
        binaryTree.addNode(new Node(1));
        binaryTree.addNode(new Node(2));
        binaryTree.addNode(new Node(3));
        binaryTree.addNode(new Node(4));
        binaryTree.addNode(new Node(5));
        binaryTree.addNode(new Node(6));
        binaryTree.addNode(new Node(7));
        binaryTree.addNode(new Node(8));
        binaryTree.addNode(new Node(9));
        binaryTree.addNode(new Node(10));
        binaryTree.addNode(new Node(11));
        binaryTree.addNode(new Node(12));
    }

    /**
     * Test the node addition {@link BinaryTree#addNode(Node)}
     */
    @Test
    public void testAddNodes() {
        assertEquals(12, binaryTree.size());
    }

    /**
     * Test to search a particular node. Should return true if the data is found and false if data is not present.
     */
    @Test
    public void testSearch() {
        assertTrue(binaryTree.search(6));
        assertFalse(binaryTree.search(99));
    }

    /**
     * Test to search a particular node. Should return true if the data is found and false if data is not present.
     */
    @Test
    public void testSearchNode() throws IOException {
        assertNotNull(binaryTree.searchNode(6));

    }

    /**
     * Test to search a particular node. Should return true if the data is found and false if data is not present.
     * 
     * @throws IOException
     *             thrown when the item to be deleted is not found
     */
    @Test(expected = IOException.class)
    public void testSearchNode_negative() throws IOException {
        binaryTree.searchNode(99);
    }

    /**
     * Delete a node from tree
     * 
     * @throws IOException
     *             thrown when the item to be deleted is not found
     */
    @Test
    public void testDelete() throws IOException {
        assertTrue(binaryTree.search(6));
        binaryTree.delete(6);
        assertFalse(binaryTree.search(6));
    }

    /**
     * Test the in order tree traversal {@link BinaryTree#inOrderTraversal(Node, List)}
     */
    @Test
    public void testInOrderTraversal() {

        final List<Integer> traversedList = new ArrayList<>();
        final Node root = binaryTree.getRootNode();

        binaryTree.inOrderTraversal(root, traversedList);
        assertEquals(12, traversedList.size());
        assertEquals(8, traversedList.get(0).intValue());
    }

    /**
     * Test the pre order tree traversal {@link BinaryTree#preOrderTraversal(Node, List)}
     */
    @Test
    public void testPreOrderTraversal() {

        final List<Integer> traversedList = new ArrayList<>();
        final Node root = binaryTree.getRootNode();

        binaryTree.preOrderTraversal(root, traversedList);
        assertEquals(12, traversedList.size());
        assertEquals(1, traversedList.get(0).intValue());
    }

    /**
     * Test the post order tree traversal {@link BinaryTree#postOrderTraversal(Node, List)}
     */
    @Test
    public void testPostOrderTraversal() {

        final List<Integer> traversedList = new ArrayList<>();
        final Node root = binaryTree.getRootNode();

        binaryTree.postOrderTraversal(root, traversedList);
        assertEquals(12, traversedList.size());
        assertEquals(8, traversedList.get(0).intValue());
    }
}
