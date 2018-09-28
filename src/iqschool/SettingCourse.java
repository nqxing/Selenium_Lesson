package iqschool;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SettingCourse {
	
	static final WebDriver driver = new ChromeDriver();
	static NewCourse Nc = new NewCourse();
	
		// ��¼�ǻ�У԰����ѡ���ſ�
	public static void loginIq() throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver.exe");
		// ������������
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// �򿪲��Ե�ַ
		driver.get("http://sso-dev.591iq.cn/login?flag=forward");
		// �����˺����룬�����¼
	    driver.findElement(By.name("userName")).sendKeys("admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2000);
	    // ���ѡ���ſ�ģ��
	    driver.get("http://web-dev.591iq.cn/apps/course/index.html");
	    Thread.sleep(2000);
	    // ��ӡ����ҳ����� 
	    System.out.println("��¼�ɹ���");
		
	}
	
		// ����ѧ�ƣ������γ̣����γ�������꼶�γ̳أ�������ѡ��ģʽ
	public static void newDisciplineCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ��ȡѧ������css����
		List<WebElement> menus4 = driver.findElements(By.cssSelector("li.child-module"));
        Thread.sleep(1000);
        // ���ѧ������
        WebElement desiredMenu4 = menus4.get(0);
        desiredMenu4.click();  
		Thread.sleep(2000);
	    // ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		// ������ѧ�ư�ť
		driver.findElement(By.xpath("//*/a[@buttontype='add']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		// ����ѧ����Ϣ���ύ
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ����']")).sendKeys(Nc.subject[Nc.i]);
		driver.findElement(By.xpath("//*/input[@placeholder='��������']")).sendKeys(Nc.subjectID + Nc.i);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("ѧ�ơ�"+Nc.subject[Nc.i]+"��"+"�������ɹ���");
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
		driver.findElement(By.xpath("//*/div[@title='" + Nc.subject[Nc.i] + "']")).click();
		Thread.sleep(2000);
		for (int i = 0; i < Nc.course[Nc.i].length ;i++){
		// ��������γ̰�ť
		driver.findElement(By.xpath("//*/a[@title='���']")).click();	
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// ����γ������Ϣ���ύ
		driver.findElement(By.xpath("//*/input[@placeholder='������γ�����']")).sendKeys(Nc.course[Nc.i][i]);
		driver.findElement(By.xpath("//*/input[@placeholder='������γ̱��']")).sendKeys(Nc.courseID + Nc.i + i);
		driver.findElement(By.xpath("//*/input[@placeholder='��������ѧʱ']")).sendKeys(Nc.weektime);
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ�ַ�ֵ']")).sendKeys(Nc.credit);	
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[1]/div/div/div/input[@placeholder='��ѡ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ Nc.classbegin +"']")).click();
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/div/input[@placeholder='��ѡ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/dl/dd[text()='"+ Nc.classfinish +"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("ѧ�ơ�"+Nc.subject[Nc.i]+"����"+"�γ̡�"+Nc.course[Nc.i][i]+"���������ɹ���");
	    Thread.sleep(1000);
	    // ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		}
		// ȫѡ�γ�
		Thread.sleep(2000);
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
		driver.findElement(By.xpath("//*/dd[text()='"+ Nc.grade +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/input[@placeholder='������༶����']")).sendKeys(Nc.classnum);
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ������']")).sendKeys(Nc.studentmax);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("ѧ�ơ�"+Nc.subject[Nc.i]+"���¿γ����������"+Nc.grade+"���γ̳أ�");
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(2000);
		// �������ѡ��ģʽ
		driver.findElement(By.xpath("//*/li[@data-id='50323']")).click();
		Thread.sleep(2000);
	    // �����ڶ���frame�ڲ�
		driver.switchTo().frame(2);
		Thread.sleep(1000);
	    // ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='form']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ Nc.grade +"']")).click();
		Thread.sleep(1000);
		// ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/dl/dd[text()='" + Nc.subject[Nc.i] + "']")).click();
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
		driver.findElement(By.xpath("//*/div[@id='addPointTaskform']/form/div[1]/div/div[" + Nc.CvSetting + "]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='�����ύ']")).click();
		Thread.sleep(2000);
		if (Nc.CvSetting == "1"){
			System.out.println("ѧ�ơ�"+Nc.subject[Nc.i]+"����������Ϊʱ������ѡ�Σ�");
		}else if(Nc.CvSetting == "2"){
			System.out.println("ѧ�ơ�"+Nc.subject[Nc.i]+"����������Ϊѡ�ε�ѡ�Σ�");
		}else if(Nc.CvSetting == "3"){
			System.out.println("ѧ�ơ�"+Nc.subject[Nc.i]+"����������Ϊƽ��־Ըѡ�Σ�");
		}
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
		// ʱ������ѡ���½�������ӿγ̣�����ѡ��
	public static void timeCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
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
		driver.findElement(By.xpath("//*/input[@id='name']")).sendKeys(Nc.taskname);
		driver.findElement(By.xpath("//*/input[@id='maxSubjectNum']")).sendKeys(Nc.maxSubjectNum);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ʱ��������������"+Nc.taskname+"���������ɹ���");
		// ������һ��frame�ڲ�
		driver.switchTo().frame(1);
	    Thread.sleep(1000);
	    // �����½�����������
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(Nc.taskname);
		Thread.sleep(1000);
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
		Thread.sleep(2000);
		// ���ҳɹ�������γ��嵥��ť
		driver.findElement(By.xpath("//*/button[@title='�γ��嵥']")).click();
		Thread.sleep(2000);
		for(int i = 0; i < Nc.subject.length; i++){
		// ����γ��嵥���棬�����ӿγ̰�ť��������ӿγ̽���
		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	    // ������frame�ڲ�
 		WebElement iframe = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
 		driver.switchTo().frame(iframe);
	    Thread.sleep(1000);
	    // ���������ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/dl/dd[text()='" + Nc.grade + "']")).click();
		Thread.sleep(2000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/dl/dd[text()='" + Nc.subject[i] + "']")).click();  
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
		// ������frame�ڲ�
 		WebElement iframe1 = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
 		driver.switchTo().frame(iframe1);
	    Thread.sleep(1000);
        // ѡ����ʱ��--������ڿؼ���readonly����  
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        // remove readonly attribute  
        removeAttribute.executeScript("var setDate=document.getElementById(\"beginTime\");setDate.removeAttribute('readonly');");
		// �ҵ�ѡ�ο�ʼ����id���Բ�����ѡ��ʱ��
        driver.findElement(By.id("beginTime")).sendKeys(Nc.beginTime);
		Thread.sleep(1000);
		// ���ѡ�ο�ʼ������������ʱ��ؼ�
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼ����:']")).click();	
		// ѡ����ʱ��--������ڿؼ���readonly���� 
        JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
        // remove readonly attribute  
        removeAttribute1.executeScript("var setDate=document.getElementById(\"endTime\");setDate.removeAttribute('readonly');");
        // �ҵ�ѡ�ν�������id���Բ�����ѡ��ʱ��
        driver.findElement(By.id("endTime")).sendKeys(Nc.endTime);
		Thread.sleep(1000);
		// ���ѡ�ο�ʼ������������ʱ��ؼ�
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼ����:']")).click();
		Thread.sleep(1000);
		// ���ȷ����ť�����γ�����
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ʱ������ѡ�����񷢲��ɹ���");
		System.out.println("ѡ��ʱ��Ϊ��"+Nc.beginTime+" - "+Nc.endTime);
	    }

		// ѡ�ε�ѡ���½�������ӿγ̣�����ѡ��
	public static void pointCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(2000);
		// ���ѡ�ε�ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50278']")).click();
		Thread.sleep(2000);
		// ���ѡ���������
		driver.findElement(By.xpath("//*/li[@data-id='50279']")).click();
		Thread.sleep(2000);
	    // ������һ��frame�ڲ�
	    driver.switchTo().frame(1);
	    Thread.sleep(1000);
	    // �������ѡ������ť
	    driver.findElement(By.xpath("//*/a[@title='����ѡ������']")).click();
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// ����ѡ��������������ѡѧ����
		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(Nc.taskname);
		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(Nc.maxSubjectNum);
		Thread.sleep(2000);
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ѡ�ε���������"+Nc.taskname+"���������ɹ���");
		driver.switchTo().frame(1);
	    Thread.sleep(1000);
	    // ����������
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(Nc.taskname);
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
	    
		for(int i = 0; i < Nc.subject.length; i++){
	    // ���������ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + Nc.grade + "']")).click();
		Thread.sleep(2000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + Nc.subject[i] + "']")).click(); 
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
		if(i+1 != Nc.subject.length){
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
        driver.findElement(By.id("selectBeginTimeStr")).sendKeys(Nc.beginTime);
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
        driver.findElement(By.id("selectEndTimeStr")).sendKeys(Nc.endTime);
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
		System.out.println("ѡ�ε�ѡ�����񷢲��ɹ���");
		System.out.println("ѡ��ʱ��Ϊ��"+Nc.beginTime+" - "+Nc.endTime);
	}
	
		// ƽ��־Ըѡ���½�������ӿγ̣�����ѡ��
	public static void parallelCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(2000);
		// ���ƽ��־Ըѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50370']")).click();
		Thread.sleep(2000);
		// �������ѡ�����ȼ�
		driver.findElement(By.xpath("//*/li[@data-id='50371']")).click();
		Thread.sleep(2000);
	    driver.switchTo().frame(1);
	    Thread.sleep(1000);
	    
	    for(int i = 0; i<Nc.subject.length; i++){
		// ���������ѡ��༶
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[2]/div/div/dl/dd[text()='" + Nc.grade + "']")).click();
		Thread.sleep(2000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[3]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[3]/div/div/dl/dd[text()='" + Nc.subject[i] + "']")).click(); 
		Thread.sleep(2000);
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[4]/button")).click();	
		Thread.sleep(2000);
		// ������ȼ���׼
		driver.findElement(By.xpath("//*/div[@id='table']/div/div[2]/table/tbody/tr/td[1]/a")).click();	
		Thread.sleep(2000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/div[@id='taskWin']/form/div[1]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@id='taskWin']/form/div[1]/div/div/dl/dd[text()='" + Nc.prioritySub + "']")).click(); 
		Thread.sleep(2000);
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);		
	    }
	    
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// ���ѡ���������
		driver.findElement(By.xpath("//*/li[@data-id='50372']")).click();
		Thread.sleep(2000);
	    // �����ڶ���frame�ڲ�
	    driver.switchTo().frame(2);
	    Thread.sleep(2000);
	    // �������ѡ������ť
	    driver.findElement(By.xpath("//*/a[@title='����ѡ������']")).click();
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// ����ѡ��������������ѡѧ����
		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(Nc.taskname);
		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(Nc.maxSubjectNum);
		Thread.sleep(2000);
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ƽ��־Ը��������"+Nc.taskname+"���������ɹ���");
	    // �����ڶ���frame�ڲ�
	    driver.switchTo().frame(2);
	    Thread.sleep(1000);
	    // ����������
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(Nc.taskname);
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
	    
		for(int i = 0; i < Nc.subject.length; i++){
	    // ���������ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + Nc.grade + "']")).click();
		Thread.sleep(2000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + Nc.subject[i] + "']")).click(); 
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
		if(i+1 != Nc.subject.length){
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
        driver.findElement(By.id("selectBeginTimeStr")).sendKeys(Nc.beginTime);
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
        driver.findElement(By.id("selectEndTimeStr")).sendKeys(Nc.endTime);
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
	    // �����ڶ���frame�ڲ�
	    driver.switchTo().frame(2);
	    Thread.sleep(1000);
	    // ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    Thread.sleep(1000);
	    // ���������ť
		driver.findElement(By.xpath("//*/a[@title='����']")).click();
	    Thread.sleep(2000);
		System.out.println("ƽ��־Ըѡ�����񷢲��ɹ���");
		System.out.println("ѡ��ʱ��Ϊ��"+Nc.beginTime+" - "+Nc.endTime);
	}
}
