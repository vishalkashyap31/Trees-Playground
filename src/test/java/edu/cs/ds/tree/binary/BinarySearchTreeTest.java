package edu.cs.ds.tree.binary;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test class for {@link BinarySearchTree}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinarySearchTreeTest {

    BinarySearchTree binarySearchTree = new BinarySearchTree();

    @Before
    public void setUp() throws IOException {
        binarySearchTree.addNode(new Node(5));
        binarySearchTree.addNode(new Node(7));
        binarySearchTree.addNode(new Node(3));
        binarySearchTree.addNode(new Node(4));
        binarySearchTree.addNode(new Node(2));
        binarySearchTree.addNode(new Node(6));
        binarySearchTree.addNode(new Node(9));
        binarySearchTree.addNode(new Node(8));
    }

    /**
     * Test if exception is thrown when tried to insert null
     *
     * @throws IOException
     *             when the new node is null
     */
    @Test(expected = IOException.class)
    public void testAddNode_whenPassedNull() throws IOException {
        binarySearchTree.addNode(null);
    }

    /**
     * Test the node addition {@link BinarySearchTree#addNode(Node)}
     */
    @Test
    public void testAddNodes() {
        assertEquals(8, binarySearchTree.size());
    }

    /**
     * Test to search a particular node. Should return true if the data is found and false if data is not present.
     */
    @Test
    public void testSearch() {
        assertTrue(binarySearchTree.search(8));
        assertFalse(binarySearchTree.search(99));
    }

    /**
     * Test to search a particular node. Should return true if the data is found and false if data is not present.
     */
    @Test
    public void testSearchNode() throws IOException {
        assertNotNull(binarySearchTree.searchNode(7));
    }

    /**
     * Test to search a particular node. Should return true if the data is found and false if data is not present.
     *
     * @throws IOException
     *             thrown when the item to be deleted is not found
     */
    @Test(expected = IOException.class)
    public void testSearchNode_whenPassedInvalidData() throws IOException {
        binarySearchTree.searchNode(99);
    }

    /**
     * Delete a node from tree
     *
     * @throws IOException
     *             thrown when the item to be deleted is not found
     */
    @Test
    public void testDelete() throws IOException {
        assertTrue(binarySearchTree.search(3));
        binarySearchTree.delete(3);
        assertFalse(binarySearchTree.search(3));
        assertEquals(7, binarySearchTree.size());
    }

    /**
     * When delete is called on a invalid data exception should be thrown
     *
     * @throws IOException
     *             thrown when the item to be deleted is not found
     */
    @Test(expected = IOException.class)
    public void testDeleteNode_whenPassedInvalidData() throws IOException {
        binarySearchTree.delete(99);
    }

}
