package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;
import com.ui.pojo.User;

public class CSVReaderUtility {
	public static Iterator<User> readCSVFile(String fileName) {
	//where the file is present
	
		File csvFile=new File(System.getProperty("user.dir") + "//testData//"+fileName);
		FileReader fileReader=null;;//declaration should be before try not done inside try -rule
		CSVReader csvReader;
		String[] line;
		User userData;
		List<User>userList = null;
		try {
		 fileReader=new FileReader(csvFile);
		 csvReader=new CSVReader(fileReader);
		  csvReader.readNext();//row4 or end of the csv file w
		userList=new ArrayList<User>();
		
		while((line=csvReader.readNext())!=null){
			 userData=new User(line[0],line[1]);
			userList.add(userData);
			
			
			
		}
		for(User user:userList) {
			System.out.print(user);
		}
	
		
		
		 
		 
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}
		
		catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
