package iqschool;
 
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ReadExcel {
 
	public static void main(String[] args) {
		
		try{
			
			// ָ��excel��·��
			File src = new File(".\\Files\\test.xlsx");
			
			// �����ļ�
			FileInputStream fis = new FileInputStream(src);
			
			// ����workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			//����sheet����������ֻ��һ��sheet,Ĭ����sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// wb.setCellType(wb.CELL_TYPE_STRING);
			
			// ��ʼ��ȡ��һ�е�һ�е�����

			DecimalFormat df = new DecimalFormat("0");
			String cellValue = df.format(sh1.getRow(0).getCell(0).getNumericCellValue());
			
			System.out.println(cellValue);
//			String str = sh1.getRow(0).getCell(0).getNumericCellValue();
//			System.out.println(str);
			
			// ��ȡ��һ�еڶ�������
//			System.out.println(sh1.getRow(0).getCell(1).getNumericCellValue());
			// ��ȡ�ڶ��еڶ�������
//			System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
//			// ��ȡ�ڶ��еڶ�������
//			System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
			
			// ��ȡʵ��������
			System.out.println(sh1.getPhysicalNumberOfRows());
			
			// ��ȡʵ��������
			System.out.println(sh1.getPhysicalNumberOfRows());
			
		} catch (Exception e){
			
			System.out.println(e.getMessage());
			
		}
 
	}
 
}
