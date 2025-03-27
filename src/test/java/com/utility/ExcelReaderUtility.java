package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String fileName){
        
        File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
        XSSFWorkbook xssfWorkbook = null;  // Removed redundant declaration
        
        try {
            // Open the Excel file
            try {
				xssfWorkbook = new XSSFWorkbook(xlsxFile);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Initialize the workbook here

            List<User> userList = new ArrayList<User>();
            Row row;
            Cell emailAddressCell;
            Cell passwordCell;
            User user;

            XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            Iterator<Row> rowIterator = xssfSheet.iterator();

            rowIterator.next(); // Skipping the column name row
            while(rowIterator.hasNext()) {
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);

                // Create a new user object
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
            }
            
            return userList.iterator();
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // In case of error, return null
        } finally {
            if (xssfWorkbook != null) {
                try {
                    xssfWorkbook.close();  // Close the workbook in the finally block
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
