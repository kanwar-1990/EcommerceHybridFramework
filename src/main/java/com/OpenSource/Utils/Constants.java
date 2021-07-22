package com.OpenSource.Utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public final static String Login_Page_Title = "Account Login";
	public final static String Accounts_Page_Title = "My Account";
	public final static String Accounts_Page_Header = "Your Store";
	public final static int Account_Sections_List = 4;

	public static List<String> getAccountSectionList() {
		List<String> AccountSection = new ArrayList<String>();

		AccountSection.add("My Account");
		AccountSection.add("My Orders");
		AccountSection.add("My Affiliate Account");
		AccountSection.add("Newsletter");
		return AccountSection;

	}

}
