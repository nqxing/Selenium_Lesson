package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_iq {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		//��ʼ��һ��chrome�����ʵ����ʵ�����ƽ�driver
		WebDriver driver = new ChromeDriver();
		//��󻯴���
		driver.manage().window().maximize();
		
		// �򿪲��Ե�ַ
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
	    Thread.sleep(2000);
		// �����˺����룬�����¼
	    driver.findElement(By.name("userName")).sendKeys("admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2000);

		// ���ѡ���ſ�  ����·��
		// driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/a[2]")).click();

		// ���ѡ���ſ�  ���·��
		// driver.findElement(By.xpath("//*/a[@data-href='/apps/course/index.html']")).click();
		
		driver.findElement(By.xpath("//*/span[text()='ѡ���ſ�']")).click();
	    
	  
        //�رղ��˳������  
        // driver.quit();  
}
	}
