package com.bmusa.pages;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		 
		try {
	System.out.println("prop URL value" +config.getProperty("productionurl"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private static Properties config = new Properties();

	public static void loadFile() throws IOException {
		FileInputStream fis = new FileInputStream("E:\\Practice\\2021\\praticeMay21\\TestNG\\src\\test\\resources\\Testdata\\config.properties");
		config.load(fis);
		
		System.out.println("Value"+ config.getProperty("productionurl"));
		
		}

		
		  public static String getValue(String key) {
		  System.out.println(" Key value getting" + key); String name =
		  config.getProperty(key.toLowerCase());
		  System.out.println(" Key value getting" + config.size()); return
		  config.getProperty(key.toLowerCase());
		  
		  }
		 
}
