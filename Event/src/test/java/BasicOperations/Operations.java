package BasicOperations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Operations {
	WebDriver driver;
	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		}

//DOWNLOAD FILE	
@Test(priority=1)
public void downloadFile() {
WebElement elm=driver.findElement(By.id("downloadButton"));
elm.click();
}

  //UPLOAD A FILE
  @Test(priority=2)
  public void uploadFile() throws InterruptedException {
  Thread.sleep(2000);
  WebElement elm2=driver.findElement(By.id("uploadFile"));
  elm2.sendKeys("C:\\Users\\Subham\\Desktop\\Testing Purpose");
  }
	
    //CAPTURE SCREENSHOT
    @Test(priority=3)
    public void screenShot() throws IOException, InterruptedException {
    Thread.sleep(3000);
    File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //Location Where screenshot is saved
    FileUtils.copyFile(srcFile,new File("F:\\screenshot.png"));
    System.out.println("SceenShot taken successfully");
    }
    
	   //SCROLL PAGE DOWN
       @Test(priority=4)
       public void pageScroll() throws InterruptedException {
       Thread.sleep(4000);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,575)", "");
       }
       
              //SLIDER	
	          @Test(priority=5)
		      public void testSliderOperation() throws InterruptedException {
	          Thread.sleep(5000);
		      driver.get("https://demoqa.com/slider");
			  WebElement slider=driver.findElement(By.className("range-slider range-slider--primary"));
			  Actions action=new Actions(driver);
			  action.dragAndDropBy(slider, 626, 253).release().build().perform();
			  slider.click();
			
			  //X OFFSET VALUE , Y OFFSET VALUE 632,256
		      }
	}

