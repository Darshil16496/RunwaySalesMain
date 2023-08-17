package com.crm.genericUtility;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {
	/**
	 * @ This Method is used to get data fromPropertis File
	 * @author Darshil
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromProperties(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.filepath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
	
	
}
