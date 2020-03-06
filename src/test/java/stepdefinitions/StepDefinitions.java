package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class StepDefinitions extends BaseClass {
	private ContactPage contactPage;
	private OptionsPage optionsPage;
	private AlertsPage alertsPage;
	private AjaxLoaderPage ajaxPage;

	@Before
	public void startDriver() throws MalformedURLException {
		setUp();
	}

	@After
	public void closeDriver() {
		tearDown();
	}

	@When("^user clicks buttons$")
	public void user_clicks_buttons() throws Throwable {
		getDriver().get("http://webdriveruniversity.com/Click-Buttons/index.html");
		ButtonsPage buttonsPage = new ButtonsPage(getDriver());

		buttonsPage.clickButton1();
		buttonsPage.clickButton2();
		buttonsPage.clickButton3();

	}

	@When("^user clicks popup button$")
	public void user_clicks_popup_button() throws Throwable {

		alertsPage.clickjsButton();
		alertsPage.confirmjsPopup(true);
		alertsPage.confirmjsPopup(false);
	}

	@Given("^user is on contact us page$")
	public void user_is_on_contact_us_page() throws Throwable {
		getDriver().get("http://webdriveruniversity.com/Contact-Us/contactus.html");
		contactPage = new ContactPage(getDriver());
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
		getDriver().get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		optionsPage = new OptionsPage(getDriver());
	}

	@When("^user selects languages (\\S+) (\\S+) (\\S+)$")
	public void user_selects_languages(String primarylanguage, String enviornment, String secondarylanguage)
			throws Throwable {
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

	@Given("^user is on the popups page$")
	public void user_is_on_the_popups_page() throws Throwable {
		getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");
		alertsPage = new AlertsPage(getDriver());
	}

	@When("^user clicks ajax loader button$")
	public void user_clicks_ajax_loader_button() throws Throwable {
		alertsPage.clickAjaxButton();
	}

	@Then("^user is taken to the loading page")
	public void user_is_taken_to_loading_page() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.urlToBe("http://webdriveruniversity.com/Ajax-Loader/index.html"));

		ajaxPage = new AjaxLoaderPage(getDriver());
	}

	@When("^user clicks js popup button$")
	public void user_clicks_js_popup_button() throws Throwable {
		alertsPage.clickjsButton();
	}

	@When("^user clicks modal popup button$")
	public void user_clicks_modal_popup_button() throws Throwable {
		alertsPage.clickModalButton();
	}

	@Then("^popup reads well done for waiting$")
	public void popup_reads_well_done_for_waiting() throws Throwable {
		ajaxPage.waitForPopup();
		assertTrue(ajaxPage.popupHasText("Well Done For Waiting....!!!"));
	}

	@Then("^user closes js popup$")
	public void user_closes_js_popup() throws Throwable {
		alertsPage.confirmjsPopup(true);
	}

	@Then("^user closes modal popup$")
	public void user_closes_modal_popup() throws Throwable {
		alertsPage.closeModalPopup();
	}

	@And("^user waits for loader to complete$")
	public void user_waits_for_loader_to_complete() throws Throwable {
		ajaxPage.waitForLoader();
	}

	@And("^user clicks green button$")
	public void user_clicks_green_button() throws Throwable {
		ajaxPage.clickButton();
	}
}
