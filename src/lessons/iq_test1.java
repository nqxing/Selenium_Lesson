package lessons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iq_test1 {
public static void main(String[] args) throws Exception{
	System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize(); 
	driver.get("http://sso-dev.591iq.cn/login?flag=forward");
	Thread.sleep(1000);
    driver.findElement(By.name("userName")).sendKeys("admin");
    driver.findElement(By.name("userPwd")).sendKeys("123456");
    driver.findElement(By.id("loginBtn")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("学业评价")).click();
    Thread.sleep(1000);
	driver.findElement(By.linkText("数据汇聚")).click();
	Thread.sleep(1000);
/*	// 获取当前页面句柄    
    String handle = driver.getWindowHandle();    
    // 获取所有页面的句柄，并循环判断不是当前的句柄   
    for (String handles : driver.getWindowHandles()) {    
        if (handles.equals(handle))    
            continue;    
        driver.switchTo().window(handles);    
    }    
    String title = driver.getTitle();  
    System.out.println(title);*/
	String[] handles = new String[driver.getWindowHandles().size()];
	System.out.println(handles.length);
	driver.getWindowHandles().toArray(handles);
	//切换到注册窗口
	WebDriver handle1 = driver.switchTo().window(handles[0]);
	System.out.println("a"+handle1.getTitle());
	Thread.sleep(3000);
	WebDriver handle2 = driver.switchTo().window(handles[2]);
	System.out.println("a"+handle2.getTitle());
	WebDriver handle3 = driver.switchTo().window(handles[1]);
	System.out.println("a"+handle3.getTitle());
	Thread.sleep(3000);
	
}
}
