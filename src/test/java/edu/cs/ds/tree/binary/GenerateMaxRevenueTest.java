package edu.cs.ds.tree.binary;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test class for {@link GenerateMaxRevenue}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenerateMaxRevenueTest {

    /**
     * Check whether max revenue is generated for 5 tickets from 9 windows
     */
    @Test
    public void testMaxRevenue() {
        final GenerateMaxRevenue generateMaxRevenue = new GenerateMaxRevenue();
        generateMaxRevenue.addTickets(3);
        generateMaxRevenue.addTickets(5);
        generateMaxRevenue.addTickets(10);
        generateMaxRevenue.addTickets(6);
        generateMaxRevenue.addTickets(12);
        generateMaxRevenue.addTickets(15);
        generateMaxRevenue.addTickets(2);
        generateMaxRevenue.addTickets(13);
        assertEquals(generateMaxRevenue.sellTickets(5), 67);
    }

    /**
     * Check whether max revenue is generated for 5 tickets from 6 windows
     */
    @Test
    public void testMaxRevenue2() {
        final GenerateMaxRevenue generateMaxRevenue = new GenerateMaxRevenue();
        generateMaxRevenue.addTickets(5);
        generateMaxRevenue.addTickets(1);
        generateMaxRevenue.addTickets(7);
        generateMaxRevenue.addTickets(10);
        generateMaxRevenue.addTickets(11);
        generateMaxRevenue.addTickets(9);
        assertEquals(generateMaxRevenue.sellTickets(5), 40);
    }
}
