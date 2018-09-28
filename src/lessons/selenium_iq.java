package lessons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author ���˻�
 * @date 2018-05-25
 * selenium for Chrome
 * 1����¼���ֻ�У԰ƽ̨��
 * 2����ѧ����Ϣҳ��
 * 3����дѧ����Ϣ
 * 4������ѧ����Ϣ
 * 
 */
public class selenium_iq {

	 public static void main(String[] args) throws Exception{
         //����chromedriver�Ļ�������·��
         System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
         //����chromedriver����
         WebDriver driver=new ChromeDriver();
         //ʹ�������
         driver.manage().window().maximize();
         
         //��ȡurl
         driver.get("http://fqsso.591iq.com.cn/login?flag=forward");
         
         //By id��ȡԪ�� �ı������, �����˺������, ���¼��ť��¼    
         driver.findElement(By.id("userName")).sendKeys("admin");
         driver.findElement(By.id("userPwd")).sendKeys("fq123456");
         Thread.sleep(1000);
         driver.findElement(By.id("loginBtn")).click();
         //��ҳ��ͣ��2��
         Thread.sleep(2000);
         
         driver.get("http://fqbase.591iq.com.cn/admin/main.do");         
         //��ҳ��ͣ��2��
         Thread.sleep(2000);
         
         //�����Ա����˵�
         driver.findElement(By.id("50274")).click();
         Thread.sleep(2000);
         
         //���ѧ������˵�
         driver.findElement(By.id("50277")).click();
         //��ҳ��ͣ��2��
         Thread.sleep(2000);
         
         //��ѧ������ҳ��
//       driver.get("http://fqbase.591iq.com.cn/student/student!initfun.do?initFunId=50277");   
//       Thread.sleep(1000);
         
         //��web Ӧ���о���������frame Ƕ��ҳ���Ӧ�ã�ҳWebDriver ÿ��ֻ����һ��ҳ����ʶ��Ԫ�أ���  ��frame Ƕ���ڵ�ҳ���ϵ�Ԫ�أ�ֱ�Ӷ�λ�Ƕ�λ�Ƕ�λ�����ġ����ʱ�����Ҫͨ��switch_to_frame(), ��������ǰ��λ�������л���frame �
         driver.switchTo().frame("tab-contentiframe50277");
         
         List<WebElement> menus4 = driver.findElements(By.cssSelector("#operation-btn-group a"));
//         System.out.println(" menus4.size()  = "+ menus4.size() );
         //���������Ա��ť
         WebElement desiredMenu4 = menus4.get(0);
         desiredMenu4.click();
         //��ҳ��ͣ��2��
         Thread.sleep(2000);
         
         driver.findElement(By.name("educationNumber")).sendKeys("10000045");
         driver.findElement(By.cssSelector(".modal-dialog input[name='studentNumber']")).sendKeys("ѧ��045");
         driver.findElement(By.cssSelector(".modal-dialog input[name='name']")).sendKeys("����03");
         driver.findElement(By.name("mobilePhone")).sendKeys("13000000005");
         
         driver.findElement(By.name("realNamePinyin")).sendKeys("realNamePinyin");
         driver.findElement(By.name("idCardNumber")).sendKeys("350101199001012333");
         driver.findElement(By.name("country")).sendKeys("china");
         driver.findElement(By.name("nativePlace")).sendKeys("����");
         
         //ѡ����ʱ��--������ڿؼ���readonly����  
         JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
         //remove readonly attribute  
         removeAttribute.executeScript("var setDate=document.getElementsByName(\"enrollmentYear\")[0];setDate.removeAttribute('readonly');") ;  
         driver.findElement(By.name("enrollmentYear")).sendKeys("2018-01-01");

         driver.findElement(By.name("national")).sendKeys("����");
         driver.findElement(By.name("seatNumber")).sendKeys("1001");
         
         Thread.sleep(2000);
         
         //��� ���� 
         driver.findElement(By.id("add-msg")).click();
         Thread.sleep(5000);
         
         driver.close();
         driver.quit();//quit()�����ر������
  }
	 
}
