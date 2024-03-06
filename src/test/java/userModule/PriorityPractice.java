package userModule;

import org.testng.annotations.Test;

public class PriorityPractice 
{
	@Test
	public void create() {
		System.out.println("--Create--");
	}
	@Test
	public void edit() {
		System.out.println("--Edit--");
	}

	@Test
	public void graph() {
		System.out.println("--Graph--");
	}

	@Test(dependsOnMethods = "edit")
	public void delete() {
		System.out.println("--Delete--");
	}

}
