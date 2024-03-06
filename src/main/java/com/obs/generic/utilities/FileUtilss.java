package com.obs.generic.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilss 
{
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.PropFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
	/**
	 * This method is used to write the data into property file
	 * @param key
	 * @param value
	 * @throws IOException
	 */
	public void writeDataIntoProperyFile(String key,String value) throws IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.PropFilePath);
		Properties p = new Properties();
		p.load(fis);
		p.setProperty(key, value);		
	}
	
	
	
}
