package iqschool;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot; 
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;

/**
 * @author ������
 * @date 2018-06-29
 * �ǻ�У԰-ѡ���ſ�-�Զ���ѧ��ѡ��
 * 
 * 1����¼���ֻ�У԰ƽ̨����ѡ���ſ�
 * 2���ж�ѡ��ģʽ�����ö�Ӧѡ�η���
 * 3��ѡ�ж�Ӧ�γ�
 * 4�����ѡ��
 * 
 * ѧ���˺š����뵼���ļ� Files\\test.xlsx
 * ע�⣺���нű�ǰ��ȷ��������Ϣ�Ѱ�ע��Ҫ����д���
 */

public class Iq_school_course_xk_bak {
	static WebDriver driver = new ChromeDriver();
	static String name = "";  static String userName = "";  static String userPwd = ""; static int i; 
	//   ---------------------  ������Ϣ����     ----------------------
	// *�μӱ���ѡ�ε�ѧ������
	static int stunum = 2;
	// *����ѡ�ε�ѡ��ģʽ��ʱ������Ϊ1  ѡ�ε�ѡ��Ϊ2  ƽ��־ԸΪ3��
	static int CvSetting = 1; 	
	// *��ѡ��Ҫѡ�Ŀγ̣��꼶+�γ���+�༶��
	static String course [] = new String[]  
			{"���꼶���пγ�(2)��",};
	// *����ѡ�ε�ѡ���������Ӧ�γ̵�ѡ�ε㣨����ʱ�����Ⱥ�ƽ��־Ըѡ��������ԣ�
	static String num [] = new String[]  
			{"99","69","100",};
	
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver_v67.exe");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ������������
		driver.manage().window().maximize();
		// �򿪲��Ե�ַ
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
		// ִ�е�¼
		for(i = 0;i<stunum;i++){	
		loginIq();
		// �ж϶�Ӧѡ�η�ʽ
		if (CvSetting == 1){
			timeCourse();
			}else if(CvSetting == 2){
			pointCourse();
			}else if(CvSetting == 3){
			parallelCourse();
			}
		System.out.println("-----------------------");
		// ����������
		driver.get("http://web-dev.591iq.cn/apps/hall/index_default.html");
		Thread.sleep(2000);
		// �ҵ���������id���������������������
        WebElement id = driver.findElement(By.id("userName"));
        Actions action = new Actions(driver);
        action.moveToElement(id).perform();
        // ��ֹԪ��δ�ҵ����˳�ʧ��
        try{
        	// �ҵ�Ԫ�أ�����˳���¼
		driver.findElement(By.id("logout")).click();
		Thread.sleep(3000);
		}catch (Exception e) {
			// δ�ҵ�Ԫ�أ�ˢ��ҳ�棬�����˳���¼
			driver.navigate().refresh();
			Thread.sleep(2000);
			// �ҵ���������id���������������������
	        WebElement id1 = driver.findElement(By.id("userName"));
	        Actions action1 = new Actions(driver);
			action1.moveToElement(id1).perform();
			driver.findElement(By.id("logout")).click();
			Thread.sleep(3000);
		}
		}
		System.out.println("����ѡ������ִ�����~~");
	}
	// ��¼�鷽��
	public static void loginIq() throws Exception{
		// ָ��excel��·��			
		File src = new File(".\\Files\\test.xlsx");
		// �����ļ�
		FileInputStream fis = new FileInputStream(src);
		// ����workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		DecimalFormat df = new DecimalFormat("0");
		// ��ȡ�˺�����
		userName = df.format(sh1.getRow(i).getCell(0).getNumericCellValue());
		userPwd = df.format(sh1.getRow(i).getCell(1).getNumericCellValue());
		// �����˺����룬�����¼
	    driver.findElement(By.name("userName")).sendKeys(userName);
	    driver.findElement(By.name("userPwd")).sendKeys(userPwd);
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2500);
	    // ����js��������js���
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		// ��ȡѧ������
		name =(String) js.executeScript("return document.getElementById(\"userName\").innerHTML;");
		System.out.println("ѧ����"+name+"������¼�ɹ���");
	    // ��ѡ���ſ�
	    driver.get("http://web-dev.591iq.cn/apps/course/index.html");
	    Thread.sleep(1000);	
	}
	// ʱ������ѡ��
	public static void timeCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ʱ������ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50302']")).click();
		Thread.sleep(2000);
		// ���ѧ��ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50311']")).click();
		Thread.sleep(3000);
		// ��ȡδѡ��ǰ�γ���Ϣ
		File jt= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		// ����js��������js���
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		// ��ȡ����ѡ�ογ�����
		long x =(long) js.executeScript("return document.querySelectorAll(\".table>tbody>tr\").length;") ;	    
		for(int j = 0;j<course.length;j++){
		// ��ȡȫ���γ���
			for(int i =0; i < x; i++){ 
		    js.executeScript("window.str=document.querySelectorAll(\".table>tbody>tr\"); window.str1 = str["+i+"].getElementsByTagName(\"td\")[2].innerHTML;") ;
			String setName =(String) js.executeScript("return window.str1;") ;	
			// �жϿγ����Ƿ���ȣ����Ǿ͹�ѡ�ÿγ�
			if (setName.equals(course[j])){  
				js.executeScript("var str2 = str["+i+"].getElementsByTagName(\"td\")[7]; window.str3 = str2.getElementsByTagName(\"label\")[0];") ;
				WebElement  setName1 = (WebElement) js.executeScript("return window.str3;") ;
				setName1.click();
				Thread.sleep(1000);	
				// ��ȡ��ѡ��Ԫ��
				WebElement  message = driver.findElement(By.xpath("//*/input[@data-classname='"+course[j]+"']"));
				// �жϹ�ѡ���Ƿ�ѡ��
				Boolean flag = message.isSelected();
				if(flag){
					// ��ѡ�ɹ�����ӡ���
					System.out.println(""+course[j]+"����ѡ�ɹ���");
				}else{
					// ��ѡʧ�ܣ���ȡ��ʾ��ϢԪ�أ�����ӡ���ԭ��
					String dialog = driver.findElement(By.xpath("//*/div[@type='dialog']")).getText();
					System.out.println(""+course[j]+"����ѡʧ�ܣ�" + dialog);
				}
			}
		    }
		}
		
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// �ڵ�����ȷ�Ͽ��е��ȷ����ť
		driver.findElement(By.xpath("//*/a[text()='ȷ��']")).click();
		Thread.sleep(2000);
		// ��ȡȷ��ѡ�κ�����Ϣ
		File jt1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// ѡ�γɹ���������ͼ���棬ֻ��ѡ�ν��д��excel�ļ�
		try{
			// ��ȡѡ�γɹ���ʾ��Ϊѡ�γɹ��ж�����
		String message = driver.findElement(By.xpath("//*/div[text()='ѡ�γɹ�']")).getText();
		if(message.equals("ѡ�γɹ�")){
		System.out.println(""+name+"��ѡ�γɹ���");
		// ָ��excel��·��			
		File src1 = new File(".\\Files\\test.xlsx");
		// �����ļ�
		FileInputStream fis = new FileInputStream(src1);
		// ����workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);	
		// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		// д��excel����
		sh1.getRow(i).createCell(2).setCellValue(""+name+"");
		sh1.getRow(i).createCell(3).setCellValue("ʱ������");
		sh1.getRow(i).createCell(4).setCellValue("ѡ�γɹ�");
		// �����ļ�
		FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
		//����д������ 
		wb.write(fout);	
		// �ر��ļ�
		fout.close();
		}
		// ѡ��ʧ�ܣ���ͼ����ʧ��ԭ�򣬲���ѡ�ν��д��excel�ļ�
		}catch(Exception e){
			System.out.println(""+name+"��ѡ��ʧ�ܣ������ļ���Screenshots�鿴ʧ�ܽ�ͼ��");
			// ����һ��data format����
			DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");			
			// ����Date()��ȡ��ǰʱ��
			Date date = new Date();		
			// ��ʽ��ʱ��,����String����洢
			String date1 = dateformat.format(date);	
			// �����ͼ
			FileUtils.copyFile(jt, new File(".\\Screenshots\\[1]"+name+"_ѡ��ʧ�ܽ�ͼ(δѡǰ)_"+date1+".png"));
			FileUtils.copyFile(jt1, new File(".\\Screenshots\\[1]"+name+"_ѡ��ʧ�ܽ�ͼ(��ѡ��)_"+date1+".png")); 
			// ָ��excel��·��			
			File src1 = new File(".\\Files\\test.xlsx");
			// �����ļ�
			FileInputStream fis = new FileInputStream(src1);
			// ����workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);	
			// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// д��excel����
			sh1.getRow(i).createCell(2).setCellValue(""+name+"");
			sh1.getRow(i).createCell(3).setCellValue("ʱ������");
			sh1.getRow(i).createCell(4).setCellValue("ѡ��ʧ�ܣ������ļ���Screenshots�鿴ʧ�ܽ�ͼ");
			// �����ļ�
			FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
			// ����д������ 
			wb.write(fout);	
			// �ر��ļ�
			fout.close();
			// System.out.println(e.getMessage()); 
			}
		
	}
	// ѡ�ε�ѡ��	
	public static void pointCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ѡ�ε�ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50278']")).click();
		Thread.sleep(2000);
		// ���ѧ��ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50329']")).click();
		Thread.sleep(3000);
		// ��ȡδѡ��ǰ�γ���Ϣ
		File jt= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		// ����js��������js���
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		// ��ȡ����ѡ�ογ�����
		long x =(long) js.executeScript("return document.querySelectorAll(\".default-tbody>tr\").length;") ;	
		for(int j =0; j<course.length; j++){
			// ��ȡȫ���γ���
			for(int i =0; i < x; i++){ 
				js.executeScript("window.str=document.querySelectorAll(\".default-tbody>tr\"); window.str1 = str["+i+"].getElementsByTagName(\"td\")[3].innerHTML;") ;
				String setName =(String) js.executeScript("return window.str1;") ;
				// �жϿγ����Ƿ���ȣ����Ǿ��ڸÿγ������Ӧѡ�ε�
					if (setName.equals(course[j])){  
					js.executeScript("var str2 = str["+i+"].getElementsByTagName(\"td\")[9]; window.str3 = str2.getElementsByTagName(\"input\")[0];") ;
					WebElement  setName1 = (WebElement) js.executeScript("return window.str3;") ;
					setName1.clear();
					setName1.sendKeys(num[j]);
					System.out.println("����"+course[j]+"Ͷ����"+num[j]+"ѡ�ε㣡");
				}		
			}
		}
		// ����ύ��ť
		driver.findElement(By.xpath("//*/button[text()='�ύ']")).click();
		// �л�������
		driver.switchTo().defaultContent();
		// ��ȡ�ύ��Ŀγ���Ϣ
		File jt1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// ѡ�γɹ���������ͼ���棬ֻ��ѡ�ν��д��excel�ļ�
		try{
		Thread.sleep(5000);
		// ��ȡѡ�γɹ���ʾ��Ϊѡ�γɹ��ж�����
		String message = driver.findElement(By.xpath("//*[@id='selectCourseDialog']/div/p")).getText();
		if(message.equals("ѡ�ν�����ύ")){
		System.out.println(""+name+"��ѡ�ν���ύ�ɹ���");
		// ָ��excel��·��			
		File src1 = new File(".\\Files\\test.xlsx");
		// �����ļ�
		FileInputStream fis = new FileInputStream(src1);
		// ����workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);	
		// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		// д��excel����
		sh1.getRow(i).createCell(2).setCellValue(""+name+"");
		sh1.getRow(i).createCell(3).setCellValue("ѡ�ε�");
		sh1.getRow(i).createCell(4).setCellValue("�ύ�ɹ�");
		// �����ļ�
		FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
		//����д������ 
		wb.write(fout);	
		// �ر��ļ�
		fout.close();
		}
		// ѡ��ʧ�ܣ���ͼ����ʧ��ԭ�򣬲���ѡ�ν��д��excel�ļ�
		}catch(Exception e){
			System.out.println(""+name+"���ύʧ�ܣ������ļ���Screenshots�鿴ʧ�ܽ�ͼ��");
			// ����һ��data format����
			DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");			
			// ����Date()��ȡ��ǰʱ��
			Date date = new Date();			
			// ��ʽ��ʱ��,����String����洢
			String date1 = dateformat.format(date);
			// �����ͼ
			FileUtils.copyFile(jt, new File(".\\Screenshots\\[2]"+name+"_�ύʧ�ܽ�ͼ(δѡǰ)_"+date1+".png"));
			FileUtils.copyFile(jt1, new File(".\\Screenshots\\[2]"+name+"_�ύʧ�ܽ�ͼ(��ѡ��)_"+date1+".png")); 
			// ָ��excel��·��			
			File src1 = new File(".\\Files\\test.xlsx");
			// �����ļ�
			FileInputStream fis = new FileInputStream(src1);
			// ����workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);	
			// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// д��excel����
			sh1.getRow(i).createCell(2).setCellValue(""+name+"");
			sh1.getRow(i).createCell(3).setCellValue("ѡ�ε�");
			sh1.getRow(i).createCell(4).setCellValue("�ύʧ�ܣ������ļ���Screenshots�鿴ʧ�ܽ�ͼ");
			// �����ļ�
			FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
			// ����д������ 
			wb.write(fout);	
			// �ر��ļ�
			fout.close();
			// System.out.println(e.getMessage()); 
			}
	}
	// ƽ��־Ըѡ��
	public static void parallelCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ƽ��־Ըѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50370']")).click();
		Thread.sleep(2000);
		// ���ѧ��ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50407']")).click();
		Thread.sleep(3000);
		// ��ȡδѡ��ǰ�γ���Ϣ
		File jt= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		// ����js��������js���
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		// ��ȡ����ѡ�ογ�����
		long x =(long) js.executeScript("return document.querySelectorAll(\".default-tbody>tr\").length;") ;	    
		int sum = 0;  int k; int tr;
		for(int j = 0;j<course.length;j++){
		// ��ȡȫ���γ���
			for(int i =0; i < x; i++){ 
		    js.executeScript("window.str=document.querySelectorAll(\".default-tbody>tr\"); window.str1 = str["+i+"].getElementsByTagName(\"td\")[3].innerHTML;") ;
			String setName =(String) js.executeScript("return window.str1;") ;	
			// �жϿγ����Ƿ���ȣ����Ǿ͵���ÿγ�
			if (setName.equals(course[j])){  
				js.executeScript("var str2 = str["+i+"].getElementsByTagName(\"td\")[8]; window.str3 = str2.getElementsByTagName(\"button\")[0];") ;
				WebElement  setName1 = (WebElement) js.executeScript("return window.str3;") ;
				setName1.click();
				Thread.sleep(2000);
				tr = i + 1;
				String str = driver.findElement(By.xpath("//*/*[@id='table']/div/div[2]/table/tbody/tr["+tr+"]/td[9]/button")).getText();
				k = j + 1;
				// �ж�־Ը�Ƿ�����Ϊһ��
				if(str.equals("��"+k+"־Ը")){
				System.out.println(""+course[j]+"��������Ϊ��"+k+"־Ը��");
				sum+=1;
				}else{
					System.out.println(""+course[j]+"��δ����������־Ը��");
				}
			}
		    }
		}
		Thread.sleep(1000);
		// ��ȡѡ�κ�γ���Ϣ
		File jt1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// �ж�ÿ��־Ը�Ƿ�����һ�£����Ǿ�Ϊѡ�γɹ����������ͼ����ѡ�ν��д��excel�ļ�
		if(sum==course.length){
		System.out.println(""+name+"��ѡ�γɹ���");
		// ָ��excel��·��			
		File src1 = new File(".\\Files\\test.xlsx");
		// �����ļ�
		FileInputStream fis = new FileInputStream(src1);
		// ����workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);	
		// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		// д��excel����
		sh1.getRow(i).createCell(2).setCellValue(""+name+"");
		sh1.getRow(i).createCell(3).setCellValue("ƽ��־Ը");
		sh1.getRow(i).createCell(4).setCellValue("ѡ�γɹ�");
		// �����ļ�
		FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
		// ����д������ 
		wb.write(fout);	
		// �ر��ļ�
		fout.close();
		// ־Ը���ò�һ�£���Ϊδ����ѡ�Σ������ͼ������ѡ�ν��д��excel�ļ�
		}else{
			System.out.println(""+name+"��δ������ѡ�Σ������ļ���Screenshots�鿴ʧ�ܽ�ͼ��");
			// ����һ��data format����
			DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");			
			// ����Date()��ȡ��ǰʱ��
			Date date = new Date();		
			// ��ʽ��ʱ��,����String����洢
			String date1 = dateformat.format(date);	
			FileUtils.copyFile(jt, new File(".\\Screenshots\\[3]"+name+"_ѡ��ʧ�ܽ�ͼ(δѡǰ)_"+date1+".png")); 
			FileUtils.copyFile(jt1, new File(".\\Screenshots\\[3]"+name+"_ѡ��ʧ�ܽ�ͼ(��ѡ��)_"+date1+".png")); 
			// ָ��excel��·��			
			File src1 = new File(".\\Files\\test.xlsx");
			// �����ļ�
			FileInputStream fis = new FileInputStream(src1);
			// ����workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);	
			// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// д��excel����
			sh1.getRow(i).createCell(2).setCellValue(""+name+"");
			sh1.getRow(i).createCell(3).setCellValue("ƽ��־Ը");
			sh1.getRow(i).createCell(4).setCellValue("δ������ѡ�Σ������ļ���Screenshots�鿴ѡ�ν�ͼ");
			// �����ļ�
			FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
			// ����д������ 
			wb.write(fout);	
			// �ر��ļ�
			fout.close();
			// System.out.println(e.getMessage()); 
			}
		}
}
