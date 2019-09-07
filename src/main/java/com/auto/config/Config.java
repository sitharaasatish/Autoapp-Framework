package com.auto.config;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class Config {
	public Config() {
		loadConfig();
		setValues();
	}
	private Properties projectConfigprop = new Properties();

	public String AppURL;
	public String Username;
	public String Password;

	private void loadConfig() {
		try {
			projectConfigprop.load(new FileInputStream("config.properties"));
			// browserProp.load(new FileInputStream(" "));
		} catch (Exception e) {
			System.out.println("ERROR Reading the config file");
		}
	}

	private void setValues() {
			AppURL = System.getProperty("AppURL");
			Username = System.getProperty("Username");
			Password = System.getProperty("Password");
		}

}


