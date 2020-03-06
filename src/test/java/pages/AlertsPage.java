package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends PageObject {
	
	@FindBy(id="button1")
	private WebElement jsAlertButton;
	
	@FindBy(id="button2")
	private WebElement modalPopupButton;
	
	@FindBy(id="button3")
	private WebElement ajaxLoaderButton;
	
	@FindBy(id="button4")
	private WebElement jsConfirmAlertButton;
	
	@FindBy(id="myModal")
	private WebElement modalPopup;
	
	@FindBy(id="confirm-alert-text")
	private WebElement confirmText;
	
	
	public AlertsPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickjsButton() {
		this.jsAlertButton.click();
	}
	
	public void clickModalButton() {
		this.modalPopupButton.click();
	}

	public void closeModalPopup() {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(this.modalPopup));
		this.modalPopup.click();
		wait.until(ExpectedConditions.invisibilityOf(this.modalPopup));
	}
	public void clickjsConfirmButton() {
		this.jsConfirmAlertButton.click();
	}
	
	public void confirmjsPopup(boolean accept) {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		if(accept) {
			alert.accept();
		}
		else {
			alert.dismiss();
		}
	}
	
	public void clickAjaxButton() {
		this.ajaxLoaderButton.click();
	}

}
