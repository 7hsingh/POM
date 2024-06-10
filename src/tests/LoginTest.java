package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;


public class LoginTest {
	
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
  lp.openBrowser();
	  lp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	lp.closeBrowser();
	  
  }
  @Test (priority = 1)
  public void wrongEmail() throws InterruptedException {
	 lp.login(df.wrongusername, "");
	  
	  String expected = "Epic sadface: Password is required";
	  String Actual = lp.readUserNameErr();
	  Assert.assertEquals(expected, Actual);
	  
  }
 @Test (priority = 2)
  public void wrongPassword() throws InterruptedException {
lp.login("", df.wrongpass);
	  
	  String expected = "Epic sadface: Username is required";
	  String Actual = lp.readPassErr();
	  Assert.assertEquals(expected, Actual);
}
  @Test (priority = 3)
  public void wrongEmailPassword() throws InterruptedException {
	  lp.login(df.wrongusername, df.wrongpass);
	  
	  String expected = "Epic sadface: Username and password do not match any user in this service";
	  String Actual = lp.EmailPassErr();
	  
	  Assert.assertEquals(expected, Actual);
	  
  }  
  }
