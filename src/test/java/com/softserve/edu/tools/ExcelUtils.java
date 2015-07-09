package com.softserve.edu.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static final String FILE_NOT_READ = " File %s could not be read";
	private static final String FILE_NOT_ACCESIBLE = " File %s could not be Accesible";
	private static final String FILE_NOT_CLOSE = " File %s could not be closed";

	public List<List<String>> getAllCells(String absoluteFilePath) {
		List<List<String>> allRows = new ArrayList<List<String>>();
		InputStream inputStream = null;
		// For *.xls files
		// HSSFWorkbook workBook;
		// For *.xlsx files
		// XSSFWorkbook workBook = null;
		Sheet sheet = null;
		try {
			// System.out.println("filename=" + filename);
			inputStream = new FileInputStream(absoluteFilePath);
			// workBook = new XSSFWorkbook(inputStream);
			sheet = (new XSSFWorkbook(inputStream)).getSheetAt(0);
		} catch (FileNotFoundException e) {
			throw new GeneralCustomException(String.format(FILE_NOT_READ,
					absoluteFilePath));
		} catch (IOException e) {
			throw new GeneralCustomException(String.format(FILE_NOT_ACCESIBLE,
					absoluteFilePath));
		}
		// Sheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rowsIterator = sheet.iterator();
		while (rowsIterator.hasNext()) {
			Row row = rowsIterator.next();
			Iterator<Cell> cellsIterator = row.iterator();
			List<String> allCells = new ArrayList<String>();
			while (cellsIterator.hasNext()) {
				String s = cellsIterator.next().getStringCellValue();
				// allCells.add(cellsIterator.next().getStringCellValue());
				allCells.add(s);
			}
			allRows.add(allCells);
		}
		// if (workBook != null) {
		// try {
		// workBook.close();
		// } catch (IOException e) {
		// throw new GeneralCustomException(String.format(
		// FILE_NOT_CLOSE, absoluteFilePath), e);
		// }
		// }
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new GeneralCustomException(String.format(FILE_NOT_CLOSE,
						absoluteFilePath), e);
			}
		}
		return allRows;
	}

}
