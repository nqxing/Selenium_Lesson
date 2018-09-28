package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class iq_test3 {
	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
		//新建学科信息，学科名，学科编号
		
		String subject [] = new String[]  
				{"学科3（0612）","学科4（0612）"};  // *输入要新建的学科名，需要新建几门学科就往数组里添加几门，学科名字不可重复
			String course [][] = new String[][]{  
			{"课程1","课程2","课程3"},  // *输入对应学科下的课程名，该行对应上面第一门学科，需要新建几门课程就往数组里添加几门，课程名字可重复
			{"课程4","课程5"},
		};
		String subjectID = "A810";  	// *输入学科编号前缀（每次运行脚本前记得修改此项）
		String courseID = "C810";  // *输入课程编号前缀（每次运行脚本前记得修改此项）
		String CvSetting = "3"; 	// *设置选课模式（时间优先为1  选课点选课为2  平行志愿为3） 
		String taskname = "新建任务3";  // *输入选课任务名，任务名不可重复        
		String maxSubjectNum = "1";  // 输入学生可选学科数量
		// *输入选课开始时间和结束时间（注意：选课点和平行志愿选课开始时间不能早于当前时间，输入开始时间时请加上脚本的预计运行时间）
		String beginTime = "2018-06-12 16:20:13";   String endTime = "2018-06-12 20:30:13";
		
		String prioritySub = "数学"; // 平行志愿设置优先级学科成绩
		// 新建课程界面，输入课程周学时，课程学分值
		String weektime = "3";          String credit = "5";
		// 新建课程界面，输入年级范围
		String classbegin = "一年级";     String classfinish = "高三";
		// 添加到年级课程池，选择年级，班级数量，班级上限人数
		String grade = "九年级";    String classnum = "2";  String studentmax = "30";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
		Thread.sleep(1000);
		// 输入账号密码，点击登录
	    driver.findElement(By.name("userName")).sendKeys("admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    // 等待3s，等页面加载完成
	    Thread.sleep(3000);
	    // 点击选课排课模快
		driver.findElement(By.linkText("选课排课")).click();
		// 获取当前页面句柄    
	    String handle = driver.getWindowHandle();    
	    // 获取所有页面的句柄，并循环判断是不是当前的句柄   
	    for (String handles : driver.getWindowHandles()) {    
	        if (handles.equals(handle))    
	            continue;    
	        driver.switchTo().window(handles);    
	    }    
	    // 打印当面页面标题 
	    System.out.println(driver.getTitle());
	    Thread.sleep(2000);

		// 点击选课管理
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(2000);
		
		// 点击平行志愿选课
		driver.findElement(By.xpath("//*/li[@data-id='50370']")).click();
		Thread.sleep(2000);
	 // 点击选课任务管理
	 		driver.findElement(By.xpath("//*/li[@data-id='50372']")).click();
	 		Thread.sleep(2000);
	 	    // 切至第一个frame内部
	 	    driver.switchTo().frame(1);
	 	    Thread.sleep(2000);
	 	    // 点击新增选课任务按钮
	 	    driver.findElement(By.xpath("//*/a[@title='新增选课任务']")).click();
	 		// 切回主界面
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// 输入选课任务名，最大可选学科数
	 		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(taskname);
	 		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(maxSubjectNum);
	 		Thread.sleep(2000);
	 		// 点击确定按钮
	 		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
	 		Thread.sleep(2000);
	 		System.out.println("平行志愿任务名【"+taskname+"】，新增成功！");
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(1000);
	 	    // 输入任务名
	 		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
	 		Thread.sleep(1000);
	 		// 点击查询按钮
	 		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
	 		Thread.sleep(2000);
	 		// 点击课程清单
	 		driver.findElement(By.xpath("//*/button[@title='课程清单']")).click();
	 		Thread.sleep(2000);
	 		// 进入课程清单界面，点击新建一轮选课按钮
	 		driver.findElement(By.id("createCourseBtn")).click();
	 		Thread.sleep(2000);
	 		// 点击添加课程按钮
	 		driver.findElement(By.id("addCourseBtn")).click();
	 	    Thread.sleep(2000);
	 	    
	 		for(int i = 0; i < subject.length; i++){
	 	    // 点击下拉框，选择年级
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + grade + "']")).click();
	 		Thread.sleep(2000);
	 		// 点击下拉框，选择学科
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + subject[i] + "']")).click(); 
	 		Thread.sleep(2000);
	 		// 点击查询按钮
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[4]/button")).click();	
	 		Thread.sleep(2000);   
	 		// 全选课程
	 	    driver.findElement(By.xpath("//*/div[@id='addCourseListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000);
	 	    // 点击添加课程按钮
	 		driver.findElement(By.xpath("//*/a[@title='添加课程']")).click();
	 		Thread.sleep(3000);
	 		if(i+1 != subject.length){
	 		// 点击添加课程按钮
	 		driver.findElement(By.id("addCourseBtn")).click();
	 	    Thread.sleep(2000);
	 		}}
	 		// 全选课程
	 	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000);
	 	    // 点击修改设置选课时间
	 		driver.findElement(By.xpath("//*/a[@title='批量修改']")).click();
	 		Thread.sleep(1000);
	 		// 切回主界面
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	         //选择建立时间--清除日期控件是readonly属性  
	         JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
	         //remove readonly attribute  
	         removeAttribute.executeScript("var setDate=document.getElementById(\"selectBeginTimeStr\");setDate.removeAttribute('readonly');");
	 		// 输入选课开始时间
	         driver.findElement(By.id("selectBeginTimeStr")).sendKeys(beginTime);
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/label[text()='选课开始时间:']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.id("selectBeginTimeStr")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='选择时间']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='确定']")).click();
	 		Thread.sleep(1000);	
	         JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
	         //remove readonly attribute  
	         removeAttribute1.executeScript("var setDate=document.getElementById(\"selectEndTimeStr\");setDate.removeAttribute('readonly');");
	 		// 输入选课结束时间
	         driver.findElement(By.id("selectEndTimeStr")).sendKeys(endTime);
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/label[text()='选课开始时间:']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.id("selectEndTimeStr")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='选择时间']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='确定']")).click();
	 		Thread.sleep(2000);
	 		// 点击确定按钮
	 		driver.findElement(By.xpath("//*/button[text()='确定']")).click();    
	 		Thread.sleep(2000);
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(1000);
	 	    // 全选课程
	 	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000);
	 	    // 点击发布按钮
	 		driver.findElement(By.xpath("//*/a[@title='发布']")).click();
	 	    Thread.sleep(2000);
	 		System.out.println("平行志愿选课任务发布成功！");
	 		System.out.println("选课时间为："+beginTime+"-"+endTime);
	    }
	    

}
