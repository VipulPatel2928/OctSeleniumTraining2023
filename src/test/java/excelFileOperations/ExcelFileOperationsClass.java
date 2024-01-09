package excelFileOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileOperationsClass {

	//HSSF : Horrible SpreadSheet Format
	//XSSF : XML Spreadsheet Format 
	public static Sheet getExcelSheet(int sheetIndex) {
		String dataFilePath = "TestData/Credential.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;

		try {
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheetIndex);
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			System.out.println("This is get excel Sheet function");
		}
		return firstSheet;
	}
	
	public static String readDataFromExcelSheet(int sheet,int rowno,int colno) {	
		Cell cell = null;
		
		String cellData = "Default Value";
		
		if(getExcelSheet(sheet).getRow(rowno).getCell(colno).getCellType()==cell.CELL_TYPE_NUMERIC) {
			int cellNumericData = (int) getExcelSheet(sheet).getRow(rowno).getCell(colno).getNumericCellValue();
			cellData = String.valueOf(cellNumericData);
		}
		else if(getExcelSheet(sheet).getRow(rowno).getCell(colno).getCellType()==cell.CELL_TYPE_STRING) {
			cellData = getExcelSheet(sheet).getRow(rowno).getCell(colno).getStringCellValue();
		}
		return cellData;
	}


public static void writeInToExcelSheet(int sheet,int rowno,int colno,String value) {
		
		String dataFilePath = "TestData/Credential.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;
		Cell cell = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(fullpath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheet);
			cell = firstSheet.getRow(rowno).createCell(colno);
			cell.setCellValue(value);
			inputStream.close();
			
			FileOutputStream output_file = new FileOutputStream(new File(fullpath));
			workbook.write(output_file);
			workbook.close();
			output_file.close();
			System.out.println("Sheet Cell Value is Updated");
		} catch (Exception e) {
			System.out.println("Sheet Cell Value is Not Updated");
			System.out.println("Exception : "+e);
			System.out.println("This is write into excel Sheet function");
		} 
	}

	
	public static void main(String[] args) {
//		System.out.println(readDataFromExcelSheet(0, 0, 0));
//		System.out.println(readDataFromExcelSheet(0, 1, 0));
//		System.out.println(readDataFromExcelSheet(0, 2, 0));
//		System.out.println(readDataFromExcelSheet(0, 3, 0));
//		writeInToExcelSheet(0, 4, 0, "Learning Excel sheet how to read and write");
		System.out.println(readDataFromExcelSheet(0, 4, 0));
		
	}

}
