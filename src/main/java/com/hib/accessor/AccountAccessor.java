package com.hib.accessor;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.hib.constants.DBQueryConstants;
import com.hib.entity.Account;
import com.hib.mapper.AccountMapper;
import com.hib.mapper.GenericMapper;
import com.hib.utility.CMStatic;
import com.hib.utility.ConnectionManager;
import com.hib.utility.PropertiesReader;

public class AccountAccessor {

	public Account findAccountByAccountNo(int accountNo)
			throws SQLException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		// String FIND_ACCOUNT_DETAILS_SQL = "select
		// account_no,account_holder_name,account_type,balence,email_address,branch_code
		// from account where account_no=?";
		Account account = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		 * String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
		 *  String URL =
		 * "jdbc:mysql://localhost:3306/hidb"; 
		 * String USERNAME = "root"; 
		 * String PASSWORD
		 * = "root";
		 */

		try {
			/*
			 * Class.forName(DRIVERCLASS); 
			 * con = DriverManager.getConnection(URL, USERNAME,
			 * PASSWORD);
			 */

			// con = CMStatic.newConnection();
			con = ConnectionManager.getInstance().newConnection();
			pstmt = con.prepareStatement(DBQueryConstants.FIND_ACCOUNT_DETAILS_SQL);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
             // if con= only one rec
			// while=multiple rec
			if (rs.next()) {

				

				// binding to account cls code is duplicated in 2 methods so wrte in separate
				// clss called Mapper
				/*
				 * account = new Account(); 
				 * account.setAccountNo(rs.getInt(1));
				 * account.setAccountHolderName(rs.getString(2));
				 * account.setAccount_type(rs.getString(3));
				 * account.setBalence(rs.getDouble(4));
				 * account.setEmailAddress(rs.getString(5));
				 * account.setBranchCode(rs.getString(6));
				 */
				// 2.account=AccountMapper.mapResultSetRecToAccount(rs);

				// Properties colsToAttributesProps=new Properties();
				/*
				 * colsToAttributesProps.put("account_no", "accountNo");
				 * colsToAttributesProps.put("account_holder_name", "accountHolderName");
				 * colsToAttributesProps.put("account_type", "account_type");
				 * colsToAttributesProps.put("balence", "balence");
				 * colsToAttributesProps.put("email_address", "emailAddress");
				 * colsToAttributesProps.put("branch_code", "branchCode");
				 */

				// colsToAttributesProps.load(this.getClass().getClassLoader().getResourceAsStream("account.properties"));
				// 7.
				// colsToAttributesProps=PropertiesReader.getReader("account.properties");
				// account=(Account) GenericMapper.mapRecToObject(rs, Account.class,
				// colsToAttributesProps);
				account = (Account) GenericMapper.mapRecToObject(rs, Account.class);
			}

		} finally {
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
		return account;

	}

	public Account findAccountByBranchCode(String branchCode)
			throws SQLException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Account account = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionManager.getInstance().newConnection();
			pstmt = con.prepareStatement(DBQueryConstants.FIND_ACCOUNT_DETAILS_BRANCH_CODE_SQL);
			pstmt.setString(1, branchCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				/*
				 * 1.account = new Account(); account.setAccountNo(rs.getInt(1));
				 * account.setAccountHolderName(rs.getString(2));
				 * account.setAccount_type(rs.getString(3));
				 * account.setBalence(rs.getDouble(4));
				 * account.setEmailAddress(rs.getString(5));
				 * account.setBranchCode(rs.getString(6));
				 */
				// binding to account cls code is duplicated in 2 methods so wrte in separate
				// clss

				// 2.account=AccountMapper.mapResultSetRecToAccount(rs);

				// 3.so here always mapper logic is same for all enties means reading rec from
				// RS and
				// bind to entity class obj istead of wwwwritting mapper separatly we can use
				// one mapper
				// for all enties and tables

				// craete object for properties and put which col is mapped to which attr of
				// class and pass to GenMapper

				/* Properties colsToAttributesProps=new Properties();
				// colsToAttributesProps.setProperty("account_no", "accountNo");
				/*
				 * colsToAttributesProps.put("account_no", "accountNo");
				 * colsToAttributesProps.put("account_holder_name", "accountHolderName");
				 * colsToAttributesProps.put("account_type", "account_type");
				 * colsToAttributesProps.put("balence", "balence");
				 * colsToAttributesProps.put("email_address", "emailAddress");
				 * colsToAttributesProps.put("branch_code", "branchCode");
				 */
				
				// 5.
				// colsToAttributesProps.load(this.getClass().getClassLoader().getResourceAsStream("account.properties"));
				
				// 6.
				// colsToAttributesProps=PropertiesReader.getReader("account.properties");
				// account=(Account) GenericMapper.mapRecToObject(rs, Account.class,
				// colsToAttributesProps);
				// 7.
				account = (Account) GenericMapper.mapRecToObject(rs, Account.class);
			}

		} finally {
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
		return account;

	}
}
