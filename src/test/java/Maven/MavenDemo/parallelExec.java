package Maven.MavenDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class parallelExec {
	
	@Test
	public void exec(){
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		System.out.println(driver1.getTitle());
		System.out.println("Thread # is "+Thread.currentThread().getId());
	}
	@Test
	public void exec1(){
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		System.out.println(driver2.getTitle());
		System.out.println("Thread # is "+Thread.currentThread().getId());
	}

}
