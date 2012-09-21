 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.openqa.selenium.*;
 
public class PD3  {
 	static WebDriver driver ;
	static PDutil pdu = new PDutil();
 	public static void main(String[] args) throws InterruptedException, IOException   {
 		 String fileName = "H:\\IMACROS\\XM-CREATOR\\jags.xls";
         Vector dataHolder = pdu.ReadCSV(fileName,2);
          for (int i = 1; i < dataHolder.size(); i++) {
                Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
                ArrayList<String> values = new ArrayList<String>();
                   for (int j = 0; j < cellStoreVector.size(); j++) {
                         HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
                        String stringCellValue = myCell.toString();
                         values.add(stringCellValue);
                }
                  pdu.Linking(values.get(0), values.get(1), values.get(4), values.get(2), values.get(3));
           }
  }

} 
  
///////////////Archive//////////////////////////////////////////////////////////



/*

                   System.out.print(values.get(0)); //PD
                  System.out.print(values.get(1));  //camp
                  System.out.print(values.get(2)); //print Type
                  System.out.print(values.get(3)); //Service Activation
                  System.out.print(values.get(4)); //Digi or print
                  System.out.print("----------Do Some Thing");


//		 String pd =  pdu.getProp("pd1");      
//		 String camp = pdu.getProp("camp1");  
//		 String DigiorPrint = pdu.getProp("DigiorPrint1"); 
//		 String PrintType = pdu.getProp("PrintType1"); 
//		 String ServiceActivation = pdu.getProp("ServiceActivation1"); 
//		 
//         pdu.Linking(pd, camp, DigiorPrint, PrintType, ServiceActivation);







*/