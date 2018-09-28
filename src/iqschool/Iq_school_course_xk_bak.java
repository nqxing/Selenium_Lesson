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
 * @author 聂钦兴
 * @date 2018-06-29
 * 智慧校园-选课排课-自动化学生选课
 * 
 * 1、登录数字化校园平台，打开选课排课
 * 2、判断选课模式，调用对应选课方法
 * 3、选中对应课程
 * 4、完成选课
 * 
 * 学生账号、密码导入文件 Files\\test.xlsx
 * 注意：运行脚本前请确保如下信息已按注释要求填写完毕
 */

public class Iq_school_course_xk_bak {
	static WebDriver driver = new ChromeDriver();
	static String name = "";  static String userName = "";  static String userPwd = ""; static int i; 
	//   ---------------------  以下信息必填     ----------------------
	// *参加本次选课的学生人数
	static int stunum = 2;
	// *本次选课的选课模式（时间优先为1  选课点选课为2  平行志愿为3）
	static int CvSetting = 1; 	
	// *请选择要选的课程（年级+课程名+班级）
	static String course [] = new String[]  
			{"七年级高中课程(2)班",};
	// *如是选课点选课请输入对应课程的选课点（若是时间优先和平行志愿选课则请忽略）
	static String num [] = new String[]  
			{"99","69","100",};
	
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver_v67.exe");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 设置浏览器最大化
		driver.manage().window().maximize();
		// 打开测试地址
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
		// 执行登录
		for(i = 0;i<stunum;i++){	
		loginIq();
		// 判断对应选课方式
		if (CvSetting == 1){
			timeCourse();
			}else if(CvSetting == 2){
			pointCourse();
			}else if(CvSetting == 3){
			parallelCourse();
			}
		System.out.println("-----------------------");
		// 返回主界面
		driver.get("http://web-dev.591iq.cn/apps/hall/index_default.html");
		Thread.sleep(2000);
		// 找到姓名属性id，并将鼠标悬浮在姓名上
        WebElement id = driver.findElement(By.id("userName"));
        Actions action = new Actions(driver);
        action.moveToElement(id).perform();
        // 防止元素未找到，退出失败
        try{
        	// 找到元素，点击退出登录
		driver.findElement(By.id("logout")).click();
		Thread.sleep(3000);
		}catch (Exception e) {
			// 未找到元素，刷新页面，重新退出登录
			driver.navigate().refresh();
			Thread.sleep(2000);
			// 找到姓名属性id，并将鼠标悬浮在姓名上
	        WebElement id1 = driver.findElement(By.id("userName"));
	        Actions action1 = new Actions(driver);
			action1.moveToElement(id1).perform();
			driver.findElement(By.id("logout")).click();
			Thread.sleep(3000);
		}
		}
		System.out.println("本次选课任务执行完毕~~");
	}
	// 登录块方法
	public static void loginIq() throws Exception{
		// 指定excel的路径			
		File src = new File(".\\Files\\test.xlsx");
		// 加载文件
		FileInputStream fis = new FileInputStream(src);
		// 加载workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		// 加载sheet，这里我们只有一个sheet,默认是sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		DecimalFormat df = new DecimalFormat("0");
		// 获取账号密码
		userName = df.format(sh1.getRow(i).getCell(0).getNumericCellValue());
		userPwd = df.format(sh1.getRow(i).getCell(1).getNumericCellValue());
		// 输入账号密码，点击登录
	    driver.findElement(By.name("userName")).sendKeys(userName);
	    driver.findElement(By.name("userPwd")).sendKeys(userPwd);
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2500);
	    // 建立js对象输入js语句
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		// 获取学生姓名
		name =(String) js.executeScript("return document.getElementById(\"userName\").innerHTML;");
		System.out.println("学生【"+name+"】，登录成功！");
	    // 打开选课排课
	    driver.get("http://web-dev.591iq.cn/apps/course/index.html");
	    Thread.sleep(1000);	
	}
	// 时间优先选课
	public static void timeCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 点击时间优先选课
		driver.findElement(By.xpath("//*/li[@data-id='50302']")).click();
		Thread.sleep(2000);
		// 点击学生选课
		driver.findElement(By.xpath("//*/li[@data-id='50311']")).click();
		Thread.sleep(3000);
		// 截取未选课前课程信息
		File jt= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 切至第一个frame内部
		driver.switchTo().frame(1);
		// 建立js对象输入js语句
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		// 获取本次选课课程总数
		long x =(long) js.executeScript("return document.querySelectorAll(\".table>tbody>tr\").length;") ;	    
		for(int j = 0;j<course.length;j++){
		// 获取全部课程名
			for(int i =0; i < x; i++){ 
		    js.executeScript("window.str=document.querySelectorAll(\".table>tbody>tr\"); window.str1 = str["+i+"].getElementsByTagName(\"td\")[2].innerHTML;") ;
			String setName =(String) js.executeScript("return window.str1;") ;	
			// 判断课程名是否相等，如是就勾选该课程
			if (setName.equals(course[j])){  
				js.executeScript("var str2 = str["+i+"].getElementsByTagName(\"td\")[7]; window.str3 = str2.getElementsByTagName(\"label\")[0];") ;
				WebElement  setName1 = (WebElement) js.executeScript("return window.str3;") ;
				setName1.click();
				Thread.sleep(1000);	
				// 获取勾选框元素
				WebElement  message = driver.findElement(By.xpath("//*/input[@data-classname='"+course[j]+"']"));
				// 判断勾选框是否被选中
				Boolean flag = message.isSelected();
				if(flag){
					// 勾选成功，打印语句
					System.out.println(""+course[j]+"，勾选成功！");
				}else{
					// 勾选失败，获取提示信息元素，并打印输出原因
					String dialog = driver.findElement(By.xpath("//*/div[@type='dialog']")).getText();
					System.out.println(""+course[j]+"，勾选失败！" + dialog);
				}
			}
		    }
		}
		
		// 点击确定按钮
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
		// 切回主界面
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// 在弹出的确认框中点击确定按钮
		driver.findElement(By.xpath("//*/a[text()='确定']")).click();
		Thread.sleep(2000);
		// 截取确定选课后结果信息
		File jt1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 选课成功，不做截图保存，只将选课结果写入excel文件
		try{
			// 获取选课成功提示作为选课成功判断依据
		String message = driver.findElement(By.xpath("//*/div[text()='选课成功']")).getText();
		if(message.equals("选课成功")){
		System.out.println(""+name+"，选课成功！");
		// 指定excel的路径			
		File src1 = new File(".\\Files\\test.xlsx");
		// 加载文件
		FileInputStream fis = new FileInputStream(src1);
		// 加载workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);	
		// 加载sheet，这里我们只有一个sheet,默认是sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		// 写入excel数据
		sh1.getRow(i).createCell(2).setCellValue(""+name+"");
		sh1.getRow(i).createCell(3).setCellValue("时间优先");
		sh1.getRow(i).createCell(4).setCellValue("选课成功");
		// 保存文件
		FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
		//覆盖写入内容 
		wb.write(fout);	
		// 关闭文件
		fout.close();
		}
		// 选课失败，截图保存失败原因，并将选课结果写入excel文件
		}catch(Exception e){
			System.out.println(""+name+"，选课失败，请在文件夹Screenshots查看失败截图！");
			// 创建一个data format对象
			DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");			
			// 利用Date()获取当前时间
			Date date = new Date();		
			// 格式化时间,并用String对象存储
			String date1 = dateformat.format(date);	
			// 保存截图
			FileUtils.copyFile(jt, new File(".\\Screenshots\\[1]"+name+"_选课失败截图(未选前)_"+date1+".png"));
			FileUtils.copyFile(jt1, new File(".\\Screenshots\\[1]"+name+"_选课失败截图(已选后)_"+date1+".png")); 
			// 指定excel的路径			
			File src1 = new File(".\\Files\\test.xlsx");
			// 加载文件
			FileInputStream fis = new FileInputStream(src1);
			// 加载workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);	
			// 加载sheet，这里我们只有一个sheet,默认是sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// 写入excel数据
			sh1.getRow(i).createCell(2).setCellValue(""+name+"");
			sh1.getRow(i).createCell(3).setCellValue("时间优先");
			sh1.getRow(i).createCell(4).setCellValue("选课失败，请在文件夹Screenshots查看失败截图");
			// 保存文件
			FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
			// 覆盖写入内容 
			wb.write(fout);	
			// 关闭文件
			fout.close();
			// System.out.println(e.getMessage()); 
			}
		
	}
	// 选课点选课	
	public static void pointCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 点击选课点选课
		driver.findElement(By.xpath("//*/li[@data-id='50278']")).click();
		Thread.sleep(2000);
		// 点击学生选课
		driver.findElement(By.xpath("//*/li[@data-id='50329']")).click();
		Thread.sleep(3000);
		// 截取未选课前课程信息
		File jt= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 切至第一个frame内部
		driver.switchTo().frame(1);
		// 建立js对象输入js语句
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		// 获取本次选课课程总数
		long x =(long) js.executeScript("return document.querySelectorAll(\".default-tbody>tr\").length;") ;	
		for(int j =0; j<course.length; j++){
			// 获取全部课程名
			for(int i =0; i < x; i++){ 
				js.executeScript("window.str=document.querySelectorAll(\".default-tbody>tr\"); window.str1 = str["+i+"].getElementsByTagName(\"td\")[3].innerHTML;") ;
				String setName =(String) js.executeScript("return window.str1;") ;
				// 判断课程名是否相等，如是就在该课程输入对应选课点
					if (setName.equals(course[j])){  
					js.executeScript("var str2 = str["+i+"].getElementsByTagName(\"td\")[9]; window.str3 = str2.getElementsByTagName(\"input\")[0];") ;
					WebElement  setName1 = (WebElement) js.executeScript("return window.str3;") ;
					setName1.clear();
					setName1.sendKeys(num[j]);
					System.out.println("已在"+course[j]+"投入了"+num[j]+"选课点！");
				}		
			}
		}
		// 点击提交按钮
		driver.findElement(By.xpath("//*/button[text()='提交']")).click();
		// 切回主界面
		driver.switchTo().defaultContent();
		// 截取提交后的课程信息
		File jt1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 选课成功，不做截图保存，只将选课结果写入excel文件
		try{
		Thread.sleep(5000);
		// 获取选课成功提示作为选课成功判断依据
		String message = driver.findElement(By.xpath("//*[@id='selectCourseDialog']/div/p")).getText();
		if(message.equals("选课结果已提交")){
		System.out.println(""+name+"，选课结果提交成功！");
		// 指定excel的路径			
		File src1 = new File(".\\Files\\test.xlsx");
		// 加载文件
		FileInputStream fis = new FileInputStream(src1);
		// 加载workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);	
		// 加载sheet，这里我们只有一个sheet,默认是sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		// 写入excel数据
		sh1.getRow(i).createCell(2).setCellValue(""+name+"");
		sh1.getRow(i).createCell(3).setCellValue("选课点");
		sh1.getRow(i).createCell(4).setCellValue("提交成功");
		// 保存文件
		FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
		//覆盖写入内容 
		wb.write(fout);	
		// 关闭文件
		fout.close();
		}
		// 选课失败，截图保存失败原因，并将选课结果写入excel文件
		}catch(Exception e){
			System.out.println(""+name+"，提交失败，请在文件夹Screenshots查看失败截图！");
			// 创建一个data format对象
			DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");			
			// 利用Date()获取当前时间
			Date date = new Date();			
			// 格式化时间,并用String对象存储
			String date1 = dateformat.format(date);
			// 保存截图
			FileUtils.copyFile(jt, new File(".\\Screenshots\\[2]"+name+"_提交失败截图(未选前)_"+date1+".png"));
			FileUtils.copyFile(jt1, new File(".\\Screenshots\\[2]"+name+"_提交失败截图(已选后)_"+date1+".png")); 
			// 指定excel的路径			
			File src1 = new File(".\\Files\\test.xlsx");
			// 加载文件
			FileInputStream fis = new FileInputStream(src1);
			// 加载workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);	
			// 加载sheet，这里我们只有一个sheet,默认是sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// 写入excel数据
			sh1.getRow(i).createCell(2).setCellValue(""+name+"");
			sh1.getRow(i).createCell(3).setCellValue("选课点");
			sh1.getRow(i).createCell(4).setCellValue("提交失败，请在文件夹Screenshots查看失败截图");
			// 保存文件
			FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
			// 覆盖写入内容 
			wb.write(fout);	
			// 关闭文件
			fout.close();
			// System.out.println(e.getMessage()); 
			}
	}
	// 平行志愿选课
	public static void parallelCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 点击平行志愿选课
		driver.findElement(By.xpath("//*/li[@data-id='50370']")).click();
		Thread.sleep(2000);
		// 点击学生选课
		driver.findElement(By.xpath("//*/li[@data-id='50407']")).click();
		Thread.sleep(3000);
		// 截取未选课前课程信息
		File jt= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 切至第一个frame内部
		driver.switchTo().frame(1);
		// 建立js对象输入js语句
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		// 获取本次选课课程总数
		long x =(long) js.executeScript("return document.querySelectorAll(\".default-tbody>tr\").length;") ;	    
		int sum = 0;  int k; int tr;
		for(int j = 0;j<course.length;j++){
		// 获取全部课程名
			for(int i =0; i < x; i++){ 
		    js.executeScript("window.str=document.querySelectorAll(\".default-tbody>tr\"); window.str1 = str["+i+"].getElementsByTagName(\"td\")[3].innerHTML;") ;
			String setName =(String) js.executeScript("return window.str1;") ;	
			// 判断课程名是否相等，如是就点击该课程
			if (setName.equals(course[j])){  
				js.executeScript("var str2 = str["+i+"].getElementsByTagName(\"td\")[8]; window.str3 = str2.getElementsByTagName(\"button\")[0];") ;
				WebElement  setName1 = (WebElement) js.executeScript("return window.str3;") ;
				setName1.click();
				Thread.sleep(2000);
				tr = i + 1;
				String str = driver.findElement(By.xpath("//*/*[@id='table']/div/div[2]/table/tbody/tr["+tr+"]/td[9]/button")).getText();
				k = j + 1;
				// 判断志愿是否设置为一致
				if(str.equals("第"+k+"志愿")){
				System.out.println(""+course[j]+"，已设置为第"+k+"志愿！");
				sum+=1;
				}else{
					System.out.println(""+course[j]+"，未能正常设置志愿！");
				}
			}
		    }
		}
		Thread.sleep(1000);
		// 截取选课后课程信息
		File jt1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 判断每次志愿是否设置一致，如是就为选课成功，不保存截图，将选课结果写入excel文件
		if(sum==course.length){
		System.out.println(""+name+"，选课成功！");
		// 指定excel的路径			
		File src1 = new File(".\\Files\\test.xlsx");
		// 加载文件
		FileInputStream fis = new FileInputStream(src1);
		// 加载workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);	
		// 加载sheet，这里我们只有一个sheet,默认是sheet1
		XSSFSheet sh1= wb.getSheetAt(0);
		// 写入excel数据
		sh1.getRow(i).createCell(2).setCellValue(""+name+"");
		sh1.getRow(i).createCell(3).setCellValue("平行志愿");
		sh1.getRow(i).createCell(4).setCellValue("选课成功");
		// 保存文件
		FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
		// 覆盖写入内容 
		wb.write(fout);	
		// 关闭文件
		fout.close();
		// 志愿设置不一致，视为未正常选课，保存截图，并将选课结果写入excel文件
		}else{
			System.out.println(""+name+"，未能正常选课，请在文件夹Screenshots查看失败截图！");
			// 创建一个data format对象
			DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");			
			// 利用Date()获取当前时间
			Date date = new Date();		
			// 格式化时间,并用String对象存储
			String date1 = dateformat.format(date);	
			FileUtils.copyFile(jt, new File(".\\Screenshots\\[3]"+name+"_选课失败截图(未选前)_"+date1+".png")); 
			FileUtils.copyFile(jt1, new File(".\\Screenshots\\[3]"+name+"_选课失败截图(已选后)_"+date1+".png")); 
			// 指定excel的路径			
			File src1 = new File(".\\Files\\test.xlsx");
			// 加载文件
			FileInputStream fis = new FileInputStream(src1);
			// 加载workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb=new XSSFWorkbook(fis);	
			// 加载sheet，这里我们只有一个sheet,默认是sheet1
			XSSFSheet sh1= wb.getSheetAt(0);
			// 写入excel数据
			sh1.getRow(i).createCell(2).setCellValue(""+name+"");
			sh1.getRow(i).createCell(3).setCellValue("平行志愿");
			sh1.getRow(i).createCell(4).setCellValue("未能正常选课，请在文件夹Screenshots查看选课截图");
			// 保存文件
			FileOutputStream fout=new FileOutputStream(new File(".\\Files\\test.xlsx")); 
			// 覆盖写入内容 
			wb.write(fout);	
			// 关闭文件
			fout.close();
			// System.out.println(e.getMessage()); 
			}
		}
}
