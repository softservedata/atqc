package com.softserve.edu.tools;

public class ScreenCapturingCustomException extends GeneralCustomException {
    private static final long serialVersionUID = 1L;
    private static final String SCREENSHOT_FILENAME = "Screenshot filename is ";

    // Classic constructor with a message of error.
    public ScreenCapturingCustomException(String message) {
        super(message);
        takeScreenshot();
    }

    public ScreenCapturingCustomException(String message, Throwable e) {
        super(message, e);
        takeScreenshot();
    }

    private void takeScreenshot() {
		String fileNamePath = CaptureScreenImage.get().captureAndSaveScreen();
		LoggerWrapper.get().infoLog(SCREENSHOT_FILENAME + fileNamePath);
		LoggerWrapper.get().infoLogInsertScreenShot(fileNamePath);
	}
}
