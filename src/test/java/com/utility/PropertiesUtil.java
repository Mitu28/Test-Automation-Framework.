package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	//job of this class is to help read properties files

	public static String readProprty(Env env,String propertyName) {
		
		System.out.print(System.getProperty("user.dir"));
		
	File propFile=new File(System.getProperty("user.dir") +env+"//config//QA.properties");
	FileReader fileReader = null;
	Properties properties=new Properties();
	try {
		fileReader = new FileReader(propFile);
		properties.load(fileReader);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	String value =properties.getProperty(propertyName.toUpperCase());
	System.out.print(value);
	return value;
	
	
	
	

	}

}
