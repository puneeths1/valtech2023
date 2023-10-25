package com.valtech.training.dayjava8;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// index year to 1900
		// month index with 0
		// day index with 1
		Date date = new Date(47, 7, 15); // 15th August 1947
		System.out.println(date);

		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println(independenceDay);
	}

}
