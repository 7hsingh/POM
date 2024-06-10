package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	    WebDriver driver;
	/*  WebElement email = driver.findElement(By.id("user-name"));
	WebElement pass =driver.findElement(By.id("password")) ;
	WebElement signInButton = driver.findElement(By.id("login-button"));
	WebElement emailErr = driver.findElement(By.xpath("//h3[@data-test='error']"));
	WebElement passErr = driver.findElement(By.xpath("//h3[@data-test='error']")) ;
	WebElement emailpassErr = driver.findElement(By.xpath("//h3[@data-test='error']")); */
	
	    
	    //PageFactory
	    
	    @FindBy (id = "user-name" )
	    public WebElement email;
	    
	    @FindBy (id = "password")
	    public WebElement pass;
	    
	    @FindBy (id = "login-button")
	    public WebElement signInButton;
	    
	    @FindBy (xpath = "//h3[@data-test='error']")
	    public WebElement emailErr;
	    
	    @FindBy( xpath = "//h3[@data-test='error']")
	    public WebElement passErr;
	    
	    @FindBy (xpath ="//h3[@data-test='error']")
	    public WebElement emailpassErr;
	
	public void openBrowser() throws IOException {
		FileInputStream fi = new FileInputStream("/Users/pardeeptank/Desktop/QA/selenium_workplace/BasicFramwork/prop.properties");
		Properties prop = new Properties();
		prop.load(fi);
	  
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equalsIgnoreCase("Firefox")) {
	     driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Chrome")){
		driver = new ChromeDriver();
		}else{
		 driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
	}
	
		public void openLoginPage() {
			
		 driver.get("https://www.saucedemo.com/");
	     driver.manage().window().maximize();
		
	}

	public void closeBrowser() {
		
		  driver.quit();
	
	}
	public void login(String a, String b) throws InterruptedException {
		 email.sendKeys(a);
		  pass.sendKeys(b);
		 signInButton.click();
		  Thread.sleep(2000);
	}
	public String readUserNameErr() {
		String actualErr = emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}
	public String readPassErr() {
		
		String actualErr = passErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	public String EmailPassErr() {
		String actualErr = emailpassErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}
