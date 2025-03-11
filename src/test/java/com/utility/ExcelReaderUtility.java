package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName){
		
		
		File xlsxFile=new File(System.getProperty("user.dir") + "//testData//"+fileName);
		XSSFWorkbook xssfWorkbook=null;
		
		//xlsx file
		XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
		List<User> userList=new ArrayList<User>();
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		XSSFSheet xssfSheet= xssfWorkbook.getSheet("LoginTestData");
		Iterator<Row> rowIterator=xssfSheet.iterator();
		
		rowIterator.next();//Skipping the col name
		while(rowIterator.hasNext()) {
			row=rowIterator.next();
			emailAddressCell=row.getCell(0);
			 passwordCell=row.getCell(1);
			//System.out.print(firstCell.toString());
			//System.out.print(secondCell.toString());
			user=new User(emailAddressCell.toString(), passwordCell.toString());
			userList.add(user);
		}
		try {
			xssfWorkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
