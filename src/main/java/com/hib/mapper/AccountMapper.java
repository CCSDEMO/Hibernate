package com.hib.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hib.entity.Account;

public class AccountMapper {

	
	public   static Account mapResultSetRecToAccount(ResultSet rs) throws SQLException {
		
		//dont write iteration logic bcoz quries may return deff result like one query will give one obj other query will give list ogobject
		// so write iteration logic in accessor class and pass to mapper mapper will read result set rec one by one and bind to entity class
		Account account=null;
		account = new Account();
		account.setAccountNo(rs.getString(1));
		account.setAccountHolderName(rs.getString(2));
		account.setAccount_type(rs.getString(3));
		account.setBalence(rs.getString(4));
		account.setEmailAddress(rs.getString(5));
		account.setBranchCode(rs.getString(6));
		return account;
		
	}
}
