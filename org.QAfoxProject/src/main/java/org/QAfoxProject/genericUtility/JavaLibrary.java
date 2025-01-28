package org.QAfoxProject.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This Class Contains reusable methods to perform Java related operations
 * 
 * @author Purna
 */
public class JavaLibrary {

	/**
	 * This Method is used to pause the script execution for specified time
	 * 
	 * @param time
	 */
	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method is used to fetch current date and time
	 * 
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}

	/**
	 * This Method is used to Generate random number within the specified limit
	 * 
	 * @param limit
	 * @return
	 */
	public int getRandom(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}

}