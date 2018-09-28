package lessons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class iq_test3 {
	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
		//�½�ѧ����Ϣ��ѧ������ѧ�Ʊ��
		
		String subject [] = new String[]  
				{"ѧ��3��0612��","ѧ��4��0612��"};  // *����Ҫ�½���ѧ��������Ҫ�½�����ѧ�ƾ�����������Ӽ��ţ�ѧ�����ֲ����ظ�
			String course [][] = new String[][]{  
			{"�γ�1","�γ�2","�γ�3"},  // *�����Ӧѧ���µĿγ��������ж�Ӧ�����һ��ѧ�ƣ���Ҫ�½����ſγ̾�����������Ӽ��ţ��γ����ֿ��ظ�
			{"�γ�4","�γ�5"},
		};
		String subjectID = "A810";  	// *����ѧ�Ʊ��ǰ׺��ÿ�����нű�ǰ�ǵ��޸Ĵ��
		String courseID = "C810";  // *����γ̱��ǰ׺��ÿ�����нű�ǰ�ǵ��޸Ĵ��
		String CvSetting = "3"; 	// *����ѡ��ģʽ��ʱ������Ϊ1  ѡ�ε�ѡ��Ϊ2  ƽ��־ԸΪ3�� 
		String taskname = "�½�����3";  // *����ѡ���������������������ظ�        
		String maxSubjectNum = "1";  // ����ѧ����ѡѧ������
		// *����ѡ�ο�ʼʱ��ͽ���ʱ�䣨ע�⣺ѡ�ε��ƽ��־Ըѡ�ο�ʼʱ�䲻�����ڵ�ǰʱ�䣬���뿪ʼʱ��ʱ����Ͻű���Ԥ������ʱ�䣩
		String beginTime = "2018-06-12 16:20:13";   String endTime = "2018-06-12 20:30:13";
		
		String prioritySub = "��ѧ"; // ƽ��־Ը�������ȼ�ѧ�Ƴɼ�
		// �½��γ̽��棬����γ���ѧʱ���γ�ѧ��ֵ
		String weektime = "3";          String credit = "5";
		// �½��γ̽��棬�����꼶��Χ
		String classbegin = "һ�꼶";     String classfinish = "����";
		// ��ӵ��꼶�γ̳أ�ѡ���꼶���༶�������༶��������
		String grade = "���꼶";    String classnum = "2";  String studentmax = "30";
		
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
		
		// ���ƽ��־Ըѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50370']")).click();
		Thread.sleep(2000);
	 // ���ѡ���������
	 		driver.findElement(By.xpath("//*/li[@data-id='50372']")).click();
	 		Thread.sleep(2000);
	 	    // ������һ��frame�ڲ�
	 	    driver.switchTo().frame(1);
	 	    Thread.sleep(2000);
	 	    // �������ѡ������ť
	 	    driver.findElement(By.xpath("//*/a[@title='����ѡ������']")).click();
	 		// �л�������
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	 		// ����ѡ��������������ѡѧ����
	 		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(taskname);
	 		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(maxSubjectNum);
	 		Thread.sleep(2000);
	 		// ���ȷ����ť
	 		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
	 		Thread.sleep(2000);
	 		System.out.println("ƽ��־Ը��������"+taskname+"���������ɹ���");
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(1000);
	 	    // ����������
	 		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
	 		Thread.sleep(1000);
	 		// �����ѯ��ť
	 		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
	 		Thread.sleep(2000);
	 		// ����γ��嵥
	 		driver.findElement(By.xpath("//*/button[@title='�γ��嵥']")).click();
	 		Thread.sleep(2000);
	 		// ����γ��嵥���棬����½�һ��ѡ�ΰ�ť
	 		driver.findElement(By.id("createCourseBtn")).click();
	 		Thread.sleep(2000);
	 		// �����ӿγ̰�ť
	 		driver.findElement(By.id("addCourseBtn")).click();
	 	    Thread.sleep(2000);
	 	    
	 		for(int i = 0; i < subject.length; i++){
	 	    // ���������ѡ���꼶
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + grade + "']")).click();
	 		Thread.sleep(2000);
	 		// ���������ѡ��ѧ��
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
	 		Thread.sleep(2000);
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + subject[i] + "']")).click(); 
	 		Thread.sleep(2000);
	 		// �����ѯ��ť
	 		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[4]/button")).click();	
	 		Thread.sleep(2000);   
	 		// ȫѡ�γ�
	 	    driver.findElement(By.xpath("//*/div[@id='addCourseListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000);
	 	    // �����ӿγ̰�ť
	 		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
	 		Thread.sleep(3000);
	 		if(i+1 != subject.length){
	 		// �����ӿγ̰�ť
	 		driver.findElement(By.id("addCourseBtn")).click();
	 	    Thread.sleep(2000);
	 		}}
	 		// ȫѡ�γ�
	 	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000);
	 	    // ����޸�����ѡ��ʱ��
	 		driver.findElement(By.xpath("//*/a[@title='�����޸�']")).click();
	 		Thread.sleep(1000);
	 		// �л�������
	 		driver.switchTo().defaultContent();
	 		Thread.sleep(1000);
	         //ѡ����ʱ��--������ڿؼ���readonly����  
	         JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
	         //remove readonly attribute  
	         removeAttribute.executeScript("var setDate=document.getElementById(\"selectBeginTimeStr\");setDate.removeAttribute('readonly');");
	 		// ����ѡ�ο�ʼʱ��
	         driver.findElement(By.id("selectBeginTimeStr")).sendKeys(beginTime);
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼʱ��:']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.id("selectBeginTimeStr")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='ѡ��ʱ��']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='ȷ��']")).click();
	 		Thread.sleep(1000);	
	         JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
	         //remove readonly attribute  
	         removeAttribute1.executeScript("var setDate=document.getElementById(\"selectEndTimeStr\");setDate.removeAttribute('readonly');");
	 		// ����ѡ�ν���ʱ��
	         driver.findElement(By.id("selectEndTimeStr")).sendKeys(endTime);
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼʱ��:']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.id("selectEndTimeStr")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='ѡ��ʱ��']")).click();
	 		Thread.sleep(1000);
	 		driver.findElement(By.xpath("//*/span[text()='ȷ��']")).click();
	 		Thread.sleep(2000);
	 		// ���ȷ����ť
	 		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();    
	 		Thread.sleep(2000);
	 		driver.switchTo().frame(1);
	 	    Thread.sleep(1000);
	 	    // ȫѡ�γ�
	 	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	 	    Thread.sleep(1000);
	 	    // ���������ť
	 		driver.findElement(By.xpath("//*/a[@title='����']")).click();
	 	    Thread.sleep(2000);
	 		System.out.println("ƽ��־Ըѡ�����񷢲��ɹ���");
	 		System.out.println("ѡ��ʱ��Ϊ��"+beginTime+"-"+endTime);
	    }
	    

}
