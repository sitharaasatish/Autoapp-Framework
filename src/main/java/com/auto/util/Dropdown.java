package com.auto.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	private static Logger Log = Logger.getLogger(Dropdown.class.getName());//

	public static void singleSelectDropDown(WebElement dropdownelement, String value) {
		Log.info(" INFO Value which is going to be slected : "+value);
		Log.debug(" DEBUG Value which is going to be slected : "+value);
		Log.warn(" WARN Value which is going to be slected : "+value);
		Log.fatal("FATAL Value which is going to be slected : "+value);
		Log.error("ERROR Value which is going to be slected : "+value);
		Select ss = new Select(dropdownelement);
		ss.selectByValue(value);
	}

	public static void singleSelectDropDown(WebElement dropdownelement, int index) {
		Log.info("Index which is going to be slected : "+index);
		Select ss = new Select(dropdownelement);
		ss.selectByIndex(index);
	}

	public static void singleSelectDropDownByVisibleText(WebElement dropdownelement, String text) {
		Log.info("Visible Text which is going to be slected : "+text);
		Select ss = new Select(dropdownelement);
		ss.selectByVisibleText(text);
	}
}
