package Maven.MavenDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataProviderExample {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
By userEmail = By.xpath(".//*[@id='ap_email']");
By userPassword = By.id("ap_password");
By loginBtn = By.xpath(".//*[@id='signInSubmit']");
By UserName =By.xpath(".//*[@id='nav-link-yourAccount']/span[1]");

public void LoginAmazon(WebDriver driver){
	
	this.driver = driver;
}

public void LoginToAmazon(String useremailId, String UserPassword)
{
	driver.findElement(userEmail).sendKeys(useremailId);
	driver.findElement(userPassword).sendKeys(UserPassword);
	driver.findElement(loginBtn).click();
}
public String LoginSuccess ()	{
	String actualUser= driver.findElement(UserName).getText();
	return actualUser;
}

}
	
	

