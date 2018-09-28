package lessons;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class lessons {
	
public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		
		WebDriver driver = new ChromeDriver();
		// 设置浏览器最大化
		driver.manage().window().maximize();
		
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
	
        // 写入正文
	    JavascriptExecutor js = (JavascriptExecutor)driver;  
        js.executeScript("var setName=document.querySelector(\".login-con\");setName.innerHTML=' <button onclick=\"myFunction()\">点我</button> <script>function myFunction() {	alert(1);} ';");
        Thread.sleep(2000);
		// 点击提交按钮
		driver.findElement(By.xpath("//*/button[text()='点我']")).click();
		
	}

}
