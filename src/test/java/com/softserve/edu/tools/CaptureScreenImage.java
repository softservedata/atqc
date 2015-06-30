package com.softserve.edu.tools;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenImage {
	private final String TIME_TEMPLATE = "yyyy_MM_dd HH-mm-ss";
	private final String FILE_SUFFIX = " CaptureScreenImage.png";
	private final String DEFAULT_DIRECTORY = "./test-output";
	private final String SLASH = "/";
	private final String FAILED_TO_CREATE = "Failed to create screenshot: %s";
	private static volatile CaptureScreenImage instance = null;

	private CaptureScreenImage() {
	}

	public static CaptureScreenImage get() {
		if (instance == null) {
			synchronized (CaptureScreenImage.class) {
				if (instance == null) {
					instance = new CaptureScreenImage();
				}
			}
		}
		return instance;
	}

	private String getCurrentTime() {
		return new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
	}

	private String getOutputDirectory() {
		return DEFAULT_DIRECTORY + SLASH;
	}

	private String getAbsolutePathFileName() {
		return getOutputDirectory() + getCurrentTime() + FILE_SUFFIX;
	}

	/**
	 * @return Absolute path of filename.
	 */
	public String captureAndSaveScreen() {
		String absolutePathFileName = getAbsolutePathFileName();
		try {
			File srcFile = ((TakesScreenshot) WebDriverUtils.get()
					.getWebDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(absolutePathFileName));
		} catch (Exception e) {
			// Develop custom exception.
			throw new GeneralCustomException(String.format(FAILED_TO_CREATE,
					absolutePathFileName), e);
		}
		return absolutePathFileName;
	}

}
