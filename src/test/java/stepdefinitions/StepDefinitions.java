package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
	private WebDriver driver;
	
	@Before
	public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "G:\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600,900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void shutDownDriver() {
		driver.close();
	}
	
    @When("^user clicks buttons$")
    public void user_clicks_buttons() throws Throwable {
    	driver.get("http://webdriveruniversity.com/Click-Buttons/index.html");
    	ButtonsPage buttonsPage = new ButtonsPage(driver);
    	
    	buttonsPage.clickButton1();
    	buttonsPage.clickButton2();
    	buttonsPage.clickButton3();
    	
    }
}
