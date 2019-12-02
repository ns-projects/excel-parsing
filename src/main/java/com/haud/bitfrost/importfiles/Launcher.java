package com.haud.bitfrost.importfiles;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.haud.bitfrost.importfiles.cost.Hssf;
import com.haud.bitfrost.importfiles.cost.ODSReader;
import com.haud.bitfrost.importfiles.cost.Xssf;

public class Launcher {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Xssf importcost = new Xssf();
		importcost.readFromExcel("price_example_xlsx.xlsx");

		System.out.println("");

		Hssf hssf = new Hssf();
		hssf.excel97xlsread("price_example_excel97.xls");

		System.out.println("");

		ODSReader ODSReader = new ODSReader();
		ODSReader.readODS("price_example_opendocument.ods");
	}

}
