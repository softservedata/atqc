package com.softserve.edu.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class CaptureScreenImage {
    private final String TIME_TEMPLATE = "yyyy_MM_dd HH-mm-ss";
    private final String FILE_SUFFIX = " CaptureScreenImage.png";
    private final String FILE_EXTENSION = "png";
    private final String DEFAULT_DIRECTORY = "./test-output";
    private final String MAVEN_DIRECTORY = "surefire.reports.directory";
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
        String outputDirectory = System.getProperty(MAVEN_DIRECTORY);
        if ((outputDirectory == null) || (outputDirectory.isEmpty())) {
            outputDirectory = DEFAULT_DIRECTORY;
        }
        return outputDirectory + SLASH;
    }

    private String getAbsolutePathFileName() {
        return getOutputDirectory() + getCurrentTime()
                + FILE_SUFFIX;
    }

    /**
     * @return Absolute path of filename.
     */
    /*
    public String captureAndSaveScreen() {
        String absolutePathFileName = getAbsolutePathFileName();
        ScreenImage screenImage = SikuliScreenWrapper.get().getCurrentScreen()
                .capture(SikuliScreenWrapper.get().getCurrentScreen().getBounds());
        BufferedImage bufferedImage = screenImage.getImage();
        try {
            ImageIO.write(bufferedImage, FILE_EXTENSION, new File(
                    absolutePathFileName));
        } catch (IOException e) {
            // Develop custom exception.
            throw new GeneralCustomException(String.format(FAILED_TO_CREATE,
                    absolutePathFileName), e);
        }
        return absolutePathFileName;
    }
    */

}
