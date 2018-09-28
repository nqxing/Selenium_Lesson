package iqschool;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author ������
 * @date 2018-06-13
 * �ǻ�У԰-ѡ���ſ�-�Զ�������ѧ�ƿγ̣��½����񷢲�ѡ��
 * 
 * 1����¼���ֻ�У԰ƽ̨����ѡ���ſ�
 * 2������ѧ�ƣ������γ�
 * 3������ѡ��ģʽ
 * 4���½�ѡ�����񣬽�ȫ��ѧ�ƿγ������������
 * 5������ѡ��ʱ��
 * 6������ѡ��
 * 
 * ע�⣺���нű�ǰ��ȷ��������Ϣ�Ѱ�ע��Ҫ����д���
 */

public class Iq_school_course_bak {
	
	static final WebDriver driver = new ChromeDriver();   static int j;
	static String url = "http://web-test.591iq.com.cn"; // ���뱾�β��Ի����ĵ�ַ
	static String CvSetting = "1"; 	// *����ѡ��ģʽ��ʱ������Ϊ1  ѡ�ε�ѡ��Ϊ2  ƽ��־ԸΪ3��
	static String subjectID = "A217";  	// *����ѧ�Ʊ��ǰ׺��ÿ�����нű�ǰ�����޸ģ�
	static String courseID = "C217";  // *����γ̱��ǰ׺��ÿ�����нű�ǰ�����޸ģ�
	static String subject [] = new String[]  
			{"�������ԣ�һ��","�������ԣ�����",};  // *����Ҫ�½���ѧ��������Ҫ�½�����ѧ�ƾ�����������Ӽ��ţ�ѧ�����ֲ����ظ���ÿ�����нű�ǰ�����޸ģ�
	static String course [][] = new String[][]{  
		{"�γ�yi",},  // *�����Ӧѧ���µĿγ��������ж�Ӧ�����һ��ѧ�ƣ���Ҫ�½����ſγ̾�����������Ӽ��ţ��γ����ֿ��ظ�
		{"�γ�er",},
	};
	// *����ѡ�ο�ʼʱ��ͽ���ʱ�䣨ע�⣺ѡ�ε��ƽ��־Ըѡ�ο�ʼʱ�䲻�����ڵ�ǰʱ�䣬���뿪ʼʱ��ʱ����Ͻű���Ԥ������ʱ�䣩
	static String beginTime = "2018-08-28 20:25:13";   static String endTime = "2018-08-29 20:00:13";
	static String taskname = "������������";  // *����ѡ���������������������ظ���ÿ�����нű�ǰ�����޸ģ� 
	static String maxSubjectNum = "2";  // ����ѧ����ѡѧ������
	static String prioritySub = "��ѧ"; // ƽ��־Ը�������ȼ�ѧ�Ƴɼ�,����ѡ�������
	// �½��γ̽��棬����γ���ѧʱ���γ�ѧ��ֵ
	static String weektime = "3";          static String credit = "5";
	// �½��γ̽��棬�����꼶��Χ
	static String classbegin = "��һ";     static String classfinish = "�߶�";
	// ��ӵ��꼶�γ̳أ�ѡ���꼶���༶�������༶��������
	static String grade = "��һ";    static String classnum = "2";  static String studentmax = "300";

