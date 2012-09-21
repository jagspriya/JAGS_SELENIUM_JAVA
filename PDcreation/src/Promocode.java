import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
 


public class Promocode {
	static WebDriver driver ;
	static PDutil pdu = new PDutil();
 	 
	public static void main(String[] args) throws InterruptedException, IOException {
	 
	
		
		String pd =  pdu.getProp("pd1");      
	 	 String camp = pdu.getProp("camp1");  
	 	 String DigiorPrint = pdu.getProp("DigiorPrint1"); 
	 	 String PrintType = pdu.getProp("PrintType1"); 
	 	 String ServiceActivation = pdu.getProp("ServiceActivation1");  
		
		driver = new FirefoxDriver();
 		driver.get("https://test.salesforce.com/");
 		driver.findElement(By.id("username")).sendKeys("crm.admin@newsint.co.uk.uat");
 		driver.findElement(By.id("password")).sendKeys("England2013");
		driver.findElement(By.id("Login")).click();
        Thread.sleep(5000);
        
 

		 
		 
        
        CampSearch( camp,  DigiorPrint, pd);
        

	}
	
	
	public static void CampSearch(String camp, String DigiorPrint,String pd) throws InterruptedException{
		  
		Thread.sleep(5000);
		  
		 try {
		 	driver.findElement(By.id("phSearchInput")).sendKeys(camp);
		    driver.findElement(By.id("phSearchButton")).click();
	      Thread.sleep(5000);
	 	  WebElement search = driver.findElement(By.xpath(".//*[@id='Campaign']/div[2]/div"));
		    List Srows = search.findElements(By.tagName("tr"));
		    String Sid = search.getAttribute("id");
	 
		    for (int i = 2; i<=Srows.size() ; i++)
			   {
	 		    	String full6 = 	 ".//*[@id='Campaign_body']/table/tbody/tr[" + i + "]/th/a" ;
	 	  
	 	          WebElement we1 = driver.findElement(By.xpath(full6));
		          we1.getText();
		    	 if (we1.getText().equals(camp) ){
	 	    		 driver.findElement(By.xpath(full6 )).click();
		    		 break;
		    	 }
			   }
		    		    		    
 
	 	    driver.findElement(By.xpath(".//*[@title='New Marketed Proposition']")).click();
	 	    driver.findElement(By.xpath(".//*[@id='CF00N20000003BVOH']")).sendKeys(pd);
		    driver.findElement(By.xpath(".//*[@id='00N20000003BVPQ']")).sendKeys(pd);
	 	    new Select(driver.findElement(By.xpath(".//*[@id='00N20000003BVPD']"))).selectByVisibleText(DigiorPrint);
		    new Select(driver.findElement(By.xpath(".//*[@id='00N20000003BVPG']"))).selectByVisibleText("bundle1");
	 	    driver.findElement(By.xpath(".//*[@id='00N20000003C3im']")).sendKeys("1");
	 	    driver.findElement(By.xpath(".//*[@id='00N20000003BVPC']")).sendKeys("01520000000hbtZ");
		    driver.findElement(By.xpath(".//*[@id='00N20000003BVPT']")).sendKeys("-1");
	 	    driver.findElement(By.xpath(".//*[@id='00N20000003BVPO']" )).click();
		    Thread.sleep(5000);
		    System.out.println("----------------------------------- DONE -------------------------");

 		    try{
 			    driver.findElement(By.xpath(".//*[@id='00N20000003BVPJ']" )).click(); 
 		 	    driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]" )).click();  	
	 	    driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]" )).click(); 
		    }
		    catch (NoSuchElementException h) {
	 			  
	 			 System.out.println("Light leloo.......it dosn't effect");  
	 			  
	 		  }
		    
		 }
		 
		  catch (NoSuchElementException h) {
			  
		  System.out.println("No Campain found");  
			  
		  }
		    
	
	}}

 