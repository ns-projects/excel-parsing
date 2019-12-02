
package com.haud.bitfrost.importfiles.cost;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.haud.bitfrost.importfiles.model.PriceDTO;

public class Xssf {

	public void readFromExcel(String file) throws IOException {

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));

			XSSFSheet sheet = workbook.getSheetAt(0);

			ArrayList<PriceDTO> employeeList = new ArrayList<PriceDTO>();

			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				PriceDTO e = new PriceDTO(employeeList);

				Row ro = sheet.getRow(i);
				for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
					Cell ce = ro.getCell(j);
					if (j == 0) {

						e.setCountry(ce.getStringCellValue());
					}
					if (j == 1) {
						e.setNetwork(ce.getStringCellValue());
					}
					if (j == 2) {
						e.setMcc(ce.getNumericCellValue());
					}
					if (j == 3) {
						e.setMnc(ce.getNumericCellValue());
					}
					if (j == 4) {
						e.setRoute(ce.getStringCellValue());
					}
					if (j == 5) {
						e.setPrice(ce.getNumericCellValue());
					}
				}
				employeeList.add(e);
			}
			for (PriceDTO emp : employeeList) {
				System.out.println("Country:" + emp.getCountry() + ";" + " network:" + emp.getNetwork() + ";" + " Mcc:"
						+ emp.getMcc() + ";" + " Mnc:" + emp.getMnc() + ";" + " Route:" + emp.getRoute() + ";"
						+ " Price:" + emp.getPrice());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}