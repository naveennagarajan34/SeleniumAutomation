package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	private static Workbook workbook;
	private static Sheet sheet;

	public static void main(String[] args) throws IOException {
		loadExcelFile("C:\\Users\\Naveen\\eclipse-workspace\\sf_passwords.xlsx", "credentials");
		System.out.println(getCellValue(1, 0));
		System.out.println(getCellValue(1, 1));
		System.out.println(getCellValue(1, 2));
	}

	public static void loadExcelFile(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file); // Use XSSFWorkbook for .xlsx files
		sheet = workbook.getSheet(sheetName);
	}

	public static String getCellValue(int rowNum, int colNum) {
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		return cell.getStringCellValue();
	}

	public static int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int getColumnCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	// reading an entire row
	public static void readData() {
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.print(cell.getStringCellValue() + "\t");
			}
			System.out.println();
		}
	}

	public static void writeToExcel(String filePath, String sheetName, String[][] data) throws IOException {
		Workbook workbook = new XSSFWorkbook(); // For .xlsx files
		Sheet sheet = workbook.createSheet(sheetName);

		for (int i = 0; i < data.length; i++) {
			Row row = sheet.createRow(i);
			for (int j = 0; j < data[i].length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(data[i][j]);
			}
		}

		// Write the output to file
		FileOutputStream fileOut = new FileOutputStream(filePath);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}

}
