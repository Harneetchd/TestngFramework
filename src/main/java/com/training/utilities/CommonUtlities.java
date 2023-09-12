package com.training.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtlities
{
   public String getProperty(String key) throws IOException
   {
	  String path = "/Users/harneetkaur/eclipse-workspace/TestNGFramework/properties/application.properties";
	  
	  FileInputStream fileinput= new FileInputStream(path);
	  
	  //load the file input stream
	  Properties prop = new Properties();
	  prop.load(fileinput);
	  
	  String value = prop.getProperty(key);// when you pass the key , you get value: return type is String
	  
	  return value;
   }
}
 