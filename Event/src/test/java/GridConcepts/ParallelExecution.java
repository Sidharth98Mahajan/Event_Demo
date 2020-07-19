package GridConcepts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {
	Capabilities cap;
	static WebDriver driver;
	@Parameters("browser")
	    @Test
        public void setUp() throws MalformedURLException {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
	}
		
		@Test
		public void browserLaunch(String browserName) throws MalformedURLException{

	    if(browserName.equalsIgnoreCase("chrome")){
		String driverPath = System.getProperty("user.dir") 
				+"\\src\\Drivers\\chromedriver.exe";                       //To get path of driver
	    System.setProperty("webdriver.chrome.driver",driverPath );         //Set Property of ChromeBrowser
	    driver=new ChromeDriver();	 
	    }else if(browserName.equalsIgnoreCase("firefox")){
			String driverPath = System.getProperty("user.dir") 
					+"\\src\\Drivers\\geckodriver.exe";                    //To get path of driver
	    System.setProperty("webdriver.gecko.driver",driverPath );          //Set Property of Firefox Browser
	    driver=new FirefoxDriver();	                                       //To launch Browser
		}

		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.facebook.com/");
			
}
}

