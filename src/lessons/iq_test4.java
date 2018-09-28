package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iq_test4 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
		//新建学科信息，学科名，学科编号
		
		String subject [] = new String[]{"体育与健康","新建学科（2）"}; 
		
		String taskname = "新建任务1"; String maxSubjectNum = "1";
		
		String beginTime = "2018-06-08 16:32:13";
		String endTime = "2018-06-08 17:30:13";
		
		//新建课程信息，课程名，课程编号，课程周学时，课程学分值
		String course = "高中课程";  String courseID = "B0004";
		String weektime = "3";     String credit = "5";
		String classbegin = "一年级";     String classfinish = "高三";
		// 添加到年级课程池，
		String grade = "高一"; String classnum = "3";  String studentmax = "30";
		// 设置选课模式（时间优先  选课点选课  平行志愿）
		String CvSetting = "2";
		
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
	 		// 点击时间优先选课
	 		driver.findElement(By.xpath("//*/li[@data-id='50302']")).click();
	 		Thread.sleep(2000);
	 		// 点击选课任务管理
	 		driver.findElement(By.xpath("//*/li[@data-name='选课任务管理']")).click();
	 		Thread.sleep(3000);
	 		
	 	    // 切至第一个frame内部
	 	    driver.switchTo().frame(1);
	 	    Thread.sleep(2000);
	 	    // 点击新增选课任务按钮
	 	    driver.findElement(By.xpath("//*/a[@title='新增选课任务']")).click();
	 		// 切回主界面
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// 输入选课任务名，可选学科数量后点击确定
	 		driver.findElement(By.xpath("//*/input[@id='name']")).sendKeys(taskname);
	 		driver.findElement(By.xpath("//*/input[@id='maxSubjectNum']")).sendKeys(maxSubjectNum);
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
	 		Thread.sleep(2000);
	 		// 切至第一个frame内部
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(1000);
	 	    // 输入新建的任务名称
	 		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
	 		Thread.sleep(1000);
	 		// 点击查询按钮
	 		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
	 		Thread.sleep(2000);
	 		// 查找成功，点击课程清单按钮
	 		driver.findElement(By.xpath("//*/button[@title='课程清单']")).click();
	 		Thread.sleep(2000);
	 		
	 		for(int i = 0; i < subject.length; i++){
	 		// 进入课程清单界面，点击添加课程按钮，进入添加课程界面
	 		driver.findElement(By.xpath("//*/a[@title='添加课程']")).click();
	 		Thread.sleep(1000);
	 		// 切回主界面
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 	    // 再切至layui-layer-iframe3内部
	 		// driver.switchTo().frame("layui-layer-iframe3");
	 		WebElement iframe = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
	 		driver.switchTo().frame(iframe);
	 		// WebElement iframe = driver.findElement(By.id("layui-layer-iframe3"));
	 		
	 	    Thread.sleep(1000);
	 	    // 点击下拉框，选择年级
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/dl/dd[text()='" + grade + "']")).click();
	 		Thread.sleep(2000);
	 		// 点击下拉框，选择学科
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/dl/dd[text()='" + subject[i] + "']")).click();  
	 		Thread.sleep(2000);
	 		// 点击查询
	 		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
	 		Thread.sleep(2000);
	 		// 查出课程后全选
	 	    driver.findElement(By.id("checkAllSpan")).click();
	 	    Thread.sleep(2000);
	 	    // 点击添加课程
	 		driver.findElement(By.xpath("//*/a[@title='添加课程']")).click();
	 		Thread.sleep(1000);
	 		// 切回主界面
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// 在跳出的确认弹框界面点击确定按钮
	 		driver.findElement(By.xpath("//*/a[text()='确定']")).click();
	 		Thread.sleep(1000);
	 		// 切至第一个frame内部
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(2000);
	 		}
	 		
	 	    // 点击全选课程
	 	    driver.findElement(By.xpath("//*/div[@id='table']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000); 
	 	    // 点击发布课程
	 		driver.findElement(By.xpath("//*/a[@title='发布课程']")).click();
	 	    Thread.sleep(1000);
	 		// 切回主界面
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// 再切至layui-layer-iframe6内部
	 		// driver.switchTo().frame("layui-layer-iframe6");
	 		WebElement iframe1 = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
	 		driver.switchTo().frame(iframe1);
	 	    Thread.sleep(1000);
	         // 选择建立时间--清除日期控件是readonly属性  
	         JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
	         // remove readonly attribute  
	         removeAttribute.executeScript("var setDate=document.getElementById(\"beginTime\");setDate.removeAttribute('readonly');");
	 		// 找到选课开始日期id属性并输入选课时间
	         driver.findElement(By.id("beginTime")).sendKeys(beginTime);
	 		Thread.sleep(1000);
	 		// 点击选课开始日期区域收起时间控件
	 		driver.findElement(By.xpath("//*/label[text()='选课开始日期:']")).click();	
	 		// 选择建立时间--清除日期控件是readonly属性 
	         JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
	         // remove readonly attribute  
	         removeAttribute1.executeScript("var setDate=document.getElementById(\"endTime\");setDate.removeAttribute('readonly');");
	         // 找到选课结束日期id属性并输入选课时间
	         driver.findElement(By.id("endTime")).sendKeys(endTime);
	 		Thread.sleep(1000);
	 		// 点击选课开始日期区域收起时间控件
	 		driver.findElement(By.xpath("//*/label[text()='选课开始日期:']")).click();
	 		Thread.sleep(1000);
	 		// 点击确定按钮发布课程任务
	 		driver.findElement(By.xpath("//*/button[text()='取消']")).click();
	 		Thread.sleep(2000);
	    
	}

}
