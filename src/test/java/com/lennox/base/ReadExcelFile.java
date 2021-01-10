package com.lennox.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static final String projectPath = System.getProperty("user.dir");

	public static Map<String, String> excelData = new HashMap<String, String>();
	public static Map<String, String> credentials = new HashMap<String, String>();
	public static Map<String, String> uiTexts = new HashMap<String, String>();
	static FileInputStream stream;
	static String testDataPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Row row;
	static Cell cell;
	private String value;
	private String key;

	public void readExcel(String filePath) {

		try {

			stream = new FileInputStream(projectPath+filePath);
			workbook = new XSSFWorkbook(stream);
			sheet = workbook.getSheetAt(0);

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				key = row.getCell(0).getStringCellValue();

				for(int j = 1; j < row.getPhysicalNumberOfCells(); j++) {

					cell = row.getCell(j);
					switch (cell.getCellType()) {
					case NUMERIC:

						double num = row.getCell(j).getNumericCellValue();
						value = Double.toString(num);

						break;
					case STRING:

						value = row.getCell(j).getStringCellValue();

						break;
					default:
						
						break;
					}

					if (filePath.contains("TestDataXL")) {

						excelData.put(key, value);
					}
					else if(filePath.contains("Credentials")) {

						credentials.put(key, value);

					}

					else if(filePath.contains("UITexts")) {

						uiTexts.put(key, value);

					}


				}
			}

			workbook.close();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}