package lessons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baidu {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", ".\\Tools\\chromedriver_v67.exe");
		//初始化一个chrome浏览器实例，实例名称叫driver
		WebDriver driver = new ChromeDriver();
		//最大化窗口
		driver.manage().window().maximize();
		
		// 打开测试地址
		driver.get("http://www.baidu.com");
		
		//getTitle()获取当前页面title的值        
        String title = driver.getTitle();
        
        if(title.equals("百度一下，你就知道")){
        	System.out.println("测试通过！");
        }else{
        	System.out.println("测试失败！");
        }
        
        //关闭并退出浏览器  
        driver.quit();  

		
	}
}
