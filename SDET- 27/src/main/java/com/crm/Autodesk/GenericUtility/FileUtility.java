package com.crm.Autodesk.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author HRITIK
 *
 */
public class FileUtility {
/**
 * It is used to read the data from commonData.properties File base on key which you pass as an argument.
 * @param key
 * @throws Throwable 
 * 
 */
public String getPropertykeyValue(String key) throws Throwable {
	FileInputStream fis = new FileInputStream("./data/commonData.property");
	Properties pObj = new Properties();
	pObj.load(fis);
	String value = pObj.getProperty(key);
	return value;
}
	}

