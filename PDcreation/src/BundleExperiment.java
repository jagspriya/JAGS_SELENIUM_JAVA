import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class BundleExperiment {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		PDutil pdu = new PDutil();
		 String pd = "PP2 - 7Day - All (Full)"; //pdu.getProp("pd1");  
	 
		WebDriver driver ;
		driver = new FirefoxDriver();
		driver.get("https://test.salesforce.com/");

		driver.findElement(By.id("username")).sendKeys("crm.admin@newsint.co.uk.uat");

		driver.findElement(By.id("password")).sendKeys("England2013");
		driver.findElement(By.id("Login")).click();

		Thread.sleep(5000);

		//driver.findElement(By.cssSelector("span.mruText")).click();
		//driver.findElement(By.linkText(pd)).click();
		 
		driver.findElement(By.cssSelector("img.allTabsArrow")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[45]/td[1]/a[1]")).click();
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("new")).click();
	 
		driver.findElement(By.id("opp3")).sendKeys(pd);
				 
		driver.findElement(By.id("opp4")).sendKeys("The Times Product Owner");
	 
		driver.findElement(By.id("opp9")).sendKeys("05/09/2080");
		new Select(driver.findElement(By.id("opp11"))).selectByVisibleText("Prospecting");
		driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();

        driver.findElement(By.name("new00N20000003BRJp")).click();
		
	    Thread.sleep(5000);
		
		driver.findElement(By.linkText("The Times")).click();
		
		
		 WebElement table2 = driver.findElement(By.xpath(".//*[@id='j_id0:j_id47:j_id55']/div/table/tbody"));
         List rows2 = table2.findElements(By.tagName("tr"));
         System.out.println(rows2.size());
   
		for (int i = 0; i<=rows2.size() ; i++)
			   
			   {
				          String pre2  =  ".//*[@id='j_id0:j_id47:j_id55:j_id56:" ;
				          String post2 = ":j_id57']/a" ;
				          String full3 = pre2 + i + post2 ; 
				          WebElement x = driver.findElement(By.xpath(full3));
				          x.getText();
				      if (x.getText().equals(pd) ){
			
		              	 driver.findElement(By.xpath(full3)).click();
		             	System.out.println(i);
			                   break;
		                
			   }
				   
			   }

	}

}
