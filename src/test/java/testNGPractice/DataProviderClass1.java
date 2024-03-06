package testNGPractice;

import org.testng.annotations.DataProvider;

public class DataProviderClass1 
{
			
	@DataProvider (name = "login")
	public Object[][] second()
	{
		Object [][] obj=new Object[2][3];
		obj[0][0]="kk";
		obj[0][1]="ll";
		obj[0][2]="pp";
		
		obj[1][0]="ww";
		obj[1][1]="44";
		obj[1][2]="555";
		
		return obj;
	}

}
