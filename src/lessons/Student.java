package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Student {
	static String xw = "新闻";
	static WebDriver driver = new ChromeDriver();
	public static void myFirstMethod() throws Exception{  
         MyClass Anthony = new MyClass(); // Anthony 是一个对象或者叫实例  
		 System.out.println(Anthony.name + " is " + Anthony.age + " years old.");
			System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
			
			// WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.baidu.com");
			//By linkText 查找元素
			// driver.findElement(By.linkText(xw)).click();
			driver.findElement(By.xpath("//*/div[@id='u1']/a[text()='"+ xw +"']")).click();
			Thread.sleep(1000);
    }  
	public static void myFirstMethod1() throws Exception{
		driver.findElement(By.id("ww")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("s_btn_wr")).click();
		
	}
}
