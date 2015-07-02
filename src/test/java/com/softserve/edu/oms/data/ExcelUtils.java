package com.softserve.edu.oms.data;

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
	private List<IUser> users = new ArrayList<IUser>();

	public ExcelUtils(String filename) {
		readFromExcel(filename);
	}

	private void readFromExcel(String filename) {
		InputStream in;
		// HSSFWorkbook wb;
		XSSFWorkbook wb;
		//
		IUser user;
		try {
			// System.out.println("filename=" + filename);
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + filename + " not Found");
		}
		try {
			wb = new XSSFWorkbook(in);
		} catch (IOException e) {
			throw new RuntimeException("File " + filename + " not Accesible");
		}
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		while (it.hasNext()) {
			Row row = it.next();
			Iterator<Cell> cells = row.iterator();
			user = User
					.get()
					.setFirstName(
							cells.hasNext() ? cells.next().getStringCellValue()
									: "")
					.setLastName(
							cells.hasNext() ? cells.next().getStringCellValue()
									: "")
					.setLoginName(
							cells.hasNext() ? cells.next().getStringCellValue()
									: "")
					.setPassword(
							cells.hasNext() ? cells.next().getStringCellValue()
									: "")
					.setEmail(
							cells.hasNext() ? cells.next().getStringCellValue()
									: "")
					.setRole(
							cells.hasNext() ? cells.next().getStringCellValue()
									: "").build();
			users.add(user);
		}
		//
		if (wb != null) {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<IUser> getAll() {
		return users;
	}

	public IUser getUser(int number) {
		return users.get(number);
	}

	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();
		for (IUser user : users) {
			list.append("\nLogin:" + user.getLoginName() + " Password:"
					+ user.getPassword());
		}
		return list.toString();
	}

}
