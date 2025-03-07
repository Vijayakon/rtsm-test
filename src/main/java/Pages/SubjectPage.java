package Pages;

import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubjectPage {
	 // Locating elements using XPath
    WebDriver driver;
	@FindBy(xpath = "//table[@class='gridnormal']//tbody/tr[1]/td[1]")
	private WebElement ellipsis; 
    
	@FindBy(xpath = "//a[@id='lnkView2']")
	private WebElement viewinformation; 	
    
    public SubjectPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

   
    public void switchToPopUp()
    {
    	String mainWindowHandle = driver.getWindowHandle();
    	System.out.println("Hello1");
    	ellipsis.click();
    	// Get all window handles
    	Set<String> windowHandles = driver.getWindowHandles(); 
    	// Switch to the new window (it's not the main window) 
    	for (String handle : windowHandles) {
    		if (!handle.equals(mainWindowHandle)) 
    		{ 
    			driver.switchTo().window(handle);
    			System.out.println("Hello2");
    			try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			viewinformation.click();
    		break;
    		} 
    		}	
    }
}
