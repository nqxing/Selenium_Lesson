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

public class Iq_school_subject {
	static final WebDriver driver = new ChromeDriver();
	
	static int j;
	static String subject [] = new String[]  
			{"mq_ƽ�У��γ̰�1��","mq_ƽ�У��γ̰�2��"};  // *����Ҫ�½���ѧ��������Ҫ�½�����ѧ�ƾ�����������Ӽ��ţ�ѧ�����ֲ����ظ���ÿ�����нű�ǰ�����޸ģ�
	static String subjectID = "A200";  	// *����ѧ�Ʊ��ǰ׺��ÿ�����нű�ǰ�����޸ģ�
	static String course [][] = new String[][]{  
		{"�γ�yi","�γ�er"},  // *�����Ӧѧ���µĿγ��������ж�Ӧ�����һ��ѧ�ƣ���Ҫ�½����ſγ̾�����������Ӽ��ţ��γ����ֿ��ظ�
		{"�γ�san","�γ�si"},
	};
	static String courseID = "C200";  // *����γ̱��ǰ׺��ÿ�����нű�ǰ�����޸ģ�


	// �½��γ̽��棬����γ���ѧʱ���γ�ѧ��ֵ
	static String weektime = "3";          static String credit = "5";
	// �½��γ̽��棬�����꼶��Χ
	static String classbegin = "һ�꼶";     static String classfinish = "���꼶";
	// ��ӵ��꼶�γ̳أ�ѡ���꼶���༶�������༶��������
	static String grade = "һ�꼶";    static String classnum = "2";  static String studentmax = "2";

	public static void main(String[] args) throws Exception{
		loginIq();
		for(j = 0; j < subject.length; j++){
		newDisciplineCourse();
		}
	}
	
	
		// ��¼�ǻ�У԰����ѡ���ſ�
	public static void loginIq() throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		// ������������
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// �򿪲��Ե�ַ
		driver.get("http://web.591iq.cn");
		// �����˺����룬�����¼
	    driver.findElement(By.name("userName")).sendKeys("mq_admin");
	    driver.findElement(By.name("userPwd")).sendKeys("123456");
	    driver.findElement(By.id("loginBtn")).click();
	    Thread.sleep(2000);
//	    // ���ѡ���ſ�ģ��
//	    driver.get("http://web-dev.591iq.cn/apps/course/index.html");
//	    Thread.sleep(2000);
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
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ����']")).sendKeys(subject[j]);
		driver.findElement(By.xpath("//*/input[@placeholder='��������']")).sendKeys(subjectID + j);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("ѧ�ơ�"+subject[j]+"��"+"�������ɹ���");
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
		driver.findElement(By.xpath("//*/div[@title='" + subject[j] + "']")).click();
		Thread.sleep(2000);
		for (int i = 0; i < course[j].length ;i++){
		// ��������γ̰�ť
		driver.findElement(By.xpath("//*/a[@title='���']")).click();	
		Thread.sleep(1000);
		// �л�������
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// ����γ������Ϣ���ύ
		driver.findElement(By.xpath("//*/input[@placeholder='������γ�����']")).sendKeys(subject[j]+"-"+course[j][i]);
		driver.findElement(By.xpath("//*/input[@placeholder='������γ̱��']")).sendKeys(courseID + j + i);
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
	    System.out.println("ѧ�ơ�"+subject[j]+"����"+"�γ̡�"+course[j][i]+"���������ɹ���");
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
//		driver.findElement(By.xpath("//*/input[@value='������']")).click();
		driver.findElement(By.xpath("//*/form[@id='gradeCourseInfo']/div[1]/div[2]/div/div/div/input")).click();
		driver.findElement(By.xpath("//*/dd[text()='"+ grade +"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*/input[@placeholder='������༶����']")).sendKeys(classnum);
		driver.findElement(By.xpath("//*/input[@placeholder='������ѧ������']")).sendKeys(studentmax);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/div[@class='layui-input-block']/button[1]")).click();
		Thread.sleep(3000);
	    System.out.println("ѧ�ơ�"+subject[j]+"���¿γ����������"+grade+"���γ̳أ�");
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	

}
