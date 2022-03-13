package com.hib.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.hib.accessor.AccountAccessor;
import com.hib.accessor.AddressAccessor;
import com.hib.entity.Account;
import com.hib.entity.Address;

public class OrmTest {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		AccountAccessor accAccessor=new AccountAccessor();
		AddressAccessor addressAccessor=new AddressAccessor();
		try {
			Account account=accAccessor.findAccountByAccountNo(101);
			Address address=addressAccessor.findAddressByAddressNo(11);
			System.out.println(account);
			System.out.println(address);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
