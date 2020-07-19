package WindowHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsOperations {
	WebDriver driver;
	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		}


   @Test
   public void clickWindow(){
   WebElement elm=driver.findElement(By.id("windowButton"));
   elm.click();
   //get Parent Window Id
   String parentWindow=driver.getWindowHandle();
   //get all windows Id
   Set<String> handles=driver.getWindowHandles();
   //remove parent Id from set
   handles.remove(parentWindow);
   System.out.println(handles);
   Iterator<String> itr=handles.iterator();
   String childWindow=itr.next();
   
   String current_Url=driver.getCurrentUrl();
   System.out.println("Current URL is: "+current_Url);
   //Switch to child window
   driver.switchTo().window(childWindow);

   String child_current_Url=driver.getCurrentUrl();
   System.out.println("Current URL is: " +child_current_Url);
   String msg=driver.findElement(By.id("sampleHeading")).getText();
   driver.switchTo().window(parentWindow);
   System.out.println("Title-" +driver.getTitle());
}
}
