package AlertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertBoxHandling {
	WebDriver driver;
@BeforeClass
public void browserLaunch() {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.get("https://demoqa.com/alerts");
}
	
@Test(priority=0)
public void alertBox() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.id("alertButton")).click();
	Alert alt= driver.switchTo().alert();
	String actualmsg=alt.getText();//To get Text
	String expectedmsg="You clicked a button";
	Assert.assertEquals(actualmsg, expectedmsg);
	Thread.sleep(3000);
    alt.accept();//Click on OK Button
}


@Test(priority=1)
public void confirmBox() throws InterruptedException {
	driver.findElement(By.id("confirmButton")).click();
	Alert alt= driver.switchTo().alert();
	String actualmsg=alt.getText();//To get text
	String expectedmsg="Do you confirm action?";
	Assert.assertEquals(actualmsg, expectedmsg);
	Thread.sleep(3000);
    alt.accept();//Click on Cancel Button
}

@Test(priority=3)
public void promptBox() throws InterruptedException {
	driver.findElement(By.id("promtButton")).click();
	Alert alt= driver.switchTo().alert();
	String actualmsg=alt.getText();//To get text
	String expectedmsg="Please enter your name";
	Assert.assertEquals(actualmsg, expectedmsg);
	Thread.sleep(3000);
    alt.sendKeys("Prompt");//Click on Cancel Button
    alt.accept();
}
}
