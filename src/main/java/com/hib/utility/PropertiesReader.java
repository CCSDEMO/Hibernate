package com.hib.utility;

import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	
	public static Properties  getReader(String propsFileName) throws IOException {
		Properties props=new Properties();
		props.load(PropertiesReader.class.getClassLoader().getResourceAsStream(propsFileName));
		return props;
		
	}

}
