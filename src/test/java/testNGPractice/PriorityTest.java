package testNGPractice;

import org.testng.annotations.Test;

public class PriorityTest 
{
	@Test (dependsOnMethods ="delete")
	public void create()
	{
		System.out.println("Create");
	}
	@Test 
	public void edit()
	{
		System.out.println("edit");
	}
	@Test (dependsOnMethods = "edit")
	public void delete()
	{
		int []a = {1,2,3,4};
		//System.out.println(a[2]);
		System.out.println("delete");
	}

}
