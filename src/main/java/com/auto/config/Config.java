package com.auto.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Config {
	
	public static Logger log = Logger.getLogger(Config.class);
	static Properties configProperties ;
	public static Properties loadConfigProperties() {
		try {
			configProperties = new Properties();
			FileInputStream fis = new FileInputStream("config.properties");
			log.info("Loaded the config.properties file to FileInputStream Successfully");
			configProperties.load(fis);
			log.info("Loaded the config.properties file to FileInputStream to properties successfully");
		} catch (FileNotFoundException e) {
			log.error("config.properties FILE not found");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Unable to Read config.properties");
			e.printStackTrace();
		}
		return configProperties;
	}



}


