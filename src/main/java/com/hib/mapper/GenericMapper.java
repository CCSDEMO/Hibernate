package com.hib.mapper;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.hib.utility.PropertiesReader;

public class GenericMapper {

	/* public static Object mapRecToObject(ResultSet rs,Class<?>
	 entityClass,Properties colsToAttributesProps) throws InstantiationException,
	 IllegalAccessException, SQLException, NoSuchMethodException,
	SecurityException, IllegalArgumentException, InvocationTargetException {*/

	
	/*
	 * public static Object mapRecToObject(ResultSet rs, Class<?> entityClass,
	 * String propsFileName) throws InstantiationException, IllegalAccessException,
	 * SQLException, NoSuchMethodException, SecurityException,
	 * IllegalArgumentException, InvocationTargetException, IOException {
	 */
	 
		   public static Object mapRecToObject(ResultSet rs,Class<?> entityClass) throws IOException, SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		String attributeName = null;
		String setterMethod = null;
		Object entityObj = null;
		String colVal = null;
		Method method = null;
		
		String propsFileName="orm-config.properties";
		
		
		Properties colsToAttributesProps = new Properties();
		
		Properties ormConfigProps = new Properties();
		
		ormConfigProps = PropertiesReader.getReader(propsFileName);
		
		String entityMapperProps=ormConfigProps.getProperty(entityClass.getName());
		colsToAttributesProps=PropertiesReader.getReader(entityMapperProps);
		
		
		// get Class ref
		entityObj = entityClass.newInstance();

		/*
		 * System.out.println(colsToAttributesProps); for(Object colName1 :
		 * colsToAttributesProps.keySet()) { //System.out.println(colName1); //String
		 * keys= colsToAttributesProps.getProperty((String) colName1);
		 * System.out.println(colsToAttributesProps);
		 * System.out.println("@@@"+colsToAttributesProps.getProperty(
		 * "com.hib.entity.Address")); String s=
		 * colsToAttributesProps.getProperty("com.hib.entity.Address"); Properties p=
		 * PropertiesReader.getReader(s); System.out.println("888"+p); }
		 */
		 

		// Method[] method=entityClass.getDeclaredMethods();//get allthe methods
		// colsToAttributesProps.keySet();
		for (Object colName1 : colsToAttributesProps.keySet()) {
			// System.out.println(colName1);
			String colName = (String) colName1;
			//String colName=colsToAttributesProps.getProperty((String) colName1);
			colVal = rs.getString(colName);
			
			attributeName = colsToAttributesProps.getProperty((String) colName);//accountNo setAcoountNo
			// System.out.println(attributeName.substring(0,1).toUpperCase());
			
			// account.setAccountNo(rs.getString("acc_no"));
			setterMethod = "set" + attributeName.substring(0, 1).toUpperCase()
					+ attributeName.substring(1, attributeName.length());
			// System.out.println(attributeName.substring(1,attributeName.length()));
			// eg:acc.setAccNo("1");
			method = entityClass.getDeclaredMethod(setterMethod, String.class);
			
			method.invoke(entityObj, colVal);

		}

		return entityObj;

	}
		   
		   
		   

}
