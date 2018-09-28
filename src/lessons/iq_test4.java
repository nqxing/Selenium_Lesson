package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iq_test4 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
		//�½�ѧ����Ϣ��ѧ������ѧ�Ʊ��
		
		String subject [] = new String[]{"�����뽡��","�½�ѧ�ƣ�2��"}; 
		
		String taskname = "�½�����1"; String maxSubjectNum = "1";
		
		String beginTime = "2018-06-08 16:32:13";
		String endTime = "2018-06-08 17:30:13";
		
		//�½��γ���Ϣ���γ������γ̱�ţ��γ���ѧʱ���γ�ѧ��ֵ
		String course = "���пγ�";  String courseID = "B0004";
		String weektime = "3";     String credit = "5";
		String classbegin = "һ�꼶";     String classfinish = "����";
		// ��ӵ��꼶�γ̳أ�
		String grade = "��һ"; String classnum = "3";  String studentmax = "30";
		// ����ѡ��ģʽ��ʱ������  ѡ�ε�ѡ��  ƽ��־Ը��
		String CvSetting = "2";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
		Thread.sleep(1000);
		// �����˺����룬�����¼
	    driver.findElement(By.name("userName")).sendKeys("admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    // �ȴ�3s����ҳ��������
	    Thread.sleep(3000);
	    // ���ѡ���ſ�ģ��
		driver.findElement(By.linkText("ѡ���ſ�")).click();
		// ��ȡ��ǰҳ����    
	    String handle = driver.getWindowHandle();    
	    // ��ȡ����ҳ��ľ������ѭ���ж��ǲ��ǵ�ǰ�ľ��   
	    for (String handles : driver.getWindowHandles()) {    
	        if (handles.equals(handle))    
	            continue;    
	        driver.switchTo().window(handles);    
	    }    
	    // ��ӡ����ҳ����� 
	    System.out.println(driver.getTitle());
	    Thread.sleep(2000);

	 // ���ѡ�ι���
	 		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
	 		Thread.sleep(2000);
	 		// ���ʱ������ѡ��
	 		driver.findElement(By.xpath("//*/li[@data-id='50302']")).click();
	 		Thread.sleep(2000);
	 		// ���ѡ���������
	 		driver.findElement(By.xpath("//*/li[@data-name='ѡ���������']")).click();
	 		Thread.sleep(3000);
	 		
	 	    // ������һ��frame�ڲ�
	 	    driver.switchTo().frame(1);
	 	    Thread.sleep(2000);
	 	    // �������ѡ������ť
	 	    driver.findElement(By.xpath("//*/a[@title='����ѡ������']")).click();
	 		// �л�������
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// ����ѡ������������ѡѧ����������ȷ��
	 		driver.findElement(By.xpath("//*/input[@id='name']")).sendKeys(taskname);
	 		driver.findElement(By.xpath("//*/input[@id='maxSubjectNum']")).sendKeys(maxSubjectNum);
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
	 		Thread.sleep(2000);
	 		// ������һ��frame�ڲ�
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(1000);
	 	    // �����½�����������
	 		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
	 		Thread.sleep(1000);
	 		// �����ѯ��ť
	 		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
	 		Thread.sleep(2000);
	 		// ���ҳɹ�������γ��嵥��ť
	 		driver.findElement(By.xpath("//*/button[@title='�γ��嵥']")).click();
	 		Thread.sleep(2000);
	 		
	 		for(int i = 0; i < subject.length; i++){
	 		// ����γ��嵥���棬�����ӿγ̰�ť��������ӿγ̽���
	 		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
	 		Thread.sleep(1000);
	 		// �л�������
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 	    // ������layui-layer-iframe3�ڲ�
	 		// driver.switchTo().frame("layui-layer-iframe3");
	 		WebElement iframe = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
	 		driver.switchTo().frame(iframe);
	 		// WebElement iframe = driver.findElement(By.id("layui-layer-iframe3"));
	 		
	 	    Thread.sleep(1000);
	 	    // ���������ѡ���꼶
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/dl/dd[text()='" + grade + "']")).click();
	 		Thread.sleep(2000);
	 		// ���������ѡ��ѧ��
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/dl/dd[text()='" + subject[i] + "']")).click();  
	 		Thread.sleep(2000);
	 		// �����ѯ
	 		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
	 		Thread.sleep(2000);
	 		// ����γ̺�ȫѡ
	 	    driver.findElement(By.id("checkAllSpan")).click();
	 	    Thread.sleep(2000);
	 	    // �����ӿγ�
	 		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
	 		Thread.sleep(1000);
	 		// �л�������
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// ��������ȷ�ϵ��������ȷ����ť
	 		driver.findElement(By.xpath("//*/a[text()='ȷ��']")).click();
	 		Thread.sleep(1000);
	 		// ������һ��frame�ڲ�
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(2000);
	 		}
	 		
	 	    // ���ȫѡ�γ�
	 	    driver.findElement(By.xpath("//*/div[@id='table']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000); 
	 	    // ��������γ�
	 		driver.findElement(By.xpath("//*/a[@title='�����γ�']")).click();
	 	    Thread.sleep(1000);
	 		// �л�������
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// ������layui-layer-iframe6�ڲ�
	 		// driver.switchTo().frame("layui-layer-iframe6");
	 		WebElement iframe1 = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
	 		driver.switchTo().frame(iframe1);
	 	    Thread.sleep(1000);
	         // ѡ����ʱ��--������ڿؼ���readonly����  
	         JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
	         // remove readonly attribute  
	         removeAttribute.executeScript("var setDate=document.getElementById(\"beginTime\");setDate.removeAttribute('readonly');");
	 		// �ҵ�ѡ�ο�ʼ����id���Բ�����ѡ��ʱ��
	         driver.findElement(By.id("beginTime")).sendKeys(beginTime);
	 		Thread.sleep(1000);
	 		// ���ѡ�ο�ʼ������������ʱ��ؼ�
	 		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼ����:']")).click();	
	 		// ѡ����ʱ��--������ڿؼ���readonly���� 
	         JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
	         // remove readonly attribute  
	         removeAttribute1.executeScript("var setDate=document.getElementById(\"endTime\");setDate.removeAttribute('readonly');");
	         // �ҵ�ѡ�ν�������id���Բ�����ѡ��ʱ��
	         driver.findElement(By.id("endTime")).sendKeys(endTime);
	 		Thread.sleep(1000);
	 		// ���ѡ�ο�ʼ������������ʱ��ؼ�
	 		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼ����:']")).click();
	 		Thread.sleep(1000);
	 		// ���ȷ����ť�����γ�����
	 		driver.findElement(By.xpath("//*/button[text()='ȡ��']")).click();
	 		Thread.sleep(2000);
	    
	}

}
