package iqschool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IqBug {
	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		// 设置浏览器最大化
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// 打开测试地址
		driver.get("http://bug.591iq.com.cn/index.php?m=bug&f=browse&productID=6");
		// 输入账号密码，点击登录
	    driver.findElement(By.name("account")).sendKeys("nieqx");
	    driver.findElement(By.name("password")).sendKeys("iq123456");
	    driver.findElement(By.id("submit")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("createActionMenu")).click();
	    
	}
	
}
