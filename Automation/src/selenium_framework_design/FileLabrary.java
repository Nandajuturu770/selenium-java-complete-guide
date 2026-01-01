package selenium_framework_design;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Description : This class is used the to reas and set the date into file ==> Propety file and excel file
 * @author JUTURU NANDAKIRAN
 */
public class FileLabrary {
	/**
	 * Description : This is used the to get the property data 0f file  with help of providing key value to it.
	 * @author JUTURU NANDAKIRAN
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key ) throws IOException {
		FileInputStream fis = new FileInputStream("./data/commandata.property");
		Properties p = new  Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	/**
	 * Description : which is used to get  the data from the excel sheet 
	 * @author JUTURU NANDAKIRAN
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return Strint
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName , int row , int cell ) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/fireflink users.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		return s.getRow(row).getCell(cell).getStringCellValue();	
	}
	/**
	 * Descroption : which is used for the set the data value into the excell file 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param status
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelDate(String sheetName , int row , int cell, String status) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/fireflink users.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		s.getRow(row).getCell(cell).setCellValue(status);
		FileOutputStream fos = new FileOutputStream("./data/fireflink users.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println(status+ "is updated in the sheet name of "+sheetName+ " at row "+row+" and cell "+cell+"successfully");
	}
}
