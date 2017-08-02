package junit.testRule;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

import junit.testRule.RepeatRule.Repeat;

public class RandomRangeValueCalculatorImplTest {

	@Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 100)
    public void testCalculateRangeValue() {
        long center = 0;
        long radius = 10;
        RandomRangeValueCalculator calculator = new RandomRangeValueCalculatorImpl();

        long actual = calculator.calculateRangeValue(center, radius);
        System.out.println(actual);
        
        assertTrue(center + radius >= actual);
        assertTrue(center - radius <= actual);
    }

}
