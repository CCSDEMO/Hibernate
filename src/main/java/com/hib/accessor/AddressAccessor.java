package com.hib.accessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.hib.constants.DBQueryConstants;
import com.hib.entity.Account;
import com.hib.entity.Address;
import com.hib.mapper.AddressMapper;
import com.hib.mapper.GenericMapper;
import com.hib.utility.ConnectionManager;
import com.hib.utility.PropertiesReader;

public class AddressAccessor {

	public Address findAddressByAddressNo(int addrNo) throws SQLException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		// String GET_ADDRESS_DETAILS_SQL = " SELECT ADDRESS_NO,ADDRESS_LINE1,ADDRESS_LINE2,CITY,STATE,ZIP,COUNTRY FROM ADDRESS WHERE ADDRESS_NO=?";
		Address address = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;

		/*
		 * String DRIVERCLASS = "com.mysql.cj.jdbc.Driver"; String URL =
		 * "jdbc:mysql://localhost:3306/hidb"; String USERNAME = "root"; String PASSWORD
		 * = "root";
		 */

		try {
			// Class.forName(DRIVERCLASS);

			// con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			//con = CMStatic.newConnection(); ststic method
			con=ConnectionManager.getInstance().newConnection();//using singleton

			pstmt = con.prepareStatement(DBQueryConstants.GET_ADDRESS_DETAILS_SQL);
			pstmt.setInt(1, addrNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				//2.address=AddressMapper.mapResultSetRecToAddress(rs);
				/*
				 * address = new Address(); address.setAddrNo(rs.getInt(1));
				 * address.setAddrLine1(rs.getString(2)); address.setAddrLine2(rs.getString(3));
				 * address.setCity(rs.getString(4)); address.setState(rs.getString(5));
				 * address.setZip(rs.getString(6)); address.setCountry(rs.getString(7));
				 */
				//3.
				
				
				//Properties colsToAttributesProps=new Properties();
				//4.here each and evry class we are loading cols and attribute into properties so code will be duplicated
				//instead of writting evry time we will write in properties file and load it here 
				
				/*colsToAttributesProps.put("address_no", "addrNo");
				colsToAttributesProps.put("address_line1", "addrLine1");
				colsToAttributesProps.put("address_line2", "addrLine2");
				colsToAttributesProps.put("city", "city");
				colsToAttributesProps.put("state", "state");
				colsToAttributesProps.put("zip", "zip");
				colsToAttributesProps.put("country", "country");*/
				
				
				//5.again every time reading properties file so write this reading logic in one place and use here code will be optimized
				
				//colsToAttributesProps.load(this.getClass().getClassLoader().getResourceAsStream("address.properties"));
				
				//6.
				//colsToAttributesProps=PropertiesReader.getReader("address.properties");
				
				//7.for the sake of GM accessor classes reading the data from props and passs it to GM so not req 
				//call this directly in GM itself bcoz for accessors this logic is not req
				
				//address=(Address) GenericMapper.mapRecToObject(rs, Address.class, colsToAttributesProps);
				//address=(Address) GenericMapper.mapRecToObject(rs, Address.class,"address.properties");
				address=(Address) GenericMapper.mapRecToObject(rs, Address.class);
			}

		}

		finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				// do nothing
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// do nothing
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				// do nothing
			}

		}

		return address;

	}
}
