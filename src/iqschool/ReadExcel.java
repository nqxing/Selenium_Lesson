package iqschool;
 
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ReadExcel {
 
	public static void main(String[] args) {
		
		try{
			
			// 指定excel的路径
			File src = new File(".\\Files\\test.xlsx");
			
			// 加载文件
			FileInputStream fis = new FileInputStream(src);
			
			// 加载workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			//加载sheet，这里我们只有一个sheet,默认是sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// wb.setCellType(wb.CELL_TYPE_STRING);
			
			// 开始读取第一行第一列的数据

			DecimalFormat df = new DecimalFormat("0");
			String cellValue = df.format(sh1.getRow(0).getCell(0).getNumericCellValue());
			
			System.out.println(cellValue);
//			String str = sh1.getRow(0).getCell(0).getNumericCellValue();
//			System.out.println(str);
			
			// 读取第一行第二列内容
//			System.out.println(sh1.getRow(0).getCell(1).getNumericCellValue());
			// 读取第二行第二列内容
//			System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
//			// 读取第二行第二列内容
//			System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
			
			// 获取实际总行数
			System.out.println(sh1.getPhysicalNumberOfRows());
			
			// 获取实际总列数
			System.out.println(sh1.getPhysicalNumberOfRows());
			
		} catch (Exception e){
			
			System.out.println(e.getMessage());
			
		}
 
	}
 
}
