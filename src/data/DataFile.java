package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("/Users/pardeeptank/Desktop/Testing/NikulTest.xlsx");
	
	public String wrongusername = d.getCellData("data1", 1, 3);
	
	public String wrongpass = d.getCellData("data1", 2, 2);
	
	

}
