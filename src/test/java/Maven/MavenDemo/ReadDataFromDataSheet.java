package Maven.MavenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadDataFromDataSheet {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Lets Start");
		ReadDataFromDataSheet RDFDS = new ReadDataFromDataSheet();
		File[] nameofFiles = RDFDS.getFiles();
		System.out.println(nameofFiles.length);
		for (int f= 0; f<nameofFiles.length; f++){
			if(nameofFiles[f].getName().contains("SampleData1.xls")){
				System.out.println(nameofFiles[f].getAbsolutePath());
				RDFDS.getDataArray(nameofFiles[f].getAbsolutePath(), "Sheet1");	
				break;
			}
			
		
		}
		System.out.println("Lets End");

	}
	@SuppressWarnings("null")
	public String[][] getDataArray(String WBPath, String SheetName) throws BiffException, IOException{
		  String[][] ArrayExcelData = null;
		
		System.out.println("In getDataArray");
		
		FileInputStream fs = new FileInputStream(WBPath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sheet = wb.getSheet("Sheet1");
		int colNum = sheet.getColumns();
		int rowsNum = sheet.getRows();
		 ArrayExcelData = new String[sheet.getColumns()][sheet.getRows()];
		System.out.println("Row Nos: "+rowsNum+"--- Column No: "+colNum);
		
		for (int r = 0;r < rowsNum;r++){
			
			for (int c=0; c < colNum; c++){
				//Row row = sheet.getRow(r);
				
				System.out.println(sheet.getCell(c, r).getContents());
				
				ArrayExcelData[r][c]=sheet.getCell(c, r).getContents();
				System.out.println("Data is Array: "+ArrayExcelData[r][c]);
			}
		}
		
		
		
		return ArrayExcelData;
		
	}
	public File[] getFiles(){
		File folder = new File("C://Selenium");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		return listOfFiles;
		
	}

}
