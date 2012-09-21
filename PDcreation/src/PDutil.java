import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;
 
  public class PDutil {
	  private static Logger logger = Logger.getLogger(PDutil.class);
  static WebDriver driver ;
  		public static void Linking(String pd, String camp,String DigiorPrint,String PrintType,String ServiceActivation ) throws InterruptedException   {
 		System.out.println(pd);
 	 
 		logger.info(pd);
		driver = new FirefoxDriver();
 		driver.get("https://test.salesforce.com/");
 		driver.findElement(By.id("username")).sendKeys("crm.admin@newsint.co.uk.uat");
 		driver.findElement(By.id("password")).sendKeys("England2013");
		driver.findElement(By.id("Login")).click();
        Thread.sleep(5000);
     
        driver.findElement(By.id("phSearchInput")).sendKeys(pd);
        driver.findElement(By.id("phSearchButton")).click();
        Thread.sleep(5000);
        //PD Search
        PDsearch(pd);
         try {
		     driver.findElement(By.xpath(".//*[@id='a1RW00000000gb8_00N20000003BRJd_body']/div/a[1]"));
		     driver.findElement(By.xpath(".//*[@id='a1RW00000000gb8_00N20000003BRJd_body']/div/a[1]")).click();
		  } catch (NoSuchElementException e) {		  }
         
           Thread.sleep(5000);
            WebElement table = driver.findElement(By.xpath(".//*[@class='bRelatedList']"));
		    List rows = table.findElements(By.tagName("tr"));
		    String id = table.getAttribute("id");
		    
		    int count = 0;
		    ArrayList<String> ALProductFromPDforBubdleAdd = new ArrayList<String>();
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
 		    	      String ProductFromPDforBubdleAdd = driver.findElement(By.xpath(full1)).getText();
 		    	      ALProductFromPDforBubdleAdd.add(ProductFromPDforBubdleAdd);
 		 
 		    	      Thread.sleep(5000);
		    	      driver.findElement(By.xpath(full1)).click();
 		    	    //Sub Page  
		  		    WebElement tableSub = driver.findElement(By.xpath(".//*[@class='bRelatedList']"));
		  		    String idSub = tableSub.getAttribute("id");
 			          String fullSub =  ".//*[@id='" +     		idSub     +  			          		"_body']/table/tbody/tr[2]/td[1]/a[1]" ;
 		    	      try {
						     driver.findElement(By.xpath(fullSub));
						     driver.navigate().back();
						     Thread.sleep(3000);
						  System.out.println(ProductFromPDforBubdleAdd + "..............Element Already Linked.....");
 						  } catch (NoSuchElementException e) {
 							   Thread.sleep(5000);
 					    	      driver.findElement(By.name("new00N20000003BRJi")).click();
 					    		  WebElement getAttributeDef = driver.findElement(By.xpath(".//*[@id='CF00N20000003BRJi']"));
 					    	      String val = getAttributeDef.getAttribute("value");
 						          System.out.println(getAttributeDef.getAttribute("value") + "--" + ALProductFromPDforBubdleAdd.size());
 						          logger.info(getAttributeDef.getAttribute("value") + "--" + ALProductFromPDforBubdleAdd.size());
	 					    	  driver.findElement(By.id("CF00N20000003BRLP")).sendKeys( val);
 					    		  driver.findElement(By.id("Name")).sendKeys( val);
 					    		  driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
 					    		  try {
					    		     driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]"));
					    		     driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
 					    		       driver.navigate().back();  driver.navigate().back(); driver.navigate().back(); driver.navigate().back();
    				    		       Thread.sleep(5000);
 					    		  } catch (NoSuchElementException f) {
 					    			 driver.navigate().back();  driver.navigate().back(); driver.navigate().back();
					    		       Thread.sleep(5000);
 					    		  }
 						  }
 		    	   }
 		   } 
 
		   for (int i = 0; i<=ALProductFromPDforBubdleAdd.size()-1; i++){
 			   System.out.println("Products for Bundle.............................." + ALProductFromPDforBubdleAdd.get(i));
 			   logger.info("Products for Bundle.............................." + ALProductFromPDforBubdleAdd.get(i));
  	      }
  	//Opportunity
 		driver.findElement(By.cssSelector("span.mruText")).click();
		driver.findElement(By.linkText(pd)).click();
 		driver.findElement(By.cssSelector("img.allTabsArrow")).click();
		Thread.sleep(5000);
 		driver.findElement(By.cssSelector(".listRelatedObject.opportunityBlock.title")).click();
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
       
  		for (int i = 0; i<=rows2.size() ; i++)
	 			   {
				          String pre2  =  ".//*[@id='j_id0:j_id47:j_id55:j_id56:" ;
				          String post2 = ":j_id57']/a" ;
				          String full3 = pre2 + i + post2 ; 
				          WebElement x = driver.findElement(By.xpath(full3));
				          x.getText();
				      if (x.getText().equals(pd) ){
	 	              	 driver.findElement(By.xpath(full3)).click();
		             	       break;
 			   }
 			   }
        int j = 21;
		for (int i = 0; i<=count-1 ; i++)
 			   {
 			ALProductFromPDforBubdleAdd.get(i);
 				          System.out.println(ALProductFromPDforBubdleAdd.get(i).replace(" ", "_"));
 				          logger.info(ALProductFromPDforBubdleAdd.get(i).replace(" ", "_"));
	 				          String prodString = ".//*[@id='" + ALProductFromPDforBubdleAdd.get(i).replace(" ", "_") + "_0_ctrlButtons']/a" ;
	 				          driver.findElement(By.xpath(prodString)).click();
				          Thread.sleep(5000);
				          driver.findElement(By.xpath("(//a[contains(text(),'Continue')])[2]")).click();
				          Thread.sleep(5000);
 				          j++;
			   }
 		  new Select(driver.findElement(By.id("Print_Type_0"))).selectByVisibleText(PrintType); 
 	 	   //ServiceActivation
 	  		Thread.sleep(3000);
	 	    new Select(driver.findElement(By.id("Service_Activation_0"))).selectByVisibleText(ServiceActivation);
  
 		 Thread.sleep(5000);
 		 //Finish
 		 driver.findElement(By.xpath( ".//*[@id='j_id0:configure:j_id82:frmConfigurator:j_id166:j_id167:j_id186:j_id187:CSFinishButton']")).click();
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath(".//*[@id='j_id0:j_id13:j_id16']/div[2]/table/tbody/tr[2]/td[3]/a")).click();
		 driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[3]")).click();
		 driver.findElement(By.xpath(".//*[@id='00N20000003BRVx']")).click();
		 driver.findElement(By.xpath(".//*[@id='00N20000003BRXt']")).click();
		 driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]")).click();
		 
		 		 
		 CampSearch(camp,DigiorPrint,pd);
 	}
 	//******************************************************************************************************************************************************************************
 	  public static void PDsearch(String pd) throws InterruptedException{
	      
 	     try{
   	      driver.findElement(By.xpath(".//*[@id='showMore-a1R']")).click();
   	      Thread.sleep(5000);
   	      System.out.println("Many product defs with similar name...........");
   	      logger.info("Many product defs with similar name...........");
   	       }
   	  
   	     catch (NoSuchElementException e) { System.out.println("NO Many product defs with similar name..........."); }  
 		  
 		  
 		  try{  

 		  WebElement search = driver.findElement(By.xpath(".//*[@id='cscfga__Product_Definition__c']/div[2]/div"));
		    List Srows = search.findElements(By.tagName("tr"));
		    String Sid = search.getAttribute("id");
		   
 		    for (int i = 2; i<=Srows.size() ; i++)
 			   {
 		    	String full6 = 	 ".//*[@id='cscfga__Product_Definition__c_body']/table/tbody/tr[" + i + "]/th/a" ;
 		     
 		          WebElement we1 = driver.findElement(By.xpath(full6));
		          we1.getText();
		    	 if (we1.getText().equals(pd) ){
 		    		 driver.findElement(By.xpath(full6 )).click();
		    		 break;
		    	 }
 			   }
	      }
	      
	      catch (NoSuchElementException e) {System.out.println("No PD found......."); logger.info("No PD found......." + e.getMessage());   }
	      
	      
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
 			 logger.error("No Campain found" + h.getMessage());
 			  
 		  }
		    
		    
	         } 
	 	public static  String getProp( String prop) throws IOException {   
	    	String versionString = null;
		   Properties mainProperties = new Properties();
		    FileInputStream file;
		    String path = "./crmn.properties";
		    file = new FileInputStream(path);
		    mainProperties.load(file);
		    file.close();
		    versionString = mainProperties.getProperty(prop);
        	return versionString ;
        	
        	 	
 	}
 	      
  
  
	 	public static Vector ReadCSV(String fileName, int sheet) {
	 	    Vector cellVectorHolder = new Vector();

	 	    try {
	 	            FileInputStream myInput = new FileInputStream(fileName);

	 	            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

	 	            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

	 	            HSSFSheet mySheet = myWorkBook.getSheetAt(sheet);

	 	            Iterator rowIter = mySheet.rowIterator();

	 	            while (rowIter.hasNext()) {
	 	                    HSSFRow myRow = (HSSFRow) rowIter.next();
	 	                    Iterator cellIter = myRow.cellIterator();
	 	                    Vector cellStoreVector = new Vector();
	 	                    while (cellIter.hasNext()) {
	 	                            HSSFCell myCell = (HSSFCell) cellIter.next();
	 	                            cellStoreVector.addElement(myCell);
	 	                    }
	 	                    cellVectorHolder.addElement(cellStoreVector);
	 	            }
	 	    } catch (Exception e) {
	 	            e.printStackTrace();
	 	    }
	 	    return cellVectorHolder;
	 	}}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
	 