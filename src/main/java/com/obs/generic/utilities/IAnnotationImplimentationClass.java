package com.obs.generic.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class IAnnotationImplimentationClass implements IAnnotationTransformer
{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) 
	{
		annotation.setRetryAnalyzer(com.obs.generic.utilities.IRetryAnalyzerImplimentationClass.class);
		
	}
	
}
