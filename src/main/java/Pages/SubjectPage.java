package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubjectPage {
	WebDriver driver;
	@FindBy(css = "a[title='Menu']")
	private WebElement ellipsis;

	@FindBy(css = "[id='trView'] a[id='lnkView2']")
	private WebElement viewinformation;

	public SubjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMenuOption() {
		try {
			ellipsis.click();
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToPopUp() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	public void clickViewInformation() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		viewinformation.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
