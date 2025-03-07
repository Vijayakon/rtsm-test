package VijayaThota.VeevaAuto;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Pages.LoginPage;


public class LoginTest {
  private WebDriver driver;
  private LoginPage loginPage;
  private  String username="";
  private String password="";
  //private LoginPage 

  @BeforeMethod
  public void setUp() {
      //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
   
   String filePath = "src/main/Config.Properties"; 
      
      // Create Properties object
      Properties properties = new Properties();
      
      String url="";
     
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
      
  }
  @Test
  public void testValidLogin() {
     System.out.println("Hello");
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

  @Test
  public void SwtichtoPopup() {
	  
	  }
  
  @AfterMethod
  public void tearDown() {
      driver.quit();
  }
  }

