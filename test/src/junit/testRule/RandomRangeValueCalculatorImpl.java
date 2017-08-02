package junit.testRule;

import java.util.Random;

public class RandomRangeValueCalculatorImpl implements RandomRangeValueCalculator {

	@Override
	public long calculateRangeValue(long center, long radius) {
		Random random = new Random();
		return center + random.nextLong()%radius;
	}

}
