package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Iq_test5 {

	public static void main(String[] args) throws Exception{
//		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
		//�½�ѧ����Ϣ��ѧ������ѧ�Ʊ��
		String subject = "����ѧ��9";      
		String subjectID = "A000423";
		//�½��γ���Ϣ���γ������γ̱�ţ��γ���ѧʱ���γ�ѧ��ֵ���꼶��Χ
		String course = "���пγ�3";       
		String courseID = "B000523";
		String weektime = "3";          
		String credit = "5";
		String classbegin = "һ�꼶";    
		String classfinish = "����";
		// ��ӵ��꼶�γ̳أ�ѡ���꼶���༶�������༶��������
		String grade = "���꼶";    
		String classnum = "3";  
		String studentmax = "30";
		// ����ѡ��ģʽ��ʱ������Ϊ1  ѡ�ε�ѡ��Ϊ2  ƽ��־ԸΪ3��
		String CvSetting = "3";
		
		WebDriver driver = new ChromeDriver();
		// ������������
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// �򿪲��Ե�ַ
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
		// �����˺����룬�����¼
	    driver.findElement(By.name("userName")).sendKeys("admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    // �ȴ�3s����ҳ��������
	    Thread.sleep(3000);
 
		// �� ѡ���ſ� ��ַ
	     driver.get("http://web-dev.591iq.cn/apps/course/index.html");
	     Thread.sleep(2000);
		 
		 List<WebElement> menus4 = driver.findElements(By.cssSelector("li.child-module"));
         //System.out.println(" menus4.size()  = "+ menus4.size() );
         Thread.sleep(1000);
		 
         // ���ѧ������
         WebElement desiredMenu4 = menus4.get(0);
         desiredMenu4.click();
		  
	    // ��ӡ����ҳ����� 
	    System.out.println(driver.getTitle());
	    Thread.sleep(2000);
	    
//	    // ���ѧ������
//		driver.findElement(By.xpath("//*/li[@data-id='50266']")).click();  
//		Thread.sleep(2000);
		
//		assert true;
		
	    // ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		// ������ѧ�ư�ť
		driver.findElement(By.xpath("//*/a[@buttontype='add']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		// ����ѧ����Ϣ���ύ
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ����']")).sendKeys(subject);
		driver.findElement(By.xpath("//*/input[@placeholder='��������']")).sendKeys(subjectID);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
		// ���ѧ�ƿγ�����
		driver.findElement(By.xpath("//*/li[@data-id='50267']")).click();
		Thread.sleep(1000);
		// ˢ��ҳ�棬��ֹ����ѧ��δ��ʾ����
		driver.navigate().refresh();
		Thread.sleep(2000);
		// �ٴε��ѧ�ƿγ�����
		driver.findElement(By.xpath("//*/li[@data-id='50267']")).click();
		Thread.sleep(2000);
	    // ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		// ѡ��������ѧ��
		driver.findElement(By.xpath("//*/div[@title='" + subject + "']")).click();
		Thread.sleep(2000);
		// ��������γ̰�ť
		driver.findElement(By.xpath("//*/div[@class='tool-list']/a[2]")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		// ����γ������Ϣ���ύ
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/input[@placeholder='������γ�����']")).sendKeys(course);
		driver.findElement(By.xpath("//*/input[@placeholder='������γ̱��']")).sendKeys(courseID);
		driver.findElement(By.xpath("//*/input[@placeholder='��������ѧʱ']")).sendKeys(weektime);
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ�ַ�ֵ']")).sendKeys(credit);	
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[1]/div/div/div/input[@placeholder='��ѡ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ classbegin +"']")).click();
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/div/input[@placeholder='��ѡ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/dl/dd[text()='"+ classfinish +"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    // ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		// ȫѡ�γ�
	    driver.findElement(By.id("checkAllSpan")).click();
	    Thread.sleep(1000);
	    // �����ӵ��꼶�γ̳�
		driver.findElement(By.xpath("//*/div[@class='tool-list']/a[3]")).click();
		Thread.sleep(2000);
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// �����꼶�γ̳���Ϣ  �༶���� ��������
		driver.findElement(By.xpath("//*/input[@value='2016��']")).click();;
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/input[@placeholder='������༶����']")).sendKeys(classnum);
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ������']")).sendKeys(studentmax);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(2000);
		// ����ѡ��ģʽ
		driver.findElement(By.xpath("//*/li[@data-id='50323']")).click();
		Thread.sleep(2000);
	    // �����ڶ���frame�ڲ�
		driver.switchTo().frame(2);
		Thread.sleep(1000);
	    // ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='form']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		// ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/dl/dd[text()='" + subject + "']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
		Thread.sleep(2000);
		// ȫѡ�γ�
	    driver.findElement(By.id("checkAllSpan")).click();
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//*/a[@title='����ѡ��ģʽ']")).click();
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@id='addPointTaskform']/form/div[1]/div/div[" + CvSetting + "]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='�����ύ']")).click();
		Thread.sleep(3000);
	}
	 

	
}

