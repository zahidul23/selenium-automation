package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends PageObject {

	@FindBy(css = "#contact_form [name=\'first_name\']")
	private WebElement fNameInput;

	@FindBy(css = "#contact_form  [name=\'last_name\']")
	private WebElement lNameInput;

	@FindBy(css = "#contact_form  [name=\'email\']")
	private WebElement emailInput;

	@FindBy(css = "#contact_form  [name=\'message\']")
	private WebElement msgInput;

	@FindBy(css = "#form_buttons [type=\'submit\']")
	private WebElement submitBtn;

	@FindBy(css = "#form_buttons [type=\'reset\']")
	private WebElement resetBtn;

	private static String url = "http://webdriveruniversity.com/Contact-Us/contactus.html";

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	public void inputFirstName(String fName) {
		this.fNameInput.sendKeys(fName);
	}

	public void inputLastName(String lName) {
		this.lNameInput.sendKeys(lName);
	}

	public void inputEmail(String email) {
		this.emailInput.sendKeys(email);
	}

	public void inputMessage(String msg) {
		this.msgInput.sendKeys(msg);
	}

	public void resetFields() {
		this.resetBtn.click();
	}

	public void submitFields() {
		this.submitBtn.click();
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
	}

	public boolean successfulSubmit() {
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().equals("http://webdriveruniversity.com/Contact-Us/contact-form-thank-you.html")) {
			return true;
		} else {
			return false;
		}
	}
	
}
