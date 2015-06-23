package com.softserve.edu.tools;

import org.testng.Reporter;

public class LoggerWrapper {
    private static volatile LoggerWrapper instance = null;

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
        Reporter.log("<br>[ERROR] " + message);
    }

    public void infoLog(String message) {
        Reporter.log("<br>[INFO] " + message);
    }

}
