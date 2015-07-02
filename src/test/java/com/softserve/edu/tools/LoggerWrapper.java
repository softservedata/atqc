package com.softserve.edu.tools;

import org.testng.Reporter;

public class LoggerWrapper {
    private static volatile LoggerWrapper instance = null;
	private final String SLASH = "/";
	private final String BR_ERROR = "<br>[ERROR] ";
	private final String BR_INFO = "<br>[INFO] ";
	//private final String BR_BEGIN_IMG = "<br><image width=\"50%\" src=\"";
	private final String BR_BEGIN_IMG = "<br><div><image style=\"max-width:100%\" src=\"";
	//private final String BR_END_IMG = "\"/>";
	private final String BR_END_IMG = "\"/></div>";

    private LoggerWrapper() {
    }

    public static LoggerWrapper get() {
        if (instance == null) {
            synchronized (LoggerWrapper.class) {
                if (instance == null) {
                    instance = new LoggerWrapper();
                }
            }
        }
        return instance;
    }

	public void errorLog(String message) {
		Reporter.log(BR_ERROR + message);
	}

	public void infoLog(String message) {
		Reporter.log(BR_INFO + message);
	}

	public void infoLogInsertScreenShot(String fileNamePath) {
		Reporter.log(BR_BEGIN_IMG
				+ fileNamePath.substring(fileNamePath.lastIndexOf(SLASH) + 1)
				+ BR_END_IMG);
	}

}
