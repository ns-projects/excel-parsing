package com.haud.bitfrost.importfiles.cost;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Hssf {
	public void run() throws IOException {
		FileInputStream fis = new FileInputStream("price_example_excel97.xls");
		HSSFWorkbook wb = new HSSFWorkbook(fis);

		HSSFSheet sheet = wb.getSheetAt(0);

		Iterator<Row> rowIt = sheet.iterator();

		while (rowIt.hasNext()) {
			Row row = rowIt.next();

			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.print(cell.toString() + ";");
			}
			System.out.println();
		}
		wb.close();
	}
}
