package obs;

import org.testng.annotations.Test;

import com.obs.generic.utilities.WebdriverUtils;

public class AutoGenerater {
	@Test
	public void random()
	{
		WebdriverUtils w = new WebdriverUtils();
		for (int i = 1; i <=5; i++) 
		{
			System.out.println("---------------------------");
			System.out.println(w.nameGenerator());
			System.out.println(w.phoneNumberGenerator());
			System.out.println(w.emailGenerator());
			System.out.println(w.panGenerator());
			System.out.println(w.passwordGenerator());
			System.out.println("---------------------------");
			
			
		}
	}

}
