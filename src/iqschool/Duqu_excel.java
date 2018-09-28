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
	// ָ��excel��·��			
	File src = new File(".\\Files\\test.xlsx");
	
	// �����ļ�
	FileInputStream fis = new FileInputStream(src);
	
	// ����workbook
	@SuppressWarnings("resource")
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	//����sheet����������ֻ��һ��sheet,Ĭ����sheet1
	XSSFSheet sh1= wb.getSheetAt(0);
	DecimalFormat df = new DecimalFormat("0");
//	System.out.println(df.format(sh1.getRow(0).getCell(0).getStringCellValue()));
//	System.out.println(df.format(sh1.getRow(0).getCell(1).getStringCellValue()));
	System.out.println("------------------------------");
	String userName = df.format(sh1.getRow(i).getCell(0).getNumericCellValue());
	String userPwd = df.format(sh1.getRow(i).getCell(1).getNumericCellValue());
	

	System.out.println(userName);
	System.out.println(userPwd);
	//д��excel����
	sh1.getRow(0).createCell(2).setCellValue("Pass");
	sh1.getRow(1).createCell(2).setCellValue("Fail");
	sh1.getRow(2).createCell(2).setCellValue("N/A");

	// �����ļ�
	FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx"));
	 
	//����д������ 
	wb.write(fout);
	
	// �ر��ļ�
	fout.close();
	}
}
