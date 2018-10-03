package edu.cs.ds.tree.binary;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test class for {@link SumLeafNodes}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SumLeafNodesTest {

    /**
     * Test the the correct sum is returned when only positive data is in {@link BinaryTree}
     * 
     * @throws IOException
     *             thrown if null is tried to add into Tree
     */
    @Test
    public void testSumOfAllTheLeafNodes_withOnlyPositiveData() throws IOException {
        final SumLeafNodes sumLeafNodes = new SumLeafNodes();
        sumLeafNodes.addNode(new Node(3));
        sumLeafNodes.addNode(new Node(10));
        sumLeafNodes.addNode(new Node(34));
        sumLeafNodes.addNode(new Node(67));
        sumLeafNodes.addNode(new Node(7));
        sumLeafNodes.addNode(new Node(2));
        sumLeafNodes.addNode(new Node(1));
        sumLeafNodes.addNode(new Node(4));
        sumLeafNodes.addNode(new Node(8));
        sumLeafNodes.addNode(new Node(9));
        assertEquals(24, sumLeafNodes.sumLeafNodes());
    }

    /**
     * Test 0 is returned when there is no data in {@link BinaryTree}
     */
    @Test
    public void testSumOfAllTheLeafNodes_withNoNodes() {
        final SumLeafNodes sumLeafNodes = new SumLeafNodes();
        assertEquals(0, sumLeafNodes.sumLeafNodes());
    }

    /**
     * Test the the correct sum is returned when {@link BinaryTree} has only one {@link Node}
     * 
     * @throws IOException
     *             thrown if null is tried to add into Tree
     */
    @Test
    public void testSumOfAllTheLeafNodes_withOneNode() throws IOException {
        final SumLeafNodes sumLeafNodes = new SumLeafNodes();
        sumLeafNodes.addNode(new Node(3));
        assertEquals(3, sumLeafNodes.sumLeafNodes());
    }

    /**
     * Test the the correct sum is returned when negative data is in {@link BinaryTree}
     * 
     * @throws IOException
     *             thrown if null is tried to add into Tree
     */
    @Test
    public void testSumOfAllTheLeafNodes_withNegativeNumbers() throws IOException {
        final SumLeafNodes sumLeafNodes = new SumLeafNodes();
        sumLeafNodes.addNode(new Node(7));
        sumLeafNodes.addNode(new Node(92));
        sumLeafNodes.addNode(new Node(1));
        sumLeafNodes.addNode(new Node(-30));
        sumLeafNodes.addNode(new Node(-237));
        sumLeafNodes.addNode(new Node(-2));
        sumLeafNodes.addNode(new Node(1));
        sumLeafNodes.addNode(new Node(-6));
        sumLeafNodes.addNode(new Node(-1));
        sumLeafNodes.addNode(new Node(-5));
        assertEquals(-13, sumLeafNodes.sumLeafNodes());
    }
}