	public static void main(String[] args) throws Exception{
		loginIq();
		for(j = 0; j < subject.length; j++){
		newDisciplineCourse();
		if (j+1 == subject.length && CvSetting == "1"){
		timeCourse();
		}else if(j+1 == subject.length && CvSetting == "2"){
		pointCourse();
		}else if(j+1 == subject.length && CvSetting == "3"){
		parallelCourse();
		}
		}
	}
	
	
		// ��¼�ǻ�У԰����ѡ���ſ�
	public static void loginIq() throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		// ������������
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// �򿪲��Ե�ַ
		driver.get(url);
		// �����˺����룬�����¼
	    driver.findElement(By.name("userName")).sendKeys("rd_admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2000);
	    // ���ѡ���ſ�ģ��
	    driver.get(url+"/apps/course/index.html");
	    Thread.sleep(2000);
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
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ����']")).sendKeys(subject[j]);
		driver.findElement(By.xpath("//*/input[@placeholder='��������']")).sendKeys(subjectID + j);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(2000);
	    System.out.println("ѧ�ơ�"+subject[j]+"��"+"�������ɹ���");
		// ˢ��ҳ�棬��ֹ����ѧ��δ��ʾ����
		driver.navigate().refresh();
		Thread.sleep(1000);
		// ���ѧ�ƿγ�����
		driver.findElement(By.xpath("//*/li[@data-id='50267']")).click();
		Thread.sleep(2000);
	    // ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		// ѡ��������ѧ��
		driver.findElement(By.xpath("//*/div[@title='" + subject[j] + "']")).click();
		Thread.sleep(1000);
		for (int i = 0; i < course[j].length ;i++){
		// ��������γ̰�ť
		driver.findElement(By.xpath("//*/a[@title='���']")).click();	
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		// ����γ������Ϣ���ύ
		driver.findElement(By.xpath("//*/input[@placeholder='������γ�����']")).sendKeys(subject[j]+"-"+course[j][i]);
		driver.findElement(By.xpath("//*/input[@placeholder='������γ̱��']")).sendKeys(courseID + j + i);
		driver.findElement(By.xpath("//*/input[@placeholder='��������ѧʱ']")).sendKeys(weektime);
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ�ַ�ֵ']")).sendKeys(credit);	
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[1]/div/div/div/input[@placeholder='��ѡ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ classbegin +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/div/input[@placeholder='��ѡ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='formId']/div[4]/div[2]/div/div/dl/dd[text()='"+ classfinish +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(2000);
	    System.out.println("ѧ�ơ�"+subject[j]+"����"+"�γ̡�"+course[j][i]+"���������ɹ���");
	    // ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		}
		// ȫѡ�γ�
	    driver.findElement(By.id("checkAllSpan")).click();
	    // �����ӵ��꼶�γ̳�
		driver.findElement(By.xpath("//*/div[@class='tool-list']/a[3]")).click();
		Thread.sleep(2000);
		// �л�������
		driver.switchTo().defaultContent();
		// �����꼶�γ̳���Ϣ  �༶���� ��������
		driver.findElement(By.xpath("//*/form[@id='gradeCourseInfo']/div[1]/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/input[@placeholder='������༶����']")).sendKeys(classnum);
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ������']")).sendKeys(studentmax);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(2000);
	    System.out.println("ѧ�ơ�"+subject[j]+"���¿γ����������"+grade+"���γ̳أ�");
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// �������ѡ��ģʽ
		driver.findElement(By.xpath("//*/li[@data-id='50323']")).click();
		Thread.sleep(2000);
	    // �����ڶ���frame�ڲ�
		driver.switchTo().frame(2);
	    // ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='form']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		// ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='form']/div[3]/div/div/dl/dd[text()='" + subject[j] + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
		Thread.sleep(1000);
		// ȫѡ�γ�
	    driver.findElement(By.id("checkAllSpan")).click();
		driver.findElement(By.xpath("//*/a[@title='����ѡ��ģʽ']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*/div[@id='addPointTaskform']/form/div[1]/div/div[" + CvSetting + "]/span")).click();
		driver.findElement(By.xpath("//*/button[text()='�����ύ']")).click();
		Thread.sleep(1000);
		if (CvSetting == "1"){
			System.out.println("ѧ�ơ�"+subject[j]+"����������Ϊʱ������ѡ�Σ�");
		}else if(CvSetting == "2"){
			System.out.println("ѧ�ơ�"+subject[j]+"����������Ϊѡ�ε�ѡ�Σ�");
		}else if(CvSetting == "3"){
			System.out.println("ѧ�ơ�"+subject[j]+"����������Ϊƽ��־Ըѡ�Σ�");
		}
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
		// ʱ������ѡ���½�������ӿγ̣�����ѡ��
	public static void timeCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// ���ʱ������ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50302']")).click();
		// ���ѡ���������
		driver.findElement(By.xpath("//*/li[@data-name='ѡ���������']")).click();
		Thread.sleep(2000);
	    // ������һ��frame�ڲ�
	    driver.switchTo().frame(1);
	    // �������ѡ������ť
	    driver.findElement(By.xpath("//*/a[@title='����ѡ������']")).click();
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// ����ѡ������������ѡѧ����������ȷ��
		driver.findElement(By.xpath("//*/input[@id='name']")).sendKeys(taskname);
		driver.findElement(By.xpath("//*/input[@id='maxSubjectNum']")).sendKeys(maxSubjectNum);
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ʱ��������������"+taskname+"���������ɹ���");
		// ������һ��frame�ڲ�
		driver.switchTo().frame(1);
	    // �����½�����������
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
		Thread.sleep(1000);
		// ���ҳɹ�������γ��嵥��ť
		driver.findElement(By.xpath("//*/button[@title='�γ��嵥']")).click();
		Thread.sleep(1000);
		for(int i = 0; i < subject.length; i++){
		// ����γ��嵥���棬�����ӿγ̰�ť��������ӿγ̽���
		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
		Thread.sleep(2000);
		// �л�������
		driver.switchTo().defaultContent();
	    // ������frame�ڲ�
 		WebElement iframe = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
 		driver.switchTo().frame(iframe);
	    // ���������ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='forms']/div[2]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='forms']/div[3]/div/div/dl/dd[text()='" + subject[i] + "']")).click();  
		// �����ѯ
		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
		Thread.sleep(1000);
		// ����γ̺�ȫѡ
	    driver.findElement(By.id("checkAllSpan")).click();
	    // �����ӿγ�
		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		// ��������ȷ�ϵ��������ȷ����ť
		driver.findElement(By.xpath("//*/a[text()='ȷ��']")).click();
		Thread.sleep(2000);
		// ������һ��frame�ڲ�
		driver.switchTo().frame(1);
		}
	    // ���ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='table']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // ��������γ�
		driver.findElement(By.xpath("//*/a[@title='�����γ�']")).click();
	    Thread.sleep(2000);
		// �л�������
		driver.switchTo().defaultContent();
		// ������frame�ڲ�
 		WebElement iframe1 = driver.findElement(By.xpath("//*/iframe[@allowtransparency='true']"));
 		driver.switchTo().frame(iframe1);
        // ѡ����ʱ��--������ڿؼ���readonly����  
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        // remove readonly attribute  
        removeAttribute.executeScript("var setDate=document.getElementById(\"beginTime\");setDate.removeAttribute('readonly');");
		// �ҵ�ѡ�ο�ʼ����id���Բ�����ѡ��ʱ��
        driver.findElement(By.id("beginTime")).sendKeys(beginTime);
		// ���ѡ�ο�ʼ������������ʱ��ؼ�
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼ����:']")).click();	
		// ѡ����ʱ��--������ڿؼ���readonly���� 
        JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
        // remove readonly attribute  
        removeAttribute1.executeScript("var setDate=document.getElementById(\"endTime\");setDate.removeAttribute('readonly');");
        // �ҵ�ѡ�ν�������id���Բ�����ѡ��ʱ��
        driver.findElement(By.id("endTime")).sendKeys(endTime);
		// ���ѡ�ο�ʼ������������ʱ��ؼ�
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼ����:']")).click();
		// ���ȷ����ť�����γ�����
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ʱ������ѡ�����񷢲��ɹ���");
		System.out.println("ѡ��ʱ��Ϊ��"+beginTime+" - "+endTime);
	    }

		// ѡ�ε�ѡ���½�������ӿγ̣�����ѡ��
	public static void pointCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// ���ѡ�ε�ѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50278']")).click();
		// ���ѡ���������
		driver.findElement(By.xpath("//*/li[@data-id='50279']")).click();
		Thread.sleep(2000);
	    // ������һ��frame�ڲ�
	    driver.switchTo().frame(1);
	    // �������ѡ������ť
	    driver.findElement(By.xpath("//*/a[@title='����ѡ������']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		// ����ѡ��������������ѡѧ����
		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(taskname);
		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(maxSubjectNum);
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ѡ�ε���������"+taskname+"���������ɹ���");
		driver.switchTo().frame(1);
	    // ����������
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
		Thread.sleep(1000);
		// ����γ��嵥
		driver.findElement(By.xpath("//*/button[@title='�γ��嵥']")).click();
		Thread.sleep(1000);
		// ����γ��嵥���棬����½�һ��ѡ�ΰ�ť
		driver.findElement(By.id("createCourseBtn")).click();
		Thread.sleep(1000);
		// �����ӿγ̰�ť
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000); 
		for(int i = 0; i < subject.length; i++){
	    // ���������ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + subject[i] + "']")).click(); 
		Thread.sleep(1000);
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[4]/button")).click();	
		Thread.sleep(1000);   
		// ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='addCourseListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // �����ӿγ̰�ť
		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
		Thread.sleep(1000);
		if(i+1 != subject.length){
		// �����ӿγ̰�ť
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000);
		}}
		// ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // ����޸�����ѡ��ʱ��
		driver.findElement(By.xpath("//*/a[@title='�����޸�']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
        //ѡ����ʱ��--������ڿؼ���readonly����  
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        //remove readonly attribute  
        removeAttribute.executeScript("var setDate=document.getElementById(\"selectBeginTimeStr\");setDate.removeAttribute('readonly');");
		// ����ѡ�ο�ʼʱ��
        driver.findElement(By.id("selectBeginTimeStr")).sendKeys(beginTime);
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼʱ��:']")).click();
		driver.findElement(By.id("selectBeginTimeStr")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='ѡ��ʱ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='ȷ��']")).click();
        JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
        //remove readonly attribute  
        removeAttribute1.executeScript("var setDate=document.getElementById(\"selectEndTimeStr\");setDate.removeAttribute('readonly');");
		// ����ѡ�ν���ʱ��
        driver.findElement(By.id("selectEndTimeStr")).sendKeys(endTime);
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼʱ��:']")).click();
		driver.findElement(By.id("selectEndTimeStr")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='ѡ��ʱ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='ȷ��']")).click();
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();    
		Thread.sleep(2000);
		driver.switchTo().frame(1);
	    // ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // ���������ť
		driver.findElement(By.xpath("//*/a[@title='����']")).click();
	    Thread.sleep(2000);
		System.out.println("ѡ�ε�ѡ�����񷢲��ɹ���");
		System.out.println("ѡ��ʱ��Ϊ��"+beginTime+" - "+endTime);
	}
	
		// ƽ��־Ըѡ���½�������ӿγ̣�����ѡ��
	public static void parallelCourse() throws Exception{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// ���ѡ�ι���
		driver.findElement(By.xpath("//*/li[@data-id='50236']")).click();
		Thread.sleep(1000);
		// ���ƽ��־Ըѡ��
		driver.findElement(By.xpath("//*/li[@data-id='50370']")).click();
		// �������ѡ�����ȼ�
		driver.findElement(By.xpath("//*/li[@data-id='50371']")).click();
		Thread.sleep(2000);
	    driver.switchTo().frame(1); 
	    for(int i = 0; i<subject.length; i++){
		// ���������ѡ��༶
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[2]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[3]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[3]/div/div/dl/dd[text()='" + subject[i] + "']")).click(); 
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/form[@id='selectSearch']/div[4]/button")).click();	
		Thread.sleep(1000);
		// ������ȼ���׼
		driver.findElement(By.xpath("//*/div[@id='table']/div/div[2]/table/tbody/tr/td[1]/a")).click();	
		Thread.sleep(1000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/div[@id='taskWin']/form/div[1]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/div[@id='taskWin']/form/div[1]/div/div/dl/dd[text()='" + prioritySub + "']")).click(); 
		Thread.sleep(1000);
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);	
	    }
		// �л�������
		driver.switchTo().defaultContent();
		// ���ѡ���������
		driver.findElement(By.xpath("//*/li[@data-id='50372']")).click();
		Thread.sleep(2000);
	    // �����ڶ���frame�ڲ�
	    driver.switchTo().frame(2);
	    // �������ѡ������ť
	    driver.findElement(By.xpath("//*/a[@title='����ѡ������']")).click();
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// ����ѡ��������������ѡѧ����
		driver.findElement(By.xpath("//*/div[@id='taskName']/input")).sendKeys(taskname);
		driver.findElement(By.xpath("//*/input[@name='maxSubjectNum']")).sendKeys(maxSubjectNum);
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();
		Thread.sleep(2000);
		System.out.println("ƽ��־Ը��������"+taskname+"���������ɹ���");
		// �����ڶ���frame�ڲ�
		driver.switchTo().frame(2);
	    // ����������
		driver.findElement(By.xpath("//*/input[@name='teacherPerDsPoint']")).sendKeys(taskname);
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/button[text()='��ѯ']")).click();
		Thread.sleep(1000);
		// ����γ��嵥
		driver.findElement(By.xpath("//*/button[@title='�γ��嵥']")).click();
		Thread.sleep(1000);
		// ����γ��嵥���棬����½�һ��ѡ�ΰ�ť
		driver.findElement(By.id("createCourseBtn")).click();
		Thread.sleep(1000);
		// �����ӿγ̰�ť
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000); 
		for(int i = 0; i < subject.length; i++){
	    // ���������ѡ���꼶
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[1]/div/div/dl/dd[text()='" + grade + "']")).click();
		Thread.sleep(1000);
		// ���������ѡ��ѧ��
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[2]/div/div/dl/dd[text()='" + subject[i] + "']")).click();
		Thread.sleep(1000);
		// �����ѯ��ť
		driver.findElement(By.xpath("//*/form[@id='addCourseSearch']/div[4]/button")).click();	
		Thread.sleep(1000);  
		// ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='addCourseListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // �����ӿγ̰�ť
		driver.findElement(By.xpath("//*/a[@title='��ӿγ�']")).click();
		Thread.sleep(2000);
		if(i+1 != subject.length){
		// �����ӿγ̰�ť
		driver.findElement(By.id("addCourseBtn")).click();
	    Thread.sleep(1000);
		}}
		// ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // ����޸�����ѡ��ʱ��
		driver.findElement(By.xpath("//*/a[@title='�����޸�']")).click();
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
        //ѡ����ʱ��--������ڿؼ���readonly����  
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        //remove readonly attribute  
        removeAttribute.executeScript("var setDate=document.getElementById(\"selectBeginTimeStr\");setDate.removeAttribute('readonly');");
		// ����ѡ�ο�ʼʱ��
        driver.findElement(By.id("selectBeginTimeStr")).sendKeys(beginTime);
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼʱ��:']")).click();
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
		driver.findElement(By.xpath("//*/label[text()='ѡ�ο�ʼʱ��:']")).click();
		driver.findElement(By.id("selectEndTimeStr")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='ѡ��ʱ��']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/span[text()='ȷ��']")).click();
		Thread.sleep(1000);
		// ���ȷ����ť
		driver.findElement(By.xpath("//*/button[text()='ȷ��']")).click();    
		Thread.sleep(2000);
		// �����ڶ���frame�ڲ�
		driver.switchTo().frame(2);
	    // ȫѡ�γ�
	    driver.findElement(By.xpath("//*/div[@id='addElectiveListTable']/div/div[1]/table/thead/tr/th[2]/label/span")).click();
	    // ���������ť
		driver.findElement(By.xpath("//*/a[@title='����']")).click();
	    Thread.sleep(2000);
		System.out.println("ƽ��־Ըѡ�����񷢲��ɹ���");
		System.out.println("ѡ��ʱ��Ϊ��"+beginTime+" - "+endTime);
	}
}