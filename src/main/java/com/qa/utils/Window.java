package com.qa.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Window {
	
	public static void propertFileCreater() throws IOException{
		Properties props = new Properties();
		FileOutputStream fis = new FileOutputStream("D://Automation//SeleniumTestNGFramework//log4j.properties");
		props.setProperty("log4j.rootCategory", "debug");
		props.setProperty("log4j.appender.console", "org.apache.log4j.ConsoleAppender");
		props.setProperty("log4j.appender.console.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.console.layout.ConversionPattern", "%d{MM-dd-yyyy HH:mm:ss} %F %-5p [%t] %c{2} %L - %m%n");
		props.setProperty("log4j.appender.file", "org.apache.log4j.RollingFileAppender");
		props.setProperty("log4j.appender.file.File", "target/Logs/CRMLogs$"+Constants.getDateTimeString()+".log");
		props.setProperty("log4j.appender.file.MaxFileSize", "10mb");
		props.setProperty("log4j.appender.file.MaxBackupIndex", "10");
		props.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.file.layout.ConversionPattern", "%d{ISO8601} %5p [%t] %c{1}:%L - %m%n");
		props.setProperty("log4j.appender.file.Append", "false");
		
        //writing properites into properties file from Java
        props.store(fis, "Properties file generated from Java program");
        fis.close();
	}
	
	public static String getRandomtString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static void main(String[] args) throws IOException {
		propertFileCreater();
		System.out.println("Created");
		System.out.println(getRandomtString(5));
		
	}	
}
