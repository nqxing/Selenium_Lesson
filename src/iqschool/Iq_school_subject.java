package iqschool;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author 聂钦兴
 * @date 2018-06-13
 * 智慧校园-选课排课-自动化新增学科课程，新建任务发布选课
 * 
 * 1、登录数字化校园平台，打开选课排课
 * 2、新增学科，新增课程
 * 3、设置选课模式
 * 4、新建选课任务，将全部学科课程添加至任务中
 * 5、设置选课时间
 * 6、发布选课
 * 
 * 注意：运行脚本前请确保如下信息已按注释要求填写完毕
 */

public class Iq_school_subject {
	static final WebDriver driver = new ChromeDriver();
	
	static int j;
	static String subject [] = new String[]  
			{"mq_平行（课程包1）","mq_平行（课程包2）"};  // *输入要新建的学科名，需要新建几门学科就往数组里添加几门，学科名字不可重复（每次运行脚本前必须修改）
	static String subjectID = "A200";  	// *输入学科编号前缀（每次运行脚本前必须修改）
	static String course [][] = new String[][]{  
		{"课程yi","课程er"},  // *输入对应学科下的课程名，该行对应上面第一门学科，需要新建几门课程就往数组里添加几门，课程名字可重复
		{"课程san","课程si"},
	};
	static String courseID = "C200";  // *输入课程编号前缀（每次运行脚本前必须修改）


	// 新建课程界面，输入课程周学时，课程学分值
	static String weektime = "3";          static String credit = "5";
	// 新建课程界面，输入年级范围
	static String classbegin = "一年级";     static String classfinish = "九年级";
	// 添加到年级课程池，选择年级，班级数量，班级上限人数
	static String grade = "一年级";    static String classnum = "2";  static String studentmax = "2";

	public static void main(String[] args) throws Exception{
		loginIq();
		for(j = 0; j < subject.length; j++){
		newDisciplineCourse();
		}
	}
	
	
		// 登录智慧校园，打开选课排课
	public static void loginIq() throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		// 设置浏览器最大化
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 打开测试地址
		driver.get("http://web.591iq.cn");
		// 输入账号密码，点击登录
	    driver.findElement(By.name("userName")).sendKeys("mq_admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2000);
//	    // 点击选课排课模快
//	    driver.get("http://web-dev.591iq.cn/apps/course/index.html");
//	    Thread.sleep(2000);
	    // 打印当面页面标题 
	    System.out.println("登录成功！");
		
	}
	
		// 新增学科，新增课程，将课程添加至年级课程池，并设置选课模式
	public static void newDisciplineCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 获取学科设置css属性
		List<WebElement> menus4 = driver.findElements(By.cssSelector("li.child-module"));
        Thread.sleep(1000);
        // 点击学科设置
        WebElement desiredMenu4 = menus4.get(0);
        desiredMenu4.click();  
		Thread.sleep(2000);
	    // 切至第一个frame内部
		driver.switchTo().frame(1);
		// 点击添加学科按钮
		driver.findElement(By.xpath("//*/a[@buttontype='add']")).click();
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
		// 输入学科信息并提交
		driver.findElement(By.xpath("//*/input[@placeholder='请输入学科名']")).sendKeys(subject[j]);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入编号']")).sendKeys(subjectID + j);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("学科【"+subject[j]+"】"+"，新增成功！");
		// 点击学科课程设置
		driver.findElement(By.xpath("//*/li[@data-id='50267']")).click();
		Thread.sleep(1000);
		// 刷新页面，防止新增学科未显示出来
		driver.navigate().refresh();
		Thread.sleep(2000);
		// 再次点击学科课程设置
		driver.findElement(By.xpath("//*/li[@data-id='50267']")).click();
		Thread.sleep(2000);
	    // 切至第一个frame内部
		driver.switchTo().frame(1);
		// 选中新增的学科
		driver.findElement(By.xpath("//*/div[@title='" + subject[j] + "']")).click();
		Thread.sleep(2000);
		for (int i = 0; i < course[j].length ;i++){
		// 点击新增课程按钮
		driver.findElement(By.xpath("//*/a[@title='添加']")).click();	
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// 输入课程相关信息并提交
		driver.findElement(By.xpath("//*/input[@placeholder='请输入课程名称']")).sendKeys(subject[j]+"-"+course[j][i]);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入课程编号']")).sendKeys(courseID + j + i);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入周学时']")).sendKeys(weektime);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入学分分值']")).sendKeys(credit);	
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[1]/div/div/div/input[@placeholder='请选择']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ classbegin +"']")).click();
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/div/input[@placeholder='请选择']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/dl/dd[text()='"+ classfinish +"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("学科【"+subject[j]+"】，"+"课程【"+course[j][i]+"】，新增成功！");
	    Thread.sleep(1000);
	    // 切至第一个frame内部
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		}
		// 全选课程
		Thread.sleep(2000);
	    driver.findElement(By.id("checkAllSpan")).click();
	    Thread.sleep(1000);
	    // 点击添加到年级课程池
		driver.findElement(By.xpath("//*/div[@class='tool-list']/a[3]")).click();
		Thread.sleep(2000);
		// 切回主界面
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// 输入年级课程池信息  班级数量 上限人数
//		driver.findElement(By.xpath("//*/input[@value='公共课']")).click();
		driver.findElement(By.xpath("//*/form[@id='gradeCourseInfo']/div[1]/div[2]/div/div/div/input")).click();
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入班级数量']")).sendKeys(classnum);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入学生上限']")).sendKeys(studentmax);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("学科【"+subject[j]+"】下课程已添加至【"+grade+"】课程池！");
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	

}
