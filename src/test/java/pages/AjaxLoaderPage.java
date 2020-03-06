package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxLoaderPage extends PageObject{

	@FindBy(id="loader")
	private WebElement loader;
	
	@FindBy(id="myDiv")
	private WebElement divBlock;
	
	@FindBy(id="button1")
	private WebElement button1;
	
	@FindBy(id="myModalClick")
	private WebElement popup;
	
	@FindBy(css="#myModalClick div div h4")
	private WebElement popupHeader;
	
	
	public AjaxLoaderPage(WebDriver driver) {
		super(driver);
	}

	public void waitForLoader() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}
	
	public void clickButton() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(divBlock));
		button1.click();
	}
	
	public boolean popupHasText(String text) {
		if (this.popupHeader.getText().equals(text)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void waitForPopup() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(popup));
	}
	
}
