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

public class Iq_school_course_bak {
	
	static final WebDriver driver = new ChromeDriver();   static int j;
	static String url = "http://web-test.591iq.com.cn"; // 输入本次测试环境的地址
	static String CvSetting = "1"; 	// *设置选课模式（时间优先为1  选课点选课为2  平行志愿为3）
	static String subjectID = "A217";  	// *输入学科编号前缀（每次运行脚本前必须修改）
	static String courseID = "C217";  // *输入课程编号前缀（每次运行脚本前必须修改）
	static String subject [] = new String[]  
			{"并发测试（一）","并发测试（二）",};  // *输入要新建的学科名，需要新建几门学科就往数组里添加几门，学科名字不可重复（每次运行脚本前必须修改）
	static String course [][] = new String[][]{  
		{"课程yi",},  // *输入对应学科下的课程名，该行对应上面第一门学科，需要新建几门课程就往数组里添加几门，课程名字可重复
		{"课程er",},
	};
	// *输入选课开始时间和结束时间（注意：选课点和平行志愿选课开始时间不能早于当前时间，输入开始时间时请加上脚本的预计运行时间）
	static String beginTime = "2018-08-28 20:25:13";   static String endTime = "2018-08-29 20:00:13";
	static String taskname = "并发测试任务";  // *输入选课任务名，任务名不可重复（每次运行脚本前必须修改） 
	static String maxSubjectNum = "2";  // 输入学生可选学科数量
	static String prioritySub = "数学"; // 平行志愿设置优先级学科成绩,其他选课请忽略
	// 新建课程界面，输入课程周学时，课程学分值
	static String weektime = "3";          static String credit = "5";
	// 新建课程界面，输入年级范围
	static String classbegin = "高一";     static String classfinish = "高二";
	// 添加到年级课程池，选择年级，班级数量，班级上限人数
	static String grade = "高一";    static String classnum = "2";  static String studentmax = "300";

