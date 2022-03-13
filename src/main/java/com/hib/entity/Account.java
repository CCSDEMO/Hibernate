package com.hib.entity;

import java.util.Objects;

public class Account {

	private String accountNo;
	private String accountHolderName;
	private String account_type;
	private String balence;
	private String emailAddress;
	private String branchCode;

		public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getBalence() {
		return balence;
	}

	public void setBalence(String balence) {
		this.balence = balence;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	public Account(String accountNo, String accountHolderName, String account_type, String balence, String emailAddress,
			String branchCode) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.account_type = account_type;
		this.balence = balence;
		this.emailAddress = emailAddress;
		this.branchCode = branchCode;
	}

	public Account() {
		super();
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountHolderName, accountNo, account_type, balence, branchCode, emailAddress);
	}

	



	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountHolderName=" + accountHolderName + ", account_type="
				+ account_type + ", balence=" + balence + ", emailAddress=" + emailAddress + ", branchCode="
				+ branchCode + "]";
	}

}
