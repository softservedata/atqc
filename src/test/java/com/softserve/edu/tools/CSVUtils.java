package com.softserve.edu.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {
	private static final String PROPERTIES_EXCEPTION_READ = " File %s could not be read";
	private static final String PROPERTIES_EXCEPTION_CLOSE = " File %s could not be closed";
	private static final String CSV_SPLIT_BY = ",";

	public List<List<String>> getAllCells(String absoluteFilePath) {
		List<List<String>> allCells = new ArrayList<List<String>>();
		String row;
		// List<String> row;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
					new FileReader(absoluteFilePath));
			while ((row = bufferedReader.readLine()) != null) {
				allCells.add(Arrays.asList(row.split(CSV_SPLIT_BY)));
			}

		} catch (IOException e) {
			throw new GeneralCustomException(String.format(
					PROPERTIES_EXCEPTION_READ, absoluteFilePath), e);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					throw new GeneralCustomException(String.format(
							PROPERTIES_EXCEPTION_CLOSE, absoluteFilePath), e);
				}
			}
		}
		return allCells;
	}

}
