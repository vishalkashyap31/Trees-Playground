package edu.cs.ds.tree.binary;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test class for {@link SumTree}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SumTreeTest {

    /**
     * Test {@link SumTree} but there is nothing much to assert
     * 
     * @throws IOException
     *             thrown when null is tried to be added into the tree
     */
    @Test
    public void testSumTree_withCompleteBinaryTree() throws IOException {
        final SumTree sumTree = new SumTree();
        sumTree.addNode(new Node(1));
        sumTree.addNode(new Node(2));
        sumTree.addNode(new Node(3));
        sumTree.addNode(new Node(4));
        sumTree.addNode(new Node(5));
        sumTree.addNode(new Node(6));
        sumTree.addNode(new Node(7));

        sumTree.converToSumTree();
    }
}
