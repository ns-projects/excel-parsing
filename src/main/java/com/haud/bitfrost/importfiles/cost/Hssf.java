package com.haud.bitfrost.importfiles.cost;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.haud.bitfrost.importfiles.model.PriceDTO;

public class Hssf {
	public void excel97xlsread(String file) throws IOException {

		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			ArrayList<PriceDTO> list = new ArrayList<PriceDTO>();

			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				PriceDTO e = new PriceDTO(list);

				Row row = sheet.getRow(i);
				for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
					Cell ce = row.getCell(j);
					if (j == 0) {

						e.setCountry(ce.getStringCellValue());
					} else if (j == 1) {
						e.setNetwork(ce.getStringCellValue());
					} else if (j == 2) {
						e.setMcc(ce.getNumericCellValue());
					} else if (j == 3) {
						e.setMnc(ce.getNumericCellValue());
					} else if (j == 4) {
						e.setRoute(ce.getStringCellValue());
					} else if (j == 5) {
						e.setPrice(ce.getNumericCellValue());
					}
				}
				list.add(e);
			}
			for (PriceDTO emp : list) {
				System.out.println("Country:" + emp.getCountry() + ";" + " network:" + emp.getNetwork() + ";" + " Mcc:"
						+ emp.getMcc() + ";" + " Mnc:" + emp.getMnc() + ";" + " Route:" + emp.getRoute() + ";"
						+ " Price:" + emp.getPrice());
			}

			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}

//FileInputStream fis = new FileInputStream(file);
//HSSFWorkbook wb = new HSSFWorkbook(fis);
//
//HSSFSheet sheet = wb.getSheetAt(0);
//
//Iterator<Row> rowIt = sheet.iterator();
//
//while (rowIt.hasNext()) {
//	Row row = rowIt.next();
//
//	Iterator<Cell> cellIterator = row.cellIterator();
//
//	while (cellIterator.hasNext()) {
//		Cell cell = cellIterator.next();
//		System.out.print(cell.toString() + ";");
//	}
//	System.out.println();
//}
//wb.close();
