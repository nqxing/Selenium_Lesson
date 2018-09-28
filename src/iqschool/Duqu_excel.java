package iqschool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Duqu_excel {
//	static String userName = "";  static String userPwd = "";
	static int i = 0; 
	public static void main(String[] args) throws Exception{
	// 指定excel的路径			
	File src = new File(".\\Files\\test.xlsx");
	
	// 加载文件
	FileInputStream fis = new FileInputStream(src);
	
	// 加载workbook
	@SuppressWarnings("resource")
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	//加载sheet，这里我们只有一个sheet,默认是sheet1
	XSSFSheet sh1= wb.getSheetAt(0);
	DecimalFormat df = new DecimalFormat("0");
//	System.out.println(df.format(sh1.getRow(0).getCell(0).getStringCellValue()));
//	System.out.println(df.format(sh1.getRow(0).getCell(1).getStringCellValue()));
	System.out.println("------------------------------");
	String userName = df.format(sh1.getRow(i).getCell(0).getNumericCellValue());
	String userPwd = df.format(sh1.getRow(i).getCell(1).getNumericCellValue());
	

	System.out.println(userName);
	System.out.println(userPwd);
	//写入excel数据
	sh1.getRow(0).createCell(2).setCellValue("Pass");
	sh1.getRow(1).createCell(2).setCellValue("Fail");
	sh1.getRow(2).createCell(2).setCellValue("N/A");

	// 保存文件
	FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx"));
	 
	//覆盖写入内容 
	wb.write(fout);
	
	// 关闭文件
	fout.close();
	}
}
