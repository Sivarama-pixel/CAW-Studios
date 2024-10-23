package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

	// declaration
	@FindBy(xpath="//summary[text()='Table Data']")
	private WebElement Tabledata;

	@FindBy(xpath="//textarea[@id='jsondata']")
	private WebElement JsonTextbox;
	
	@FindBy(xpath="//button[@id='refreshtable']")
	private WebElement RefreshButton;

	public WebElement getRefreshButton() {
		return RefreshButton;
	}

	public WebElement getJsonTextbox() {
		return JsonTextbox;
	}

	public WebElement getTabledata() {
		return Tabledata;
	}

	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void performclick() {
		Tabledata.click();
		}
	
	public void jsontextBox(CharSequence json) {
		JsonTextbox.clear();
		JsonTextbox.sendKeys(json);
	}
	
	public void refreshbtn() {
		RefreshButton.click();
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
