package com.hib.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hib.entity.Account;
import com.hib.entity.Address;

public class AddressMapper {

	
public   static Address mapResultSetRecToAddress(ResultSet rs) throws SQLException {
		
		//dont write iteration logic bcoz quries may return deff result like one query will give one obj other query will give list ogobject
		// so write iteration logic in accessor class and pass to mapper mapper will read result set rec one by one and bind to entity class
	Address address=null;
	address = new Address();
	address.setAddrNo(rs.getString(1));
	address.setAddrLine1(rs.getString(2));
	address.setAddrLine2(rs.getString(3));
	address.setCity(rs.getString(4));
	address.setState(rs.getString(5));
	address.setZip(rs.getString(6));
	address.setCountry(rs.getString(7));
	return address;
		
	}
}
