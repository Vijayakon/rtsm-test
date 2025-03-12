package Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectInformationPage {
	WebDriver driver;

	@FindBy(css = "[id='trView'] a[id='lnkView2']")
	private WebElement viewinformation;

	public SubjectInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getSubjectInformatio() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver.findElements(By.cssSelector(".paneltable tr .leftval")).stream().map(WebElement::getText)
				.collect(Collectors.toList());
	}
}
