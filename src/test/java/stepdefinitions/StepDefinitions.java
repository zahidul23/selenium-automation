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
	private DatepickerPage datePage;
	private ActionsPage actionsPage;
	private ScrollingPage scrollingPage;

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
	@Given("^user is on datepicker page$")
	public void user_is_on_the_datepicker_page() throws Throwable {
		getDriver().get("http://webdriveruniversity.com/Datepicker/index.html");
		datePage = new DatepickerPage(getDriver());
		
	}

	@When("^user inputs date (\\d*-\\d*-\\d*)$")
	public void user_inputs_date(String date) throws InterruptedException {
		datePage.inputDate(date);
	}
	
	@Then("^selected date matches (\\d*-\\d*-\\d*)$")
	public void selected_date_matches(String date) {
		assertEquals(date, datePage.getDate());
	}
	
	@Then("^selected date does not match (\\d*-\\d*-\\d*)$")
	public void selected_date_does_not_match(String date) {
		assertNotEquals(date, datePage.getDate());
	}
	
    @Given("^user is on actions page$")
    public void user_is_on_actions_page() {
    	getDriver().get("http://webdriveruniversity.com/Actions/index.html");
		actionsPage = new ActionsPage(getDriver());
    }

    @When("^user drags and drops the element$")
    public void user_drags_and_drops_the_element() {
    	actionsPage.dragAndDrop();
    }

    @When("^user double clicks on target$")
    public void user_double_clicks_on_target() {
    	actionsPage.doubleClick();
    }

    @When("^user hovers through boxes$")
    public void user_hovers_through_boxes() {
    	actionsPage.hoverThrough();
    }
    
    @When("^user clicks and holds target$")
    public void user_clicks_and_holds_target() {
    	actionsPage.holdAndClick();
    }

    @Then("^the element is located in the target$")
    public void the_element_is_located_in_the_target() {
    	assertTrue(actionsPage.isBoxOnTarget());
    }

    @Then("^background color of target has changed$")
    public void background_color_of_target_has_changed() {
    	assertEquals("#93CB5A", actionsPage.getDoubleClickBoxColor().toUpperCase());
    }

    @Then("^link boxes will be displayed$")
    public void link_boxes_will_be_displayed() {
    	assertTrue(actionsPage.isLinkBoxDisplayed());
    }

    @Then("^box text will read Well done$")
    public void box_text_will_read_well_done()  {
    	assertEquals("Well done! keep holding that click now.....", actionsPage.getHoldBoxText());
    }
    
    
    @Given("^user is on scrolling page$")
    public void user_is_on_scrolling_page() throws Throwable {
		getDriver().get("http://webdriveruniversity.com/Scrolling/index.html");
		scrollingPage = new ScrollingPage(getDriver());
    }

    @When("^user hovers over top zone$")
    public void user_hovers_over_top_zone() throws Throwable {
    	scrollingPage.enterTopZone();
    }

    @Then("^text will read Well done for scrolling$")
    public void text_will_read_well_done_for_scrolling() throws Throwable {
    	assertEquals("Well done for scrolling to me!", scrollingPage.getTopZoneText());
    }
    
    @When("^user hovers over side zones$")
    public void user_hovers_over_side_zones() throws Throwable {
        scrollingPage.enterleftEntryZone();
        scrollingPage.enterRightEntryZone();
    }

    @When("^user hovers over bottom zone$")
    public void user_hovers_over_bottom_zone() throws Throwable {
    	scrollingPage.enterCoorZone();
    }

    @Then("^zone text will display entered count$")
    public void zone_text_will_display_entered_count() throws Throwable {
        assertEquals("1 Entries", scrollingPage.getLeftZoneText());
        assertEquals("1 Entries", scrollingPage.getRightZoneText());
    }

    @Then("^text will show entry coordinate$")
    public void text_will_show_entry_coordinate() throws Throwable {

        assertEquals("X: 768Y: 767", scrollingPage.getDisplayedCoordinates());
    }

	
	@When("^user clicks ajax loader button$")
	public void user_clicks_ajax_loader_button() {
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
