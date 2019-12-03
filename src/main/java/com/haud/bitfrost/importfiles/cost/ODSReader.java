package com.haud.bitfrost.importfiles.cost;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Range;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.haud.bitfrost.importfiles.model.PriceDTO;

public class ODSReader {

	public String readODS(String file) {

		SpreadSheet spreadsheet;

//		try {
//			File fis = new File(file);
//			spreadsheet = SpreadSheet.createFromFile(fis);
//
//			int nColCount = spreadsheet.getSheet(0).getColumnCount();
//			int nRowCount = spreadsheet.getSheet(0).getRowCount();
//
//			MutableCell<?> cell = null;
//			for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {
//
//				for (int nColIndex = 0; nColIndex < nColCount; nColIndex++) {
//					cell = spreadsheet.getSheet(0).getCellAt(nColIndex, nRowIndex);
//					System.out.print(cell.getValue() + " ");
//					
//					if (cell.getValue().toString().isEmpty()) {
//						nRowIndex++;
//						System.out.println();
//						nColIndex = -1;
//						cell = spreadsheet.getSheet(0).getCellAt(0, nRowIndex);
//						if (cell.getValue().toString().isEmpty()) {
//							return null;
//						}
//					}
//				}
//			}
//			System.out.println();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;

		try {
			File fis = new File(file);
			spreadsheet = SpreadSheet.createFromFile(fis);

			int nColCount = spreadsheet.getSheet(0).getColumnCount();
			int nRowCount = spreadsheet.getSheet(0).getRowCount();
			Sheet sheet = spreadsheet.getSheet(0);
			// Range range=sheet.getUsedRange();
			// System.out.println("RANGE: "+range.toString());

			ArrayList<PriceDTO> list = new ArrayList<PriceDTO>();

			MutableCell<?> cell = null;

			for (int nRowIndex = 1; nRowIndex < nRowCount; nRowIndex++) {

				PriceDTO e = new PriceDTO(list);

				cell = spreadsheet.getSheet(0).getCellAt(0, nRowIndex);
				if (cell.getValue().toString().isEmpty()) {

					return null;
				}

				for (int nColIndex = 0; nColIndex < nColCount; nColIndex++) {
					cell = spreadsheet.getSheet(0).getCellAt(nColIndex, nRowIndex);

					try {
						if (nColIndex == 0) {
							e.setCountry(cell.getValue().toString());
						}

						if (nColIndex == 1) {
							e.setNetwork(cell.getValue().toString());
						}

						if (nColIndex == 2) {
							e.setMcc((Integer.parseInt(cell.getValue().toString())));
						}
						if (nColIndex == 3) {
							e.setMnc((Integer.parseInt(cell.getValue().toString())));
						}
						if (nColIndex == 4) {
							e.setRoute(cell.getValue().toString());
						}
						if (nColIndex == 5) {
							e.setPrice((Double.parseDouble(cell.getValue().toString())));
						}

					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
				}

				list.add(e);
				System.out.println(e);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
