package org.QAfoxProject.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class Provides Reusable Methods To Perform CRUD In Property File
 * @author Purna
 */
public class PropertyFileLibrary {
	FileInputStream fis;
	FileOutputStream fos;
	Properties property;

	/**
	 * This method Used to initialize property file 
	 * 
	 */
	public void initPropertyFile() {

		// 1.Convert the physical file into Java understandable
		try {
			fis = new FileInputStream(PathConstant.PROPERTY_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an object for property class
		property = new Properties();

		// 3.Load the property file
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method Used to read data from the property file 
	 * @param key
	 * @return
	 */
	public String readProperty(String key) {
		return property.getProperty(key);
	}

	/**
	 * This method Used to display the data in the property file 
	 * @param key
	 * @return
	 */
	public void displayProperty(String key) {
		String value = property.getProperty(key);
		System.out.println("Value for the " + key + " is: " + value);
	}

	/**
	 * This method Used to Write Data In The Property File 
	 * @param key
	 * @param value
	 * @return
	 */
	public void writeProperty(String key, String value) {

		// Enter The data
		property.put(key, value); // ------------>1

		// Create Instance For FileOutputStream class
		try {
			fos = new FileOutputStream(PathConstant.PROPERTY_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Store The Data
		try {
			property.store(fos, "Updated Latest Data!!!!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method Used to Close property file 
	 * 
	 */
	public void closePropertyFile() {

		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (this.fos!=null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}