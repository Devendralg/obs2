package demoQspiderapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatClass {
	public static void main(String[] args) {
		Date d= new Date();

		SimpleDateFormat sdf = new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH
				
				));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("--------------------------");
		System.out.println(d);
		
	}

}
