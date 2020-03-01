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
    
    @When("^user selects options$")
    public void user_selects_options() throws Throwable {
    	driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    	OptionsPage optionsPage = new OptionsPage(driver);
    	
    	optionsPage.selectPreferences("python", "eclipse", "javascript");
    	
    	optionsPage.deselectCheckBox("option-3");
    	optionsPage.selectCheckBox("option-1");
    	optionsPage.selectColor("orange");
    	optionsPage.selectColor("pink");
    }
    
    @When("^user clicks popup button$")
    public void user_clicks_popup_button() throws Throwable {
    	driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
    	AlertsPage alertsPage = new AlertsPage(driver);
    	
    	alertsPage.clickjsButton();
    	alertsPage.clickModalButton();
    	alertsPage.clickjsConfirmButton(true);
    	alertsPage.clickjsConfirmButton(false);
    	alertsPage.clickAjaxButton();
    }
}
