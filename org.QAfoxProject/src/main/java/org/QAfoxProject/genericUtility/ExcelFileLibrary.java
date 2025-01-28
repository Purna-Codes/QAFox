package org.QAfoxProject.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Provides Re-Usable Methods To Peform CRUD in Excel File
 * 
 * @author Purna
 */

public class ExcelFileLibrary {
	FileInputStream fis;
	FileOutputStream fos;
	Workbook wb;
	DataFormatter df;

	/**
	 * This Method Used To Fetch The Single Data From Excel File
	 * 
	 * @param sheetName
	 * @param RowNumber
	 * @param column
	 * @return
	 */
	public String readSingleData(String sheet, int row, int column) {

		return wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
	}

	/**
	 * This Method Used To Fetch The Column Data From Excel File
	 * 
	 * @param sheetName
	 * @param column
	 * @return
	 */
	public ArrayList<Object> readSpecificColumnData(String sheet, int column) {

		// Fetch All The Data from One Specific Column ---> From Excel File
		int lastrow = wb.getSheet(sheet).getLastRowNum();

		ArrayList<Object> value = new ArrayList<Object>();

		for (int i = 1; i <= lastrow; i++) {
			String data = wb.getSheet(sheet).getRow(i).getCell(column).getStringCellValue();
			value.add(data);
		}

		return value;
	}

	/**
	 * This Method Used To Fetch The Specific Row Data From Excel File
	 * 
	 * @param sheetName
	 * @param row
	 * @return
	 */
	public ArrayList<Object> readSpecificRowData(String sheet, int row) {

		// Fetch the last cell number in one specific row
		int lastColumn = wb.getSheet(sheet).getRow(row).getLastCellNum();

		ArrayList<Object> value = new ArrayList<Object>();

		for (int i = 0; i < lastColumn; i++) {
			String data = wb.getSheet(sheet).getRow(row).getCell(i).getStringCellValue();
			value.add(data);
		}
		return value;
	}

	/**
	 * This Method Used To Display Multiple Records From Excel File
	 * 
	 * @param sheetName
	 */
	public void displayEntireTableData(String sheet) {
		
		// Getting The Last Row Number
		int lastrow = wb.getSheet(sheet).getLastRowNum();

		for (int i = 1; i < lastrow; i++) {
			int lastColumn = wb.getSheet(sheet).getRow(i).getLastCellNum();
			for (int j = 0; j < lastColumn; j++) {
				String data = wb.getSheet(sheet).getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + "\t");
			}
			System.out.println("\n******************************************************");
		}
	}

	/**
	 * This Method Used To Fetch Multiple Records From Excel File And Stores It In
	 * Map Reference As Key Value Pairs
	 * 
	 * @param sheetName
	 * @param expectedTestName
	 * @return
	 */
	public Map<String, String> readMultipleRecords(String sheet, String expectedTestName) {

		//
		Map<String, String> map = new HashMap<String, String>();
		Sheet sheetName = wb.getSheet(sheet);

		for (int i = 0; i <= sheetName.getLastRowNum(); i++)

		{
			if (df.formatCellValue(sheetName.getRow(i).getCell(1)).equals(expectedTestName)) {
				for (int j = i; j <= sheetName.getLastRowNum(); j++) {
					String key = df.formatCellValue(sheetName.getRow(j).getCell(2));
					String value = df.formatCellValue(sheetName.getRow(j).getCell(3));
					map.put(key, value);

					if (key.equals("####"))
						break;
				}
				break;
			}
		}
		return map;

	}

	/**
	 * This Method initializes Excel File
	 * 
	 */
	public void initExcel() {
		try {
			fis = new FileInputStream(PathConstant.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		df = new DataFormatter();
		
		// Newly Added
		try {
			fos = new FileOutputStream(PathConstant.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method Closes Excel File
	 * 
	 */
	public void closeExcel() {

		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method Writes Single Data into Excel File
	 * @param sheetName
	 * @param row
	 * @param column
	 * @param data
	 */
	public void writeSingleData(String sheet,int row,int column,String data) {
		//Create New Row and Create Data
		wb.getSheet(sheet).createRow(row).createCell(column).setCellValue(data);
		
		//Write The Data
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method Updates Single Data into Excel File
	 * @param sheetName
	 * @param row
	 * @param column
	 * @param data
	 */
	public void updateSingleData(String sheet,int row,int column,String data) {
		//Update Existing Row and Create Data
		wb.getSheet(sheet).getRow(row).createCell(column).setCellValue(data);
		//wb.getSheet(sheet).createRow(row).getCell(column).setCellValue(data);
		
		//Write The Data
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}