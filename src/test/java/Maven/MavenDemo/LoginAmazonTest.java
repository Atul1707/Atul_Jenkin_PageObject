package Maven.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAmazonTest {

	
	/**
	 * @param args
	 */
	
	public WebDriver driver;
	public String url ="https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin";
	 
	
	
@BeforeTest
public void LogintoAmazon(){
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get(url);
	LoginAmazon login = new LoginAmazon(driver);
	 login.LoginToAmazon("atulgosain05@gmail.com", "asdf1234");
	
}

@Test
public void VerifyLoginAmazon(){
	LoginAmazon login = new LoginAmazon(driver);
	System.out.println("Page Title: "+driver.getTitle());
	String actualUserName= login.LoginSuccess();
	Assert.assertEquals(actualUserName, "Hello, Atul");
	
	}
@Test(dependsOnMethods=("VerifyLoginAmazon"))
public void TestSearch(){
	SearchItem searchMoto = new SearchItem();
	searchMoto.SearchAnItem(driver, "Moto Turbo");
}

@AfterTest
public void closeWindow()
{
 driver.quit();
}
//@Test
//public void verifylogin(){
//	System.out.println("Page Title: "+driver.getTitle());
//	System.out.println(login.LoginSuccess("Atul"));
//}

}
