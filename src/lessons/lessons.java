package lessons;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class lessons {
	
public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		
		WebDriver driver = new ChromeDriver();
		// ������������
		driver.manage().window().maximize();
		
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
	
        // д������
	    JavascriptExecutor js = (JavascriptExecutor)driver;  
        js.executeScript("var setName=document.querySelector(\".login-con\");setName.innerHTML=' <button onclick=\"myFunction()\">����</button> <script>function myFunction() {	alert(1);} ';");
        Thread.sleep(2000);
		// ����ύ��ť
		driver.findElement(By.xpath("//*/button[text()='����']")).click();
		
	}

}
