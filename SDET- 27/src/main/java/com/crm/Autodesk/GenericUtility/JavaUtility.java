package com.crm.Autodesk.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Hritik
 *
 */
public class JavaUtility {
	/**
	 * It is used to generate the random number.
	 * @return int data.
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int intRandom = ran.nextInt(10000);
		return intRandom;
	}
/**
 * used to get system Date & Time in IST format
 */
public String getSystemDateAndTime() {
	Date date  = new Date();
	return date.toString();
}
/**
 * used to get system date in YYYY-MM-DD fromat
 */
public String getSystemDateWithFormate() {
	Date date = new Date();
	String dateAndTime = date.toString();
	String YYYY= dateAndTime.split(" ")[5];
	String DD = dateAndTime.split(" ")[2];
	int MM = date.getMonth()+1;
	String finalFormate = YYYY+"-"+MM+"-"+DD;
	return finalFormate;
}
}
