package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iq_test2 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
		Thread.sleep(1000);
	    WebElement username =  driver.findElement(By.name("userName"));
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    
	    username.sendKeys("admin");
	    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",username);
	    
	    WebElement pwd = driver.findElement(By.name("userPwd"));
	    
	    pwd.sendKeys("123456");
	    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",pwd);
	    
	}
}
