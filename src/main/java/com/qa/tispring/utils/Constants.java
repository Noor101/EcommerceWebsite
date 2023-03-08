package com.qa.tispring.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String Login_Page_Title = "Account Login";
	public static final String Account_Page_Title = "My Account";
	public static final String Account_Page_Header_Value = "Your Store";
	public static final int Account_Header_Count = 4;
	public static final String REGISTER_SHEET_NAME = "Registration";
	public static final String ACCOUNT_SUCCESS_MESSAGE = "Your Account Has Been Created!";

	public static List<String> getAccountSectionsList() {

		List<String> accountsList = new ArrayList<String>();
		accountsList.add("My Account");
		accountsList.add("My Orders");
		accountsList.add("My Affiliate Account");
		accountsList.add("Newsletter");

		return accountsList;

	}
}
