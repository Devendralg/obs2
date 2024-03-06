package com.obs.generic.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerImplimentationClass implements IRetryAnalyzer
{
	int count = 1;
	int retryCount = 3;

	public boolean retry(ITestResult result) 
	{
		if(count < retryCount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
