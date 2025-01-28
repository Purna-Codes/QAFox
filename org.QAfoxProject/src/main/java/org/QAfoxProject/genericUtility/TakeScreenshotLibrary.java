package org.QAfoxProject.genericUtility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotLibrary {

	/**
	 * Method to take a screenshot.
	 * 
	 * @param methodName - The name of the test method.
	 * @param timestamp  - The current timestamp or unique identifier for the file.
	 * 
	 * @return The file path of the saved screenshot.
	 */
	public static String takeScreenshot(String methodName, String timestamp, int randomNo) {

		String screenshotPath = "./TestScreenShot/" + methodName + "_" + timestamp + "_" + randomNo + ".png";

		// 1. Perform type casting to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) WebDriverLibrary.staticDriver;

		// 2. Capture the screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);

		// 3. Create the destination file path
		File destination = new File(screenshotPath);

		// 4. Copy the screenshot from source to destination
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshotPath; // Return the saved file path
	}
}
