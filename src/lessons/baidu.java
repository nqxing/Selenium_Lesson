package lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baidu {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		//��ʼ��һ��chrome�����ʵ����ʵ�����ƽ�driver
		WebDriver driver = new ChromeDriver();
		//��󻯴���
		driver.manage().window().maximize();
		
		// �򿪲��Ե�ַ
		driver.get("http://www.baidu.com");
		
		//getTitle()��ȡ��ǰҳ��title��ֵ        
        String title = driver.getTitle();
        
        if(title.equals("�ٶ�һ�£����֪��")){
        	System.out.println("����ͨ����");
        }else{
        	System.out.println("����ʧ�ܣ�");
        }
        
        //�رղ��˳������  
        driver.quit();  

		
	}
}
