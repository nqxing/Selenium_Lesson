package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_iq {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		//初始化一个chrome浏览器实例，实例名称叫driver
		WebDriver driver = new ChromeDriver();
		//最大化窗口
		driver.manage().window().maximize();
		
		// 打开测试地址
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
	    Thread.sleep(2000);
		// 输入账号密码，点击登录
	    driver.findElement(By.name("userName")).sendKeys("admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2000);

		// 点击选课排课  绝对路径
		// driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/a[2]")).click();

		// 点击选课排课  相对路径
		// driver.findElement(By.xpath("//*/a[@data-href='/apps/course/index.html']")).click();
		
		driver.findElement(By.xpath("//*/span[text()='选课排课']")).click();
	    
	  
        //关闭并退出浏览器  
        // driver.quit();  
}
	}
