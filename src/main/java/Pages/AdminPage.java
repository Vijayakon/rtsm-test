package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdminPage {

	WebDriver driver;
	@FindBy(xpath = "//a[@href= \"#\"][1]")
	private WebElement adminTab;

	@FindBy(xpath = "//div[@id = \"navbar_navMenun4Items\"]/table")
	private WebElement inventoryTable;

	@FindBy(xpath = "//tr[@id= \"navbar_navMenun12\"]")
	private WebElement inventory;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void mouseOverAdmin() {

		Actions actions = new Actions(driver);

		// Perform mouse hover
		actions.moveToElement(adminTab).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1200));
		wait.until(ExpectedConditions.visibilityOf(inventoryTable));
		actions.moveToElement(inventoryTable).perform();

	}

	public void clickInventory() {
		inventory.click();

	}

}
