package solution1;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UtilsTest {
	@Autowired
	private Utils utils;

	@Test
	public void testRandomInt() {
		final int MIN_VALUE = 1;
		final int MAX_VALUE = 10;
		for (int i = 0; i < 10; i++) {
			int value = utils.randomInt(MIN_VALUE, MAX_VALUE);
			assertTrue("Random value less than lower limit: " + value,
					MIN_VALUE <= value);
			assertTrue("Random value higher than upper limit: " + value,
					value <= MAX_VALUE);
		}
	}

	@Test
	public void testSort() {
		final String[] INPUT = { "Linda", "John", "Matt", "Jake", };
		final String[] EXPECTED = { "Jake", "John", "Linda", "Matt", };
		utils.sort(INPUT);
		assertArrayEquals(EXPECTED, INPUT);
	}

	@Test
	public void testToday() {
		Calendar calendar = Calendar.getInstance();

		Calendar output = Calendar.getInstance();
		output.setTime(utils.today());

		assertEquals("Date has invalid YEAR", calendar.get(Calendar.YEAR),
				output.get(Calendar.YEAR));
		assertEquals("Date has invalid MONTH", calendar.get(Calendar.MONTH),
				output.get(Calendar.MONTH));
		assertEquals("Date has invalid DAY_OF_MONTH",
				calendar.get(Calendar.DAY_OF_MONTH),
				output.get(Calendar.DAY_OF_MONTH));

		assertEquals("Date has HOUR_OF_DAY", 0,
				output.get(Calendar.HOUR_OF_DAY));
		assertEquals("Date has MINUTE", 0, output.get(Calendar.MINUTE));
		assertEquals("Date has SECOND", 0, output.get(Calendar.SECOND));
		assertEquals("Date has MILLISECOND", 0,
				output.get(Calendar.MILLISECOND));
	}

	@Test
	public void testRandomFailure() {
		utils.randomFailure();
	}
}
