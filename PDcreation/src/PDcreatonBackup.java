 
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
 
public class PDcreatonBackup  {
 
	static WebDriver driver ;
	static PDutil pdu = new PDutil();
	public static String pd = "PP2 - Sunday - Mix (Full)";
	static String camp = "MP131";
	static String DigiorPrint = "Print";
    	
	public static void main(String[] args) throws InterruptedException   {
	 
		System.out.println(pd);
		driver = new FirefoxDriver();
		
		driver.get("https://test.salesforce.com/");
 
		driver.findElement(By.id("username")).sendKeys("crm.admin@newsint.co.uk.uat");
 
		driver.findElement(By.id("password")).sendKeys("England2013");
		driver.findElement(By.id("Login")).click();
		
       Thread.sleep(5000);
 
    	driver.findElement(By.id("phSearchInput")).sendKeys(pd);
 	
 	    driver.findElement(By.id("phSearchButton")).click();
 		
       Thread.sleep(5000);
 	
      PDsearch();
 	       
        Thread.sleep(5000);
   
	      
     WebElement table = driver.findElement(By.xpath(".//*[@class='bRelatedList']"));
		    List rows = table.findElements(By.tagName("tr"));
		    String id = table.getAttribute("id");
		    System.out.println(table.getAttribute("id"));
		    System.out.println(rows.size());
		    int count = 0;
		   for (int i = 2; i<=rows.size() ; i++)
		   
		   {
			          String pre =  ".//*[@id='" +     		id     +  			          		"_body']/table/tbody/tr[" ;
			          String post = "]/td[3]" ;
			          String full = pre + i + post ;
			          
			          
			          WebElement x = driver.findElement(By.xpath(full));
			          x.getText();
			          
			          //Checkbox
			          
			          if (x.getText().equals("Checkbox") ){
			        	  
			        	  break;
			          
			          }
			          
			          
			      if (x.getText().equals("Related Product") ){
			      	  count++;
		    	      String post1 = "]/th/a" ;
		    	      String full1 = pre + i + post1 ;
		    	      
		    	      Thread.sleep(5000);
		    	      
		    	      driver.findElement(By.xpath(full1 )).click();
		    	      Thread.sleep(5000);
		    	      
		    	      driver.findElement(By.name("new00N20000003BRJi")).click();
		    	      	 
		    	      
		    		  WebElement getAttributeDef = driver.findElement(By.xpath(".//*[@id='CF00N20000003BRJi']"));
		    		  
		    		  
		    	      String val = getAttributeDef.getAttribute("value");
		    	      
		    	      
			          System.out.println(getAttributeDef.getAttribute("value"));
			          
			          
		    	      driver.findElement(By.id("CF00N20000003BRLP")).sendKeys( val);
		    	      
		    		  driver.findElement(By.id("Name")).sendKeys( val);
		    		  
		    		  driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
		    		  
		    		  Thread.sleep(5000);
 
		    			 driver.navigate().back();
		    		       driver.navigate().back();
		    		       driver.navigate().back();
		    		       Thread.sleep(5000);
		    			 
		    	   }
			   
			   
		   } 
 
	
 	//Opportunity
	 
		 
		driver.findElement(By.cssSelector("span.mruText")).click();
		driver.findElement(By.linkText(pd)).click();
		 
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
		
	
		
 	    new Select(driver.findElement(By.id("Print_Type_0"))).selectByVisibleText("Voucher"); 
  		new Select(driver.findElement(By.id("Service_Activation_0"))).selectByVisibleText("Voucher 7 Day");
 		
        System.out.println(count + "...............Tokka.............");
		 
        int j = 21;
		for (int i = 0; i<=count-1 ; i++)
			   
			   {
				         
			              String pre5  =  ".//*[@id='j_id0:configure:j_id82:frmConfigurator:j_id166']/div[2]/div[" ;
				          String post5 = "]/table/tbody/tr/td[1]/label" ;
				          String full5 = pre5 + j + post5 ; 
				          WebElement x5 = driver.findElement(By.xpath(full5));
				          x5.getText();
				          System.out.println(x5.getText());
				    
		                
				          x5.getText().replace(" ", "_");
			 
				          System.out.println(x5.getText().replace(" ", "_"));
				          
				          String prodString = ".//*[@id='" + x5.getText().replace(" ", "_") + "_0_ctrlButtons']/a" ;
				          
				          driver.findElement(By.xpath(prodString)).click();
				          Thread.sleep(5000);
				          driver.findElement(By.xpath("(//a[contains(text(),'Continue')])[2]")).click();
				          Thread.sleep(5000);
				          
				          j++;
			   }
		
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath( ".//*[@id='j_id0:configure:j_id82:frmConfigurator:j_id166:j_id167:j_id186:j_id187:CSFinishButton']")).click();
		 Thread.sleep(5000);
		 CampSearch();

	}
	
	
	
	  public static void PDsearch(){
	        WebElement search = driver.findElement(By.xpath(".//*[@id='cscfga__Product_Definition__c']/div[2]/div"));
		    List Srows = search.findElements(By.tagName("tr"));
		    String Sid = search.getAttribute("id");
		    System.out.println(Srows.size());
	        
		    for (int i = 2; i<=Srows.size() ; i++)
				   
			   {
		    	
		    	String full6 = 	 ".//*[@id='cscfga__Product_Definition__c_body']/table/tbody/tr[" + i + "]/th/a" ;
		    	
		    	System.out.println(i);
		    	  
		          WebElement we1 = driver.findElement(By.xpath(full6));
		          we1.getText();
		    	 if (we1.getText().equals(pd) ){
		    	
		    		 
		    		 
		    		 
		    		 driver.findElement(By.xpath(full6 )).click();
		    		 break;
		    	 }
		    	
			   }
		 
	        } 
	        
	
	 
	  
	  public static void CampSearch() throws InterruptedException{
		 	driver.findElement(By.id("phSearchInput")).sendKeys(camp);
			
		    driver.findElement(By.id("phSearchButton")).click();
			
	      Thread.sleep(5000);
			
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
	        
	
	
	  
	  
	  
	  
	  
	  
	  
	  
	
	

 
	
	
	
	

 
