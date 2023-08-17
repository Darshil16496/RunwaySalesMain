package com.crm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to getRandom Number
	 * @return
	 */
	public int getRandomNum() {
		Random r = new Random();
		int random = r.nextInt(500);
		return random;
		
	}
	
	/**
	 * This Method is Used to get System Date
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		String date=d.toString();
		return date;
	}
	
	/**
	 * This Method is Used to get System Date in Format
	 * @return
	 */
	public String getSystemDateInFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		//Date  d = new Date();
		String sysDateFormat = sdf.format(getSystemDate());
		return sysDateFormat;
	}
}
