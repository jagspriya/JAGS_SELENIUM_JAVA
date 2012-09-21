import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Camp2   {
	static WebDriver driver ;
	public static String pd = "PP2 - 7Day - Print (Full)";
	static String camp = "MP113";
	static String DigiorPrint = "Digi";
	
	public static void main(String[] args) throws InterruptedException {

		
PDutil pdu = new PDutil();


        login( );
		pdu.CampSearch(camp, DigiorPrint, pd);
   } 
		        
	
//**************************************************************************************************
public static void login( ) throws InterruptedException {
driver.get("https://test.salesforce.com/");

driver.findElement(By.id("username")).sendKeys("crm.admin@newsint.co.uk.uat");

driver.findElement(By.id("password")).sendKeys("England2013");
driver.findElement(By.id("Login")).click();

Thread.sleep(5000);

}	
		

	}

 
