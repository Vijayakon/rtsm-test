package Pages;

import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {

 // Locating elements using XPath
    WebDriver driver;
	@FindBy(xpath = "//input[@id='txtLogin']")
   
    private WebElement usernameField; 
    @FindBy(xpath = "//input[@id='txtPassword']") 
    private WebElement passwordField; 
    @FindBy(xpath = "//input[@id='btnLogin']") 
    private WebElement loginButton;
    
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
    	passwordField.sendKeys(password);
    }

    public void clickLogin() {
         loginButton.click();
    }
}
