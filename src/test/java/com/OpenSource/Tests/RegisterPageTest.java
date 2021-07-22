	package com.OpenSource.Tests;
	
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	
	import com.OpenSource.Utils.ExcelUtils;
	import com.qa.OpenSource.Base.BaseTest;
	
	public class RegisterPageTest extends BaseTest {
	
		@BeforeClass
		public void RegisterPageSetup() {
			registerpage = loginpage.navigateToRegisterPage();
	
		}
	
		@DataProvider
		public Object[][] getRegisterData() {
			Object data[][] = ExcelUtils.getTestData("registration");// return type of data [rovider shpuld return two
																		// dimensional array
			return data;
		}
	
		@Test(dataProvider = "getRegisterData")
		public void getRegisterationTest(String firstnamee, String lastname, String email, String telephone,
				String password, String subsribe) {
	
			registerpage.accountregistration(firstnamee, lastname, email, telephone, password, subsribe);
		}
	
	}
