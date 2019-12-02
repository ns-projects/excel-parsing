package com.haud.bitfrost.importfiles.cost;

import java.io.File;
import java.io.IOException;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class ODSReader {

	public void readODS(File file) {

		SpreadSheet spreadsheet;
		try {
			spreadsheet = SpreadSheet.createFromFile(file);
			int nColCount = 14; // spreadsheet.getSheet(0).getColumnCount();
			int nRowCount = 10; // spreadsheet.getSheet(0).getRowCount();
		
			MutableCell cell = null;
			for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) 
			{
				for (int nColIndex = 0; nColIndex < nColCount; nColIndex++) 
				{
					cell = spreadsheet.getSheet(0).getCellAt(nColIndex, nRowIndex);
					System.out.print(cell.getValue() + " ");
					
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}