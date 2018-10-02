package edu.cs.ds.tree.binary;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test class for {@link MaxHeapTree}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaxHeapTreeTest {

    private final MaxHeapTree maxHeapTree = new MaxHeapTree();

    @Before
    public void setUp() throws IOException {
        maxHeapTree.addNode(new Node(8));
        maxHeapTree.addNode(new Node(10));
        maxHeapTree.addNode(new Node(23));
        maxHeapTree.addNode(new Node(12));
        maxHeapTree.addNode(new Node(45));
        maxHeapTree.addNode(new Node(75));
        maxHeapTree.addNode(new Node(87));
        maxHeapTree.addNode(new Node(18));
    }

    /**
     * Check whether all the elements added in {@link MaxHeapTreeTest#setUp()} has been added successfully to {@link MaxHeapTree}
     */
    @Test
    public void testAddNode() {
        assertEquals(8, maxHeapTree.size());
    }

    /**
     * Check whether the size and the maximum elements are returned correctly
     */
    @Test
    public void testRootNodeIsMaximum() {
        assertEquals(maxHeapTree.getMax().getData(), 87);
    }

    /**
     * Delete the Max node and verify the next maximum available Node will be returned properly
     * 
     * @throws IOException
     *             thrown if the data to be deleted is not found
     */
    @Test
    public void testDeleteMax() throws IOException {
        maxHeapTree.delete(87);
        assertEquals(maxHeapTree.getMax().getData(), 75);
        assertEquals(7, maxHeapTree.size());
    }
}
