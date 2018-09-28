package lessons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author 余运基
 * @date 2018-05-25
 * selenium for Chrome
 * 1、登录数字化校园平台，
 * 2、打开学生信息页面
 * 3、填写学生信息
 * 4、保存学生信息
 * 
 */
public class selenium_iq {

	 public static void main(String[] args) throws Exception{
         //设置chromedriver的环境变量路径
         System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
         //创建chromedriver对象
         WebDriver driver=new ChromeDriver();
         //使窗体最大化
         driver.manage().window().maximize();
         
         //获取url
         driver.get("http://fqsso.591iq.com.cn/login?flag=forward");
         
         //By id获取元素 文本输入框, 输入账号密码后, 点登录按钮登录    
         driver.findElement(By.id("userName")).sendKeys("admin");
         driver.findElement(By.id("userPwd")).sendKeys("fq123456");
         Thread.sleep(1000);
         driver.findElement(By.id("loginBtn")).click();
         //在页面停留2秒
         Thread.sleep(2000);
         
         driver.get("http://fqbase.591iq.com.cn/admin/main.do");         
         //在页面停留2秒
         Thread.sleep(2000);
         
         //点击人员管理菜单
         driver.findElement(By.id("50274")).click();
         Thread.sleep(2000);
         
         //点击学生管理菜单
         driver.findElement(By.id("50277")).click();
         //在页面停留2秒
         Thread.sleep(2000);
         
         //打开学生管理页面
//       driver.get("http://fqbase.591iq.com.cn/student/student!initfun.do?initFunId=50277");   
//       Thread.sleep(1000);
         
         //在web 应用中经常会遇到frame 嵌套页面的应用，页WebDriver 每次只能在一个页面上识别元素，对  于frame 嵌套内的页面上的元素，直接定位是定位是定位不到的。这个时候就需要通过switch_to_frame(), 方法将当前定位的主体切换了frame 里。
         driver.switchTo().frame("tab-contentiframe50277");
         
         List<WebElement> menus4 = driver.findElements(By.cssSelector("#operation-btn-group a"));
//         System.out.println(" menus4.size()  = "+ menus4.size() );
         //点击新增人员按钮
         WebElement desiredMenu4 = menus4.get(0);
         desiredMenu4.click();
         //在页面停留2秒
         Thread.sleep(2000);
         
         driver.findElement(By.name("educationNumber")).sendKeys("10000045");
         driver.findElement(By.cssSelector(".modal-dialog input[name='studentNumber']")).sendKeys("学号045");
         driver.findElement(By.cssSelector(".modal-dialog input[name='name']")).sendKeys("姓名03");
         driver.findElement(By.name("mobilePhone")).sendKeys("13000000005");
         
         driver.findElement(By.name("realNamePinyin")).sendKeys("realNamePinyin");
         driver.findElement(By.name("idCardNumber")).sendKeys("350101199001012333");
         driver.findElement(By.name("country")).sendKeys("china");
         driver.findElement(By.name("nativePlace")).sendKeys("籍贯");
         
         //选择建立时间--清除日期控件是readonly属性  
         JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
         //remove readonly attribute  
         removeAttribute.executeScript("var setDate=document.getElementsByName(\"enrollmentYear\")[0];setDate.removeAttribute('readonly');") ;  
         driver.findElement(By.name("enrollmentYear")).sendKeys("2018-01-01");

         driver.findElement(By.name("national")).sendKeys("汉族");
         driver.findElement(By.name("seatNumber")).sendKeys("1001");
         
         Thread.sleep(2000);
         
         //点击 保存 
         driver.findElement(By.id("add-msg")).click();
         Thread.sleep(5000);
         
         driver.close();
         driver.quit();//quit()方法关闭浏览器
  }
	 
}
