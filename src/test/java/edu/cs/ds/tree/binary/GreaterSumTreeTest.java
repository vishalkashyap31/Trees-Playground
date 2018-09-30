package edu.cs.ds.tree.binary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test class for {@link BinarySearchTree}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GreaterSumTreeTest {

    GreaterSumTree greaterSumTree = new GreaterSumTree();

    @Before
    public void setUp() throws IOException {
        greaterSumTree.addNode(new Node(10));
        greaterSumTree.addNode(new Node(5));
        greaterSumTree.addNode(new Node(15));
        greaterSumTree.addNode(new Node(2));
        greaterSumTree.addNode(new Node(7));
        greaterSumTree.addNode(new Node(12));
        greaterSumTree.addNode(new Node(20));
    }

    /**
     * Check if the total sum of all the nodes is returned properly.
     */
    @Test
    public void testGetTotalSum() {
        assertEquals(71, greaterSumTree.getTotalSum());
    }

    /**
     * Check if the {@link BinarySearchTree} has been converted into {@link GreaterSumTree} properly
     */
    @Test
    public void testConvertBST2GreaterSumTree() {
        greaterSumTree.convertBST2GreaterSumTree();
        assertTrue(greaterSumTree.search(69));
        assertTrue(greaterSumTree.search(0));
        assertTrue(greaterSumTree.search(20));
        assertTrue(greaterSumTree.search(47));
        assertTrue(greaterSumTree.search(57));
    }
}
