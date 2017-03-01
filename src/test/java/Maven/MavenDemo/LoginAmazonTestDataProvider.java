/**
 * 
 */
package Maven.MavenDemo;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Atul
 *
 */
public class LoginAmazonTestDataProvider {
	
	public WebDriver driver;
	public String url ="https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin";
	
	@BeforeTest
	public void LoginPage(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Test(dataProvider="LoginData")
	public void LoginTry(String UserName, String UserPassword){
		LoginAmazon login = new LoginAmazon(driver);
		 login.LoginToAmazon(UserName, UserPassword);
		
	}
	@DataProvider(name ="LoginData")
	public Object[][] LoginData() throws BiffException, IOException{
		ReadDataFromDataSheet readExcel = new ReadDataFromDataSheet();
			Object[][] arrayObject = readExcel.getDataArray("C:\\Selenium\\SampleData1.xls", "Sheet1");
			return arrayObject;
			
	}
	

}
