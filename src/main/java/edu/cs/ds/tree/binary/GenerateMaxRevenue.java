package edu.cs.ds.tree.binary;

import java.io.IOException;

/**
 * Given ‘N’ windows where each window contains certain number of tickets at each window. Price of a ticket is equal to number of tickets remaining at
 * that window. Write an algorithm to sell ‘k’ tickets from these windows in such a manner so that it generates the maximum revenue.
 */
public class GenerateMaxRevenue {

    MaxHeapTree maxHeapTree = new MaxHeapTree();

    /**
     * Add the number of tickets available in the new window
     * 
     * @param noOfTickets
     *            A int representing the number of tickets available
     */
    public void addTickets(final int noOfTickets) {
        try {
            maxHeapTree.addNode(new Node(noOfTickets));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the maximum revenue that can be generated be selling the argument number of tickets
     * 
     * @param noOfTickets
     *            a int representing the number of tickets the needs to be sold
     * @return a int representing the maximum revenue
     */
    public int sellTickets(final int noOfTickets) {
        int revenue = 0;
        for (int i = 0; i < noOfTickets; i++) {
            revenue += maxHeapTree.getMax();
            maxHeapTree.updateMax(maxHeapTree.getMax() - 1);
        }
        return revenue;
    }
}
