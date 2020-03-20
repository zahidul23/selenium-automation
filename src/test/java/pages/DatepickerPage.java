package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatepickerPage extends PageObject {
	
	@FindBy(xpath="//*[@id=\"datepicker\"]/input")
	private WebElement dateInput;
	
	public DatepickerPage(WebDriver driver) {
		super(driver);
	}
	
	public String getDate() {
		return this.dateInput.getAttribute("value");
	}
	
	
	public void inputDate(String date) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)this.driver;  
		js.executeScript("document.getElementsByClassName('form-control')[0].removeAttribute('readonly');", this.dateInput);
		this.dateInput.clear();
		this.dateInput.sendKeys(date);
		this.dateInput.sendKeys(Keys.TAB);
	}

	
}
