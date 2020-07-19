package MouseHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperationsHandling {
	WebDriver driver;
	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/");
	}
	
	
	@Test(priority=0)
    public void clickMenu() {
    	Actions action = new Actions(driver); 
    	WebElement element = driver.findElement(By.xpath("//ul[@id='primary-menu']//li[contains(@class,'menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-26284 has-children')]"
    			+ "//span[contains(@class,'menu-text')][contains(text(),'Tutorial')]"));
      action.moveToElement(element).click().perform();//Moving to Tutorial
}
	
	@Test(priority=1)
	public void subMenu() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver); 
		WebElement subMenu=driver.findElement(By.xpath("//ul[@id='primary-menu']//li//ul//li//a//span//span[contains(text(),'QA Practices')]"));
		action.moveToElement(subMenu).perform();//Move to Tutorial-->QA practices
		
		WebElement subMenuST=driver.findElement(By.xpath("//ul[@id='primary-menu']//li//ul//li//ul//li//a//span//span[contains(text(),'Software Testing')]"));
		subMenuST.click();//Move to Tutorial-->QA practices-->Software Testing(click)
		driver.navigate().back();
	}
	
	@Test(priority=2)
	public void contextClick() throws InterruptedException{
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement contextclick = driver.findElement(By.xpath("//a[contains(text(),'Enroll Your Self')]"));
		action.contextClick(contextclick).perform();//Context Click/Right click on "Enroll Your Self" Button
	}
	
	@Test(priority=3)
	public void dragAndDrop() throws InterruptedException{
		Thread.sleep(5000);
		driver.get("https://demoqa.com/droppable");
		Actions action = new Actions(driver);
		WebElement initial=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		action.dragAndDrop(initial, target).perform();
		}
}
