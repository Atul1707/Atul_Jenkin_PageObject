/**
 * 
 */
package Maven.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Atul
 *
 */
public class SearchItem {

		WebDriver driver ;
		@FindBy(id="twotabsearchtextbox")
		WebElement searchField;
		
		@FindBy(xpath=".//*[@id='nav-search']/form/div[2]/div/input")
		WebElement searchSubmit;
		
		public  void SearchAnItem(WebDriver driver, String st){
			this.driver = driver;
			PageFactory.initElements(driver, this);
           searchField.sendKeys(st);			
			searchSubmit.click();
		}
	
		
		
		
		

	

}
