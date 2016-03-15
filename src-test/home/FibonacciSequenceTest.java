package home;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciSequenceTest {
    @Test
    public void testFortyThirdMemberArray() throws Exception {
        assertEquals(701408733, FibonacciSequence.calcFibonacci(43));//это набор проверочных условий
        assertEquals(1, FibonacciSequence.calcFibonacci(1));
        assertEquals(1, FibonacciSequence.calcFibonacci(4));
    }
}