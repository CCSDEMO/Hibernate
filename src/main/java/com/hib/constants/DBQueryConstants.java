package com.hib.constants;

public class DBQueryConstants {

	
	
	
	public DBQueryConstants() {
		
	}
	
	
	public static final String FIND_ACCOUNT_DETAILS_SQL = "select account_no,account_holder_name,account_type,balence,email_address,branch_code from account where account_no=?";
	public static final String GET_ADDRESS_DETAILS_SQL = " SELECT ADDRESS_NO,ADDRESS_LINE1,ADDRESS_LINE2,CITY,STATE,ZIP,COUNTRY FROM ADDRESS WHERE ADDRESS_NO=?";
	
	public static final String FIND_ACCOUNT_DETAILS_BRANCH_CODE_SQL = "select account_no,account_holder_name,account_type,balence,email_address,branch_code from account where branch_code=?";
}
