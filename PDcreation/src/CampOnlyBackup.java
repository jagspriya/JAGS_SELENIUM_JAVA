import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class CampOnlyBackup   {
	static WebDriver driver ;
	public static String pd = "PP2 - Sunday - Mix (CC)";
	static String camp = "MP132";
	static String DigiorPrint = "Print";
	
	public static void main(String[] args) throws InterruptedException {


driver = new FirefoxDriver();
		
		driver.get("https://test.salesforce.com/");
 
		driver.findElement(By.id("username")).sendKeys("crm.admin@newsint.co.uk.uat");
 
		driver.findElement(By.id("password")).sendKeys("England2013");
		driver.findElement(By.id("Login")).click();
		
       Thread.sleep(5000);
		 

   	driver.findElement(By.id("phSearchInput")).sendKeys(camp);
	
	    driver.findElement(By.id("phSearchButton")).click();
		
      Thread.sleep(5000);
			
		//Camp Search
		        WebElement search = driver.findElement(By.xpath(".//*[@id='Campaign']/div[2]/div"));
			    List Srows = search.findElements(By.tagName("tr"));
			    String Sid = search.getAttribute("id");
			    System.out.println(Srows.size());
		        
			    for (int i = 2; i<=Srows.size() ; i++)
					   
				   {
			    	
			    	String full6 = 	 ".//*[@id='Campaign_body']/table/tbody/tr[" + i + "]/th/a" ;
			    	
			    	System.out.println(i);
			    	  
			          WebElement we1 = driver.findElement(By.xpath(full6));
			          we1.getText();
			    	 if (we1.getText().equals(camp) ){
			    	
			    		 
			    		 
			    		 
			    		 driver.findElement(By.xpath(full6 )).click();
			    		 Thread.sleep(5000);
			    		 break;
			    	 }
			    	
				   }
		 
			    Thread.sleep(5000);
			    driver.findElement(By.xpath(".//*[@title='New Marketed Proposition']")).click();
    
			    driver.findElement(By.xpath(".//*[@id='CF00N20000003BVOH']")).sendKeys(pd);
			    driver.findElement(By.xpath(".//*[@id='00N20000003BVPQ']")).sendKeys(pd);
			    
			    
			    new Select(driver.findElement(By.xpath(".//*[@id='00N20000003BVPD']"))).selectByVisibleText(DigiorPrint);
			    new Select(driver.findElement(By.xpath(".//*[@id='00N20000003BVPG']"))).selectByVisibleText("bundle1");
			    
			    
			    driver.findElement(By.xpath(".//*[@id='00N20000003C3im']")).sendKeys("1");
			 
			    driver.findElement(By.xpath(".//*[@id='00N20000003BVPC']")).sendKeys("01520000000hbtZ");
			    driver.findElement(By.xpath(".//*[@id='00N20000003BVPT']")).sendKeys("-1");
			    
			    
			    driver.findElement(By.xpath(".//*[@id='00N20000003BVPO']" )).click();
			    driver.findElement(By.xpath(".//*[@id='00N20000003BVPJ']" )).click(); 
			    
			    Thread.sleep(5000);
			    
			    driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]" )).click(); 
			    
			    
			    
		        } 
}

 
