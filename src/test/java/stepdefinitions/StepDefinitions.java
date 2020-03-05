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
import static org.junit.Assert.*;

public class StepDefinitions {
	private WebDriver driver;
	private ContactPage contactPage;
	private OptionsPage optionsPage;
	
	@Before
	public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
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
    
    @Given("^user is on contact us page$")
    public void user_is_on_contact_us_page() throws Throwable {
    	driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
    	contactPage = new ContactPage(driver);
    }

    @When("^user submits form (\\S+) (\\S+) (\\S+) ([\\s\\S]*)$")
    public void user_submits_form(String firstname, String lastname, String email, String message) throws Throwable {
        contactPage.inputFirstName(firstname);
        contactPage.inputLastName(lastname);
        contactPage.inputEmail(email);
        contactPage.inputMessage(message);
        
        contactPage.submitFields();
    }


    @Then("^user is shown thank you response$")
    public void user_is_shown_thank_you_response() throws Throwable {
        assertTrue(contactPage.successfulSubmit());
    }

    @Then("^user is shown error for invalid input$")
    public void user_is_shown_error_for_invalid_input() throws Throwable {
    	assertFalse(contactPage.successfulSubmit());
    }
    
    @Given("^user is on options page$")
    public void user_is_on_options_page() throws Throwable {
    	driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    	optionsPage = new OptionsPage(driver);
    }

    @When("^user selects languages (\\S+) (\\S+) (\\S+)$")
    public void user_selects_languages(String primarylanguage, String enviornment, String secondarylanguage) throws Throwable {
    	optionsPage.selectPreferences(primarylanguage, enviornment, secondarylanguage);
    }

    @When("^user selects color (\\S+)$")
    public void user_selects_color(String color) throws Throwable {
    	optionsPage.selectColor(color);
    }

    @When("^user selects options (\\S+)$")
    public void user_selects_options(String checkboxes) throws Throwable {
    	optionsPage.resetAllCheckBox();
    	String[] checkboxOptions = checkboxes.split(",");
    	
    	for (String checkboxOption : checkboxOptions) {
    		String option = "option" + checkboxOption;
    		optionsPage.selectCheckBox(option);
    	}
    	
    }
}
