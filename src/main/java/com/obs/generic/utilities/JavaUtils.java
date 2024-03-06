package com.obs.generic.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils 
{
	
	/**
	 * This method is used for generating random number within specified range
	 * @param range
	 * @return
	 */
	public int getRandomNumber(int range)
	{
		Random random = new Random(range);
		int r = random.nextInt();
		return r;
		
	}
	
	
	/**
	 * This method is used to get the current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method is used to get the system date in required format
	 * @param Dateformat
	 * @return
	 */
	public String getSystemDateInFormat(String Dateformat)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(Dateformat);
		Date d = new Date();
		String formattedDate = sdf.format(d);
		return formattedDate;
	}

}
