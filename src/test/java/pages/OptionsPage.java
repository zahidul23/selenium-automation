package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;

public class OptionsPage extends PageObject {
	
	@FindBy(id="dropdowm-menu-1")
	private WebElement menu1;
	Select dropdown1 = new Select(menu1);

	@FindBy(id="dropdowm-menu-2")
	private WebElement menu2;
	Select dropdown2 = new Select(menu2);

	@FindBy(id="dropdowm-menu-3")
	private WebElement menu3;
	Select dropdown3 = new Select(menu3);
	
	@FindBy(css="#checkboxes [type=\'checkbox\']")
	private List<WebElement> checkboxes;
	
	@FindBy(css="#radio-buttons input")
	private List<WebElement> radios;

	public OptionsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void selectPreferences(String primaryLanguage, String enviornment, String secondaryLanguage ) {
		dropdown1.selectByValue(primaryLanguage);
		dropdown2.selectByValue(enviornment);
		dropdown3.selectByValue(secondaryLanguage);
		
	}
	
	public void selectCheckBox(String option) {
		for (WebElement box : checkboxes) {
			if (box.getAttribute("value").equals(option) && !box.isSelected()){
				box.click();
			}
		}
	}
	
	public void deselectCheckBox(String option) {
		for (WebElement box : checkboxes) {
			if (box.getAttribute("value").equals(option) && box.isSelected()){
				box.click();
			}
		}
	}
	
	public void selectColor(String color) {
		for (WebElement radio : this.radios) {
			if (radio.getAttribute("value").equals(color)){
				radio.click();
			}
		}
	}
}
