package pages;

import java.util.List;
import java.awt.Rectangle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;


public class ActionsPage extends PageObject{

	@FindBy(id="draggable")
	private WebElement dragBox;
	
	@FindBy(id="droppable")
	private WebElement dropBox;
	
	@FindBy(xpath="//*[@id=\"droppable\"]/p/b/")
	private WebElement dropBoxText;
	
	@FindBy(id="double-click")
	private WebElement doubleClickBox;

	@FindBy(xpath="//*[@id=\"double-click\"]/h2")
	private WebElement doubleClickBoxText;
	
	@FindBy(id="click-box")
	private WebElement holdClickBox;
	
	
	@FindBy(css="div#div-hover > *")
	private List<WebElement> hoverButtons;
	
	Actions actions;
	
	public ActionsPage(WebDriver driver) {
		super(driver);
		actions = new Actions(this.driver);
	}
	
	public void dragAndDrop() {
		actions.dragAndDrop(this.dragBox, this.dropBox).build().perform();
	}
	
	public String dropText() {
		return this.dropBoxText.getText();
	}
	
	public void doubleClick() {
		actions.doubleClick(this.doubleClickBox).build().perform();
	}
	
	public void hoverThrough() {
		for (WebElement hb : this.hoverButtons) {
			actions.moveToElement(hb).build().perform();
			List<WebElement> listAlerts = hb.findElements(By.xpath("div/a"));
			for (WebElement alertLink : listAlerts) {
				alertLink.click();
				Alert alert = this.driver.switchTo().alert();
				alert.accept();
				actions.moveToElement(hb).build().perform();
			}
			
		}
		
	}
	
	public void holdAndClick() {
		actions.clickAndHold(this.holdClickBox).build().perform();
	}
	
	public void releaseClick() {
		actions.release().build().perform();
	}
	
	public String getHoldBoxText() {
		return this.holdClickBox.getText();
	}
	
	public String getDropBoxText() {
		return this.getDropBoxText();
	}

	public String getDoubleClickBoxText() {
		return this.getDoubleClickBoxText();
	}
	
	public boolean isBoxOnTarget() {
		Rectangle dropBoxRectangle = convertToAWTRectangle(this.dropBox.getRect());
		Rectangle dragBoxRectangle = convertToAWTRectangle(this.dragBox.getRect());
		
		return dropBoxRectangle.contains(dragBoxRectangle);
	}
	
	public boolean isLinkBoxDisplayed() {
		return this.hoverButtons.get(2).findElement(By.xpath("div")).isDisplayed();
	}
	
	private Rectangle convertToAWTRectangle(org.openqa.selenium.Rectangle r) {
		return new Rectangle(r.x, r.y, r.width, r.height);
		
	}

	public String getDoubleClickBoxColor() {
		return Color.fromString(this.doubleClickBox.getCssValue("background-color")).asHex();
	}
}
