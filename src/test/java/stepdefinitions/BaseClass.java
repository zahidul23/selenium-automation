package stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	protected ThreadLocal<RemoteWebDriver> driver = null;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		driver = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");;
        capabilities.setPlatform(Platform.WINDOWS);
        
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        
        driver.set(new RemoteWebDriver(new URL("http://26.113.193.90:4444/wd/hub"), options));
		

        getDriver().manage().window().setSize(new Dimension(1600,900));
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
 
    @AfterClass
    public void tearDown(){
        getDriver().quit();
        driver.set(null);
 
    }
}
