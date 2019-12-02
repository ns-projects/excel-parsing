package com.haud.bitfrost.importfiles.cost;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class ODSReader {

	public String readODS(String file) {

		SpreadSheet spreadsheet;

		try {
			File fis = new File(file);
			spreadsheet = SpreadSheet.createFromFile(fis);

			int nColCount = spreadsheet.getSheet(0).getColumnCount();
			int nRowCount = spreadsheet.getSheet(0).getRowCount();

			MutableCell cell = null;
			for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {

				for (int nColIndex = 0; nColIndex < nColCount; nColIndex++) {
					cell = spreadsheet.getSheet(0).getCellAt(nColIndex, nRowIndex);
					System.out.print(cell.getValue() + " ");
					if (cell.getValue().toString().isEmpty()) {
						nRowIndex++;
						System.out.println();
						nColIndex = -1;
						cell = spreadsheet.getSheet(0).getCellAt(0, nRowIndex);
						if (cell.getValue().toString().isEmpty()) {
							return null;
						}
					}
				}
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