	public static void main(String[] args) throws Exception{
		loginIq();
		for(j = 0; j < subject.length; j++){
		newDisciplineCourse();
		if (j+1 == subject.length && CvSetting == "1"){
		timeCourse();
		}else if(j+1 == subject.length && CvSetting == "2"){
		pointCourse();
		}else if(j+1 == subject.length && CvSetting == "3"){
		parallelCourse();
		}
		}
	}
	
	
		// 登录智慧校园，打开选课排课
	public static void loginIq() throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		// 设置浏览器最大化
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 打开测试地址
		driver.get(url);
		// 输入账号密码，点击登录
	    driver.findElement(By.name("userName")).sendKeys("rd_admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2000);
	    // 点击选课排课模快
	    driver.get(url+"/apps/course/index.html");
	    Thread.sleep(2000);
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
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(2000);
	    System.out.println("学科【"+subject[j]+"】"+"，新增成功！");
		// 刷新页面，防止新增学科未显示出来
		driver.navigate().refresh();
		Thread.sleep(1000);
		// 点击学科课程设置
		driver.findElement(By.xpath("//*/li[@data-id='50267']")).click();
		Thread.sleep(2000);
	    // 切至第一个frame内部
		driver.switchTo().frame(1);
		// 选中新增的学科
		driver.findElement(By.xpath("//*/div[@title='" + subject[j] + "']")).click();
		Thread.sleep(1000);
		for (int i = 0; i < course[j].length ;i++){
		// 点击新增课程按钮
		driver.findElement(By.xpath("//*/a[@title='添加']")).click();	
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
		// 输入课程相关信息并提交
		driver.findElement(By.xpath("//*/input[@placeholder='请输入课程名称']")).sendKeys(subject[j]+"-"+course[j][i]);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入课程编号']")).sendKeys(courseID + j + i);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入周学时']")).sendKeys(weektime);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入学分分值']")).sendKeys(credit);	
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[1]/div/div/div/input[@placeholder='请选择']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ classbegin +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/div/input[@placeholder='请选择']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/dl/dd[text()='"+ classfinish +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(2000);
	    System.out.println("学科【"+subject[j]+"】，"+"课程【"+course[j][i]+"】，新增成功！");
	    // 切至第一个frame内部
		driver.switchTo().frame(1);
		}
		// 全选课程
	    driver.findElement(By.id("checkAllSpan")).click();
	    // 点击添加到年级课程池
		driver.findElement(By.xpath("//*/div[@class='tool-list']/a[3]")).click();
		Thread.sleep(2000);
		// 切回主界面
		driver.switchTo().defaultContent();
		// 输入年级课程池信息  班级数量 上限人数
		driver.findElement(By.xpath("//*/form[@id='gradeCourseInfo']/div[1]/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入班级数量']")).sendKeys(classnum);
		driver.findElement(By.xpath("//*/input[@placeholder='请输入学生上限']")).sendKeys(studentmax);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(2000);
	    System.out.println("学科【"+subject[j]+"】下课程已添加至【"+grade+"】课程池！");
		// 点击选课管理
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// 点击设置选课模式
		driver.findElement(By.xpath("//*/li[@data-id='50323']")).click();
		Thread.sleep(2000);
	    // 切至第二个frame内部
		driver.switchTo().frame(2);
	    // 选择年级
		driver.findElement(By.xpath("//*/form[@id='form']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		// 选择学科
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/dl/dd[text()='" + subject[j] + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
		Thread.sleep(1000);
		// 全选课程
	    driver.findElement(By.id("checkAllSpan")).click();
		driver.findElement(By.xpath("//*/a[@title='设置选课模式']")).click();
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*/div[@id='addPointTaskform']/form/div[1]/div/div[" + CvSetting + "]/span")).click();
		driver.findElement(By.xpath("//*/button[text()='立即提交']")).click();
		Thread.sleep(1000);
		if (CvSetting == "1"){
			System.out.println("学科【"+subject[j]+"】，已设置为时间优先选课！");
		}else if(CvSetting == "2"){
			System.out.println("学科【"+subject[j]+"】，已设置为选课点选课！");
		}else if(CvSetting == "3"){
			System.out.println("学科【"+subject[j]+"】，已设置为平行志愿选课！");
		}
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
		// 时间优先选课新建任务，添加课程，发布选课
	public static void timeCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 点击选课管理
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// 点击时间优先选课
		driver.findElement(By.xpath("//*/li[@data-id='50302']")).click();
		// 点击选课任务管理
		driver.findElement(By.xpath("//*/li[@data-name='选课任务管理']")).click();
		Thread.sleep(2000);
	    // 切至第一个frame内部
	    driver.switchTo().frame(1);
	    // 点击新增选课任务按钮
	    driver.findElement(By.xpath("//*/a[@title='新增选课任务']")).click();
		// 切回主界面
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// 输入选课任务名，可选学科数量后点击确定
		driver.findElement(By.xpath("//*/input[@id='name']")).sendKeys(taskname);
		driver.findElement(By.xpath("//*/input[@id='maxSubjectNum']")).sendKeys(maxSubjectNum);
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
		Thread.sleep(2000);
		System.out.println("时间优先任务名【"+taskname+"】，新增成功！");
		// 切至第一个frame内部
		driver.switchTo().frame(1);
	    // 输入新建的任务名称
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
		// 点击查询按钮
		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
		Thread.sleep(1000);
		// 查找成功，点击课程清单按钮
		driver.findElement(By.xpath("//*/button[@title='课程清单']")).click();
		Thread.sleep(1000);
		for(int i = 0; i < subject.length; i++){
		// 进入课程清单界面，点击添加课程按钮，进入添加课程界面
		driver.findElement(By.xpath("//*/a[@title='添加课程']")).click();
		Thread.sleep(2000);
		// 切回主界面
		driver.switchTo().defaultContent();
	    // 再切至frame内部
 		WebElement iframe = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
 		driver.switchTo().frame(iframe);
	    // 点击下拉框，选择年级
		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// 点击下拉框，选择学科
		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/dl/dd[text()='" + subject[i] + "']")).click();  
		// 点击查询
		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
		Thread.sleep(1000);
		// 查出课程后全选
	    driver.findElement(By.id("checkAllSpan")).click();
	    // 点击添加课程
		driver.findElement(By.xpath("//*/a[@title='添加课程']")).click();
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
		// 在跳出的确认弹框界面点击确定按钮
		driver.findElement(By.xpath("//*/a[text()='确定']")).click();
		Thread.sleep(2000);
		// 切至第一个frame内部
		driver.switchTo().frame(1);
		}
	    // 点击全选课程
	    driver.findElement(By.xpath("//*/div[@id='table']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // 点击发布课程
		driver.findElement(By.xpath("//*/a[@title='发布课程']")).click();
	    Thread.sleep(2000);
		// 切回主界面
		driver.switchTo().defaultContent();
		// 再切至frame内部
 		WebElement iframe1 = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
 		driver.switchTo().frame(iframe1);
        // 选择建立时间--清除日期控件是readonly属性  
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        // remove readonly attribute  
        removeAttribute.executeScript("var setDate=document.getElementById(\"beginTime\");setDate.removeAttribute('readonly');");
		// 找到选课开始日期id属性并输入选课时间
        driver.findElement(By.id("beginTime")).sendKeys(beginTime);
		// 点击选课开始日期区域收起时间控件
		driver.findElement(By.xpath("//*/label[text()='选课开始日期:']")).click();	
		// 选择建立时间--清除日期控件是readonly属性 
        JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
        // remove readonly attribute  
        removeAttribute1.executeScript("var setDate=document.getElementById(\"endTime\");setDate.removeAttribute('readonly');");
        // 找到选课结束日期id属性并输入选课时间
        driver.findElement(By.id("endTime")).sendKeys(endTime);
		// 点击选课开始日期区域收起时间控件
		driver.findElement(By.xpath("//*/label[text()='选课开始日期:']")).click();
		// 点击确定按钮发布课程任务
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
		Thread.sleep(2000);
		System.out.println("时间优先选课任务发布成功！");
		System.out.println("选课时间为："+beginTime+" - "+endTime);
	    }

		// 选课点选课新建任务，添加课程，发布选课
	public static void pointCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 点击选课管理
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// 点击选课点选课
		driver.findElement(By.xpath("//*/li[@data-id='50278']")).click();
		// 点击选课任务管理
		driver.findElement(By.xpath("//*/li[@data-id='50279']")).click();
		Thread.sleep(2000);
	    // 切至第一个frame内部
	    driver.switchTo().frame(1);
	    // 点击新增选课任务按钮
	    driver.findElement(By.xpath("//*/a[@title='新增选课任务']")).click();
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
		// 输入选课任务名，最大可选学科数
		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(taskname);
		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(maxSubjectNum);
		// 点击确定按钮
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
		Thread.sleep(2000);
		System.out.println("选课点任务名【"+taskname+"】，新增成功！");
		driver.switchTo().frame(1);
	    // 输入任务名
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
		// 点击查询按钮
		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
		Thread.sleep(1000);
		// 点击课程清单
		driver.findElement(By.xpath("//*/button[@title='课程清单']")).click();
		Thread.sleep(1000);
		// 进入课程清单界面，点击新建一轮选课按钮
		driver.findElement(By.id("createCourseBtn")).click();
		Thread.sleep(1000);
		// 点击添加课程按钮
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000); 
		for(int i = 0; i < subject.length; i++){
	    // 点击下拉框，选择年级
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// 点击下拉框，选择学科
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + subject[i] + "']")).click(); 
		Thread.sleep(1000);
		// 点击查询按钮
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[4]/button")).click();	
		Thread.sleep(1000);   
		// 全选课程
	    driver.findElement(By.xpath("//*/div[@id='addCourseListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // 点击添加课程按钮
		driver.findElement(By.xpath("//*/a[@title='添加课程']")).click();
		Thread.sleep(1000);
		if(i+1 != subject.length){
		// 点击添加课程按钮
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000);
		}}
		// 全选课程
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // 点击修改设置选课时间
		driver.findElement(By.xpath("//*/a[@title='批量修改']")).click();
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
        //选择建立时间--清除日期控件是readonly属性  
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        //remove readonly attribute  
        removeAttribute.executeScript("var setDate=document.getElementById(\"selectBeginTimeStr\");setDate.removeAttribute('readonly');");
		// 输入选课开始时间
        driver.findElement(By.id("selectBeginTimeStr")).sendKeys(beginTime);
		driver.findElement(By.xpath("//*/label[text()='选课开始时间:']")).click();
		driver.findElement(By.id("selectBeginTimeStr")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='选择时间']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='确定']")).click();
        JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
        //remove readonly attribute  
        removeAttribute1.executeScript("var setDate=document.getElementById(\"selectEndTimeStr\");setDate.removeAttribute('readonly');");
		// 输入选课结束时间
        driver.findElement(By.id("selectEndTimeStr")).sendKeys(endTime);
		driver.findElement(By.xpath("//*/label[text()='选课开始时间:']")).click();
		driver.findElement(By.id("selectEndTimeStr")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='选择时间']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='确定']")).click();
		// 点击确定按钮
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();    
		Thread.sleep(2000);
		driver.switchTo().frame(1);
	    // 全选课程
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // 点击发布按钮
		driver.findElement(By.xpath("//*/a[@title='发布']")).click();
	    Thread.sleep(2000);
		System.out.println("选课点选课任务发布成功！");
		System.out.println("选课时间为："+beginTime+" - "+endTime);
	}
	
		// 平行志愿选课新建任务，添加课程，发布选课
	public static void parallelCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 点击选课管理
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// 点击平行志愿选课
		driver.findElement(By.xpath("//*/li[@data-id='50370']")).click();
		// 点击设置选课优先级
		driver.findElement(By.xpath("//*/li[@data-id='50371']")).click();
		Thread.sleep(2000);
	    driver.switchTo().frame(1); 
	    for(int i = 0; i<subject.length; i++){
		// 点击下拉框，选择班级
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[2]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// 点击下拉框，选择学科
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[3]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[3]/div/div/dl/dd[text()='" + subject[i] + "']")).click(); 
		// 点击查询按钮
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[4]/button")).click();	
		Thread.sleep(1000);
		// 点击优先级标准
		driver.findElement(By.xpath("//*/div[@id='table']/div/div[2]/table/tbody/tr/td[1]/a")).click();	
		Thread.sleep(1000);
		// 点击下拉框，选择学科
		driver.findElement(By.xpath("//*/div[@id='taskWin']/form/div[1]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/div[@id='taskWin']/form/div[1]/div/div/dl/dd[text()='" + prioritySub + "']")).click(); 
		Thread.sleep(1000);
		// 点击确定按钮
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
		Thread.sleep(2000);	
	    }
		// 切回主界面
		driver.switchTo().defaultContent();
		// 点击选课任务管理
		driver.findElement(By.xpath("//*/li[@data-id='50372']")).click();
		Thread.sleep(2000);
	    // 切至第二个frame内部
	    driver.switchTo().frame(2);
	    // 点击新增选课任务按钮
	    driver.findElement(By.xpath("//*/a[@title='新增选课任务']")).click();
		// 切回主界面
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// 输入选课任务名，最大可选学科数
		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(taskname);
		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(maxSubjectNum);
		// 点击确定按钮
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();
		Thread.sleep(2000);
		System.out.println("平行志愿任务名【"+taskname+"】，新增成功！");
		// 切至第二个frame内部
		driver.switchTo().frame(2);
	    // 输入任务名
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
		// 点击查询按钮
		driver.findElement(By.xpath("//*/button[text()='查询']")).click();
		Thread.sleep(1000);
		// 点击课程清单
		driver.findElement(By.xpath("//*/button[@title='课程清单']")).click();
		Thread.sleep(1000);
		// 进入课程清单界面，点击新建一轮选课按钮
		driver.findElement(By.id("createCourseBtn")).click();
		Thread.sleep(1000);
		// 点击添加课程按钮
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000); 
		for(int i = 0; i < subject.length; i++){
	    // 点击下拉框，选择年级
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// 点击下拉框，选择学科
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + subject[i] + "']")).click();
		Thread.sleep(1000);
		// 点击查询按钮
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[4]/button")).click();	
		Thread.sleep(1000);  
		// 全选课程
	    driver.findElement(By.xpath("//*/div[@id='addCourseListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // 点击添加课程按钮
		driver.findElement(By.xpath("//*/a[@title='添加课程']")).click();
		Thread.sleep(2000);
		if(i+1 != subject.length){
		// 点击添加课程按钮
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000);
		}}
		// 全选课程
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // 点击修改设置选课时间
		driver.findElement(By.xpath("//*/a[@title='批量修改']")).click();
		Thread.sleep(1000);
		// 切回主界面
		driver.switchTo().defaultContent();
        //选择建立时间--清除日期控件是readonly属性  
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        //remove readonly attribute  
        removeAttribute.executeScript("var setDate=document.getElementById(\"selectBeginTimeStr\");setDate.removeAttribute('readonly');");
		// 输入选课开始时间
        driver.findElement(By.id("selectBeginTimeStr")).sendKeys(beginTime);
		driver.findElement(By.xpath("//*/label[text()='选课开始时间:']")).click();
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
		driver.findElement(By.xpath("//*/label[text()='选课开始时间:']")).click();
		driver.findElement(By.id("selectEndTimeStr")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='选择时间']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='确定']")).click();
		Thread.sleep(1000);
		// 点击确定按钮
		driver.findElement(By.xpath("//*/button[text()='确定']")).click();    
		Thread.sleep(2000);
		// 切至第二个frame内部
		driver.switchTo().frame(2);
	    // 全选课程
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // 点击发布按钮
		driver.findElement(By.xpath("//*/a[@title='发布']")).click();
	    Thread.sleep(2000);
		System.out.println("平行志愿选课任务发布成功！");
		System.out.println("选课时间为："+beginTime+" - "+endTime);
	}
}