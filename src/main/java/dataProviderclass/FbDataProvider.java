package dataProviderclass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FbDataProvider {
  
  //method--> dataprovider
  //String firstName, lastName, mobNum 
	
	@DataProvider(name = "FBRegression",parallel = true)
	public static String[][] fbDataSet() 
	{	
		String data[][]= {{"Pallavi","Dere","9874563242"},
				          {"Reshma","Jathar","9968754632"},
				          {"Teju","Deshpande","9875463212"}};
		return data;
		
	  
	 
	}
}
