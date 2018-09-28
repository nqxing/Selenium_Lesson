package lessons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iq_test {
public static void main(String[] args) throws Exception{
	System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
	//新建学科信息，学科名，学科编号
	String subject = "测试学科零六";      String subjectID = "A00038";
	//新建课程信息，课程名，课程编号，课程周学时，课程学分值，年级范围
	String[] course = new String[3];
	course[0] = "政治课程";
	course[1] = "化学课程";
	course[2] = "物理课程";
	String courseID = "C00030";
	String weektime = "3";          String credit = "5";
	String classbegin = "一年级";     String classfinish = "高三";
	// 添加到年级课程池，选择年级，班级数量，班级上限人数
	String grade = "五年级";    String classnum = "3";  String studentmax = "30";
	// 设置选课模式（时间优先为1  选课点选课为2  平行志愿为3）
	String CvSetting = "2";
	
	WebDriver driver = new ChromeDriver();
	// 设置浏览器最大化
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	// 打开测试地址
	driver.get("http://sso-dev.591iq.cn/login?flag=forward");
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
    // 点击学科设置
	driver.findElement(By.xpath("//*/li[@data-id='50266']")).click();  
	Thread.sleep(2000);
    // 切至第一个frame内部
	driver.switchTo().frame(1);
	// 点击添加学科按钮
	driver.findElement(By.xpath("//*/a[@buttontype='add']")).click();
	Thread.sleep(1000);
	// 切回主界面
	driver.switchTo().defaultContent();
	// 输入学科信息并提交
	driver.findElement(By.xpath("//*/input[@placeholder='请输入学科名']")).sendKeys(subject);
	driver.findElement(By.xpath("//*/input[@placeholder='请输入编号']")).sendKeys(subjectID);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
	Thread.sleep(3000);
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
	driver.findElement(By.xpath("//*/div[@title='" + subject + "']")).click();
	Thread.sleep(2000);
	for (int i = 0; i < course.length ;i++){
	// 点击新增课程按钮
	driver.findElement(By.xpath("//*/div[@class='tool-list']/a[2]")).click();
	Thread.sleep(1000);
	// 切回主界面
	driver.switchTo().defaultContent();
	Thread.sleep(1000);
	// 输入课程相关信息并提交
	driver.findElement(By.xpath("//*/input[@placeholder='请输入课程名称']")).sendKeys(course[i]);
	driver.findElement(By.xpath("//*/input[@placeholder='请输入课程编号']")).sendKeys(courseID + i);
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
    // 切至第一个frame内部
	driver.switchTo().frame(1);
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
	driver.findElement(By.xpath("//*/input[@value='2016级']")).click();;
	driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*/input[@placeholder='请输入班级数量']")).sendKeys(classnum);
	driver.findElement(By.xpath("//*/input[@placeholder='请输入学生上限']")).sendKeys(studentmax);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
	Thread.sleep(3000);
	// 点击选课管理
	driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
	Thread.sleep(2000);
	// 设置选课模式
	driver.findElement(By.xpath("//*/li[@data-id='50323']")).click();
	Thread.sleep(2000);
    // 切至第二个frame内部
	driver.switchTo().frame(2);
	Thread.sleep(1000);
    // 选择年级
	driver.findElement(By.xpath("//*/form[@id='form']/div[2]/div/div/div/input")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
	Thread.sleep(1000);
	// 选择学科
	driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/div/input")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/dl/dd[text()='" + subject + "']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*/button[text()='查询']")).click();
	Thread.sleep(2000);
	// 全选课程
    driver.findElement(By.id("checkAllSpan")).click();
    Thread.sleep(1000);
	driver.findElement(By.xpath("//*/a[@title='设置选课模式']")).click();
	// 切回主界面
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*/div[@id='addPointTaskform']/form/div[1]/div/div[" + CvSetting + "]/span")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*/button[text()='立即提交']")).click();
	Thread.sleep(3000);
}
}
