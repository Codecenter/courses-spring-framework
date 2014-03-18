package exercise1.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import exercise1.Utils;

public class UtilsImpl implements Utils {
	@Override
	public int randomInt(int minValue, int maxValue) {
		System.out.println("randomInt was here!");
		int values = maxValue - minValue + 1;
		return minValue + (int)(values * Math.random());
	}


	@Override
	public void sort(String[] values) {
		System.out.println("sort was here!");
		Arrays.sort(values);
	}

	@Override
	public Date today() {
		System.out.println("today was here!");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	@Override
	public String randomFailure() {
		System.out.println("randomFailure was here!");
		if (Math.random() < 0.5) {
			throw new IllegalStateException("Random failure!");
		}
		else {
			return "OK";
		}
	}
}
