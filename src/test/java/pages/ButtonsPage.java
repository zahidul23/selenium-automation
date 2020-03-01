package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ButtonsPage extends PageObject {
	@FindBy(xpath="//*[@id=\"button1\"]")
	private WebElement button1;
	
	@FindBy(css="span#button2")
	private WebElement button2;

	@FindBy(id="button3")
	private WebElement button3;
	
	
	public ButtonsPage(WebDriver driver) {
		super(driver);
	}

	
	public void clickButton1() {
		this.button1.click();
		closePopup(this.button1.getAttribute("data-target"));
	}
	
	public void clickButton2() {
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click()", this.button2);
		closePopup(this.button2.getAttribute("data-target"));
	}
	
	public void clickButton3() {
		Actions builder = new Actions(this.driver);
		Action moveAndClick = builder.moveToElement(this.button3).click().build();
		moveAndClick.perform();
		closePopup(this.button3.getAttribute("data-target"));
	}
	
	public void closePopup(String popupID) {
		popupID = popupID.replace("#", "");
		WebElement popup = this.driver.findElement(By.id(popupID));
		WebDriverWait wait  = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.attributeToBe(popup, "style", "display: block;"));
		WebElement closeButton = popup.findElement(By.xpath("div/div/div[3]/button"));
		closeButton.click();
		wait.until(ExpectedConditions.attributeToBe(popup, "style", "display: none;"));
	}
}
