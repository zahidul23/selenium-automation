package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ScrollingPage extends PageObject{
	@FindBy(id="zone1")
	private WebElement topZone;

	@FindBy(id="zone2")
	private WebElement leftEntryZone;

	@FindBy(id="zone3")
	private WebElement rightEntryZone;

	@FindBy(id="zone4")
	private WebElement coorZone;
	
	Actions actions;

	public ScrollingPage(WebDriver driver) {
		super(driver);
		actions = new Actions(this.driver);
	}
	
	public void scrollUntilVisible(WebElement e) {
		((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", e);
	}
	
	public void enterTopZone() {
		actions.moveToElement(this.topZone).build().perform();
	}
	
	public void enterleftEntryZone() {
		actions.moveToElement(this.leftEntryZone).build().perform();
	}
	
	public void enterRightEntryZone() {
		actions.moveToElement(this.leftEntryZone).build().perform();
	}
	
	public void enterCoorZone() {
		actions.moveToElement(this.coorZone).build().perform();
	}
	
	public String getDisplayedCoordinates() {
		return this.coorZone.getText();
	}
	
	public String getTopZoneText() {
		return this.topZone.getText();
	}
	
	public String getLeftZoneText() {
		return this.leftEntryZone.getText();
	}
	public String getRightZoneText() {
		return this.leftEntryZone.getText();
	}

	
}
