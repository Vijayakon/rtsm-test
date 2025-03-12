package VijayaThota.VeevaAuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import java.util.Properties;

import Pages.LoginPage;
import Pages.SubjectInformationPage;
import Pages.SubjectPage;
import Pages.AdminPage;

public class LoginTestNew {
	private WebDriver driver;
	private LoginPage loginPage;
	private AdminPage adminPage;
	private SubjectPage subjectPage;
	private SubjectInformationPage subjectInformationPage;
	private String username = "";
	private String password = "";
	// private LoginPage

	@BeforeClass
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		String filePath = "src/main/Config.Properties";

		// Create Properties object
		Properties properties = new Properties();

		String url = "";

		try (FileInputStream fileInput = new FileInputStream(filePath)) {
			// Load properties file
			properties.load(fileInput);
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			url = properties.getProperty("url");
			// Print values
			System.out.println("Username: " + username);
			System.out.println("Password: " + password);
			System.out.println("URL: " + url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(url); // Replace with actual URL
		loginPage = new LoginPage(driver);
		adminPage = new AdminPage(driver);
		subjectPage = new SubjectPage(driver);
		subjectInformationPage = new SubjectInformationPage(driver);

	}

	@Test(priority = 1)
	public void testValidLogin() {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Verify successful login by checking URL or page title
		Assert.assertTrue(driver.getTitle().contains("Subjects"));
	}

	@Test(priority = 2)
	public void subjectPageValidation() {
		// testValidLogin();
		subjectPage.clickMenuOption();
		subjectPage.switchToPopUp();
		subjectPage.clickViewInformation();
		subjectPage.switchToPopUp();
		System.out.println(subjectInformationPage.getSubjectInformatio());
	}

	@Test(priority = 3)
	public void adminTab() {
		adminPage.mouseOverAdmin();
		adminPage.clickInventory();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Takescreenshot();
	}

	private void Takescreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		// Define the destination path
		File destFile = new File("C:\\Screenshots\\screenshot.png");
		// Save the screenshot
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved at: " + destFile);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
